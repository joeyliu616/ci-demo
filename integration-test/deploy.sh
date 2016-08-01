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
docker run --net=overlay -e constraint:itype==backend -e spring.profiles.active=it -d joey.pc:5000/version-service
