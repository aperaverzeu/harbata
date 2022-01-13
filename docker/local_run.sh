#!/bin/bash

docker-compose up -d mongo
sleep 5

cd ..
#mvn clean install -DskipTests -T 1C

./mvnw spring-boot:run