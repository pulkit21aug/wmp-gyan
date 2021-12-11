#!/bin/bash

PLATFORM_DIR=/opt/puls/platform
APP_HOME=/opt/puls/app

echo "Checking if platform already exist??"

if [ -d "$PLATFORM_DIR" ];
 then
   echo "Platform deployed on the machine "
   exit 0
 else
   exit 1
fi

echo "$PLATFORM_DIR : platform is deployed : Begin installing gyan-ecs rpm"




