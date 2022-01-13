#!/bin/bash

docker-compose stop

docker container prune

docker volume prune