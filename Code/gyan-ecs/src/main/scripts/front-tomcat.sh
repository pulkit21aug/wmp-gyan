#!/bin/bash

echo "Setting enviornment variables"
source set-env.sh
DEBUG_PORT=8000

export CATALINA_BASE=$APP_HOME/etc/config/tomcat-domains/front

export CATALINA_PID=$APP_HOME/var/run/front.pid

export CATALINA_OPTS="-Xmx512m -XX:-UseGCOverheadLimit \
-Dcom.sun.management.jmxremote=true \
-Dcom.sun.management.jmxremote.port=8008 \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false"

JAVA_OPTS="$JAVA_OPTS -Xms512m -Xmx712m -XX:PermSize=256m -XX:MaxPermSize=256m"
CATALINA_OPTS="${CATALINA_OPTS} -Xdebug -Xrunjdwp:transport=dt_socket,address=${DEBUG_PORT},server=y,suspend=n"

# Number of seconds to wait after nicely requesting stop
SHUTDOWN_WAIT=10


start() {

  pid=`cat $CATALINA_PID 2>/dev/null`

  if [ -n "$pid" ]
       then
       echo "Front Tomcat node is already running (pid: $pid)"
  else
      # Start tomcat
       echo "Starting front tomcat node"
       touch $CATALINA_PID
       $CATALINA_HOME/bin/catalina.sh start
  fi

   return 0
}

debug() {

	 pid=`cat $CATALINA_PID 2>/dev/null`
	 
	if [ -n "$pid" ]
       then
       echo "Front Tomcat node is already running (pid: $pid)"
  else
      # Start tomcat
       echo "Starting front tomcat node"
       touch $CATALINA_PID
       $CATALINA_HOME/bin/catalina.sh start
  fi

   return 0
}

stop() {

   pid=`cat $CATALINA_PID 2>/dev/null`

   if [ -n "$pid" ]
      then
         $CATALINA_HOME/bin/catalina.sh stop
         echo -n "Stopping front Tomcat node"

         let kwait=$SHUTDOWN_WAIT
         count=0;
            until [ `ps -p $pid | grep -c $pid` = '0' ] || [ $count -gt $kwait ]
               do
                 echo -n ".";
                 sleep 1
                 let count=$count+1;
               done

               echo ""

          if [ $count -gt $kwait ]; then
                 echo "process is still running after $SHUTDOWN_WAIT seconds, killing process"
                 kill $pid
                 sleep 3

                  # if it's still running use kill -9
                 if [ `ps -p $pid | grep -c $pid` -gt '0' ]; then
                    echo "process is still running, using kill -9"
                    kill -9 $pid
                    sleep 3
                 fi

          fi

          if [ `ps -p $pid | grep -c $pid` -gt '0' ]; then
                 echo "process is still running"
             else
                # success, delete PID file
                rm -f $CATALINA_PID

          fi

    else
       echo "Tomcat is not running"
   fi
    return 0
}


case $1 in
   start)
     start
     ;;
    
    startdebug)
      debug
      ;;
    
    stop)
      stop
     ;;

    restart)
      stop
      start
      ;;

restartdebug)
	 stop
      debug
      ;;
 
    status)
    pid=`cat $CATALINA_PID 2>/dev/null` 
    pid=$(tomcat_pid)
     if [ -n "$pid" ]
        then
        echo "Tomcat is running with pid: $pid"
      else
        echo "Tomcat is not running"
     fi
     ;;
    
    *) echo "Help - Pass arguments"
    echo "start :- to start tomcat"
    echo "stop :- to stop  tomcat"
    echo "restart:- to restart tomcat"
    echo "startdebug:- to start tomcat in debug mode"
    echo "restartdebug:- to restart tomcat in debug mode"
    ;; 
     
esac

exit 0



