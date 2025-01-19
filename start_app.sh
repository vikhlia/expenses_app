#!/bin/bash
mvn clean install
echo 'mvn clean install done'
docker build --tag=expenses_app:latest .
echo 'docker build done'
docker-compose up