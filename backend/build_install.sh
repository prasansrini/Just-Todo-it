#!/usr/bin/env bash

if [ "$1" == "" ]; then
  if [  "$2" == ""  ]; then
    echo "Please use as ./build_install.sh <db_username> <db_password>"
    exit 0
  fi
fi

mysql -h 127.0.0.1 -P 3306 -u "$1" --password="$2" < src/main/resources/todo_tracker.sql
mvn clean package
java -jar target/backend.jar