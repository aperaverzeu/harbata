#!/bin/bash

# shellcheck disable=SC2164
cd ../backend/slounik
mvn package

# shellcheck disable=SC2164
cd ../..
docker-compose up -d mongo
sleep 5
docker-compose up -d --build slounik
