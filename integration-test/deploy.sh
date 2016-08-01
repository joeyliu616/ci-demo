#!/bin/sh
echo $DOCKER_HOST

# start mysql
docker kill mysql > /dev/null 2>&1
docker rm mysql > /dev/null 2>&1
docker run --net=overlay --name mysql -e MYSQL_DATABASE=db_version -e MYSQL_ROOT_PASSWORD=root -e constraint:itype==misc -d joey.pc:5000/mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --default-storage-engine=InnoDB

#start redis
docker kill redis > /dev/null 2>&1
docker rm redis > /dev/null 2>&1
docker run  --name redis --net=overlay -e constraint:itype==misc --restart=always -d joey.pc:5000/redis