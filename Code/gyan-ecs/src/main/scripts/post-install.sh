#!/bin/bash

APP_HOME=/opt/puls/app
TOMCAT_FRONT=$APP_HOME/etc/config/tomcat-domains/front
TOMCAT_BACK=$APP_HOME/etc/config/tomcat-domains/back

echo "creating  softlinks"

#Tomcat domains already created create symlink for scripts

echo "$PLATFORM_DIR : Creating softlink"


#********************************************App_home folders*****
mkdir -p $APP_HOME/var/logs
mkdir -p $APP_HOME/var/run

sudo chmod 775 -R $APP_HOME/var 
sudo chown -R root:root $APP_HOME/var



#********************Front node**************************************************
mkdir -p $TOMCAT_FRONT/lib
sudo chown root:root $TOMCAT_FRONT/lib
sudo chmod 775 $TOMCAT_FRONT/lib


mkdir -p $TOMCAT_FRONT/work
sudo chown root:root $TOMCAT_FRONT/work
sudo chmod 775 $TOMCAT_FRONT/work

mkdir -p $TOMCAT_FRONT/temp
sudo chown root:root $TOMCAT_FRONT/temp
sudo chmod 775 $TOMCAT_FRONT/work

mkdir -p $TOMCAT_FRONT/bin
sudo chown root:root $TOMCAT_FRONT/bin
sudo chmod 775 $TOMCAT_FRONT/bin

mkdir -p $TOMCAT_FRONT/webapps
sudo chown root:root $TOMCAT_FRONT/webapps
sudo chmod 775 $TOMCAT_FRONT/webapps


mkdir -p $TOMCAT_FRONT/shared/lib
sudo chown root:root $TOMCAT_FRONT/shared/lib
sudo chmod 775 $TOMCAT_FRONT/shared/lib


mkdir -p $APP_HOME/var/logs/tomcat-front
sudo chown root:root $APP_HOME/var/logs/tomcat-front
sudo chmod 775 $APP_HOME/var/logs/tomcat-front



ln -s $APP_HOME/bin/set-env.sh $TOMCAT_FRONT/bin/set-env.sh
sudo chown root:root $TOMCAT_FRONT/bin/set-env.sh

ln -s $APP_HOME/var/logs/tomcat-front $TOMCAT_FRONT/logs
sudo chown -h root:root $TOMCAT_FRONT/logs



#*****************************************Back -node*****************************
mkdir -p $TOMCAT_BACK/lib
sudo chown root:root $TOMCAT_BACK/lib

mkdir -p $TOMCAT_BACK/work
sudo chown root:root $TOMCAT_BACK/work

mkdir -p $TOMCAT_BACK/work
sudo chown root:root $TOMCAT_BACK/work

mkdir -p $TOMCAT_BACK/bin
sudo chown root:root $TOMCAT_BACK/bin

mkdir -p $TOMCAT_BACK/webapps
sudo chown root:root $TOMCAT_BACK/webapps


mkdir -p $APP_HOME/var/logs/tomcat-back
sudo chown root:root $APP_HOME/var/logs/tomcat-back

ln -s $APP_HOME/bin/set-env.sh $TOMCAT_BACK/bin/set-env.sh
sudo chown root:root $TOMCAT_BACK/bin/set-env.sh

ln -s $APP_HOME/var/logs/tomcat-back $TOMCAT_BACK/logs
sudo chown -h root:root $TOMCAT_BACK/logs

