#!/bin/bash
mvn clean
echo 'mvn clean done'
mvn package
echo 'mvn package done'
docker build --tag=expenses_app:latest .
echo 'docker build done'
docker-compose up