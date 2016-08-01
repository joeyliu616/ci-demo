#!/bin/sh
echo "Docker Host == >$DOCKER_HOST"

docker kill $1 > /dev/null 2>&1
docker rm $1 > /dev/null 2>&1