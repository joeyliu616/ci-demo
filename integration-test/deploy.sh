#!/bin/sh
echo "Docker Host == >$DOCKER_HOST"
basepath=$(cd `dirname $0`; pwd)

# start mysql
sh $basepath/cleanup.sh mysql
docker run --net=overlay --name mysql -e MYSQL_DATABASE=db_version -e MYSQL_ROOT_PASSWORD=root -e constraint:itype==misc -d joey.pc:5000/mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --default-storage-engine=InnoDB

#start redis
sh $basepath/cleanup.sh redis
docker run  --name redis --net=overlay -e constraint:itype==misc -d joey.pc:5000/redis

#start version-service
sh $basepath/startService.sh version-service backend

#start  rest-api
sh $basepath/startService.sh rest-api frontend -P
echo "$(docker ps --filter label=rest-api)"