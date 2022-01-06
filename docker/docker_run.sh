#!/bin/bash

cd ..
mvn clean install -DskipTests

# shellcheck disable=SC2164
cd docker
docker-compose up -d mongo
sleep 5
docker-compose up -d app
