#!/bin/zsh

# alias for Java 17 LTS
# please be careful and remove if don't needed [or u don't have it on your local machine]
java17
cd ..
mvn clean install -DskipTests

# shellcheck disable=SC2164
cd docker
docker-compose up -d mongo
sleep 5
docker-compose up -d app
