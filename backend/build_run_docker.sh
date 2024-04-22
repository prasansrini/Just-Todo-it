#!/usr/bin/env bash

mvn clean package
#cd api-docker || exit
#pwd

docker rm java-backend

docker build -t java-backend .
#cd api-docker || exit
#docker build -t prasansrini29/java-backend-my-sql .

#docker rm java-backend

docker run --name backend-api -d -it -p 8080:8080 --network backend_network java-backend
#docker run --name sql-dock -d -it --network backend_network -e MYSQL_ROOT_PASSWORD=Password@29 -e MYSQL_DATABASE=todo_tracker prasansrini29/java-backend-my-sql
