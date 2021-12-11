#!/bin/bash

PLATFORM_DIR=/opt/puls/platform

echo "Start Installing platform : Installation Directory" 
echo "$PLATFORM_DIR"

echo "Checking if platform already exist??"

if [ -d "$PLATFORM_DIR" ];
 then
   echo "Platform already deployed - please check installation directory /opt/puls/platform"
   exit 0i
 else
  mkdir -p $PLATFORM_DIR
fi


echo "Begin Installation Java"
tar -xvzf jdk-8u45-linux-x64.tar.gz -C $PLATFORM_DIR


echo "Creating symlink for java installation"
ln -s $PLATFORM_DIR/jdk1.8.0_45 $PLATFORM_DIR/java

echo "Begin installation Tomcat"
tar -xvzf apache-tomcat-7.0.47.tar.gz -C $PLATFORM_DIR

echo "Creating symlink for tomcat installation"
ln -s $PLATFORM_DIR/apache-tomcat-7.0.47 $PLATFORM_DIR/tomcat

echo "Begin install mysql"
tar -xvzf mysql-5.6.25-linux-glibc2.5-x86_64.tar.gz -C $PLATFORM_DIR

echo "Creating symlink for mysql"
ln -s $PLATFORM_DIR/mysql-5.6.25-linux-glibc2.5-x86_64 $PLATFORM_DIR/mysql

echo 'export JAVA_HOME=/opt/puls/platform/java' >> ~/.bashrc 
echo 'export CATALINA_HOME=/opt/puls/platform/tomcat' >> ~/.bashrc

source ~/.bashrc
echo "Installation success : please check $PLATFORM_DIR"
