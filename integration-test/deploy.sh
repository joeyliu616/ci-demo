#!/bin/sh
echo "Docker Host == >$DOCKER_HOST"

# start mysql
sh ./cleanup.sh mysql
docker run --net=overlay --name mysql -e MYSQL_DATABASE=db_version -e MYSQL_ROOT_PASSWORD=root -e constraint:itype==misc -d joey.pc:5000/mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --default-storage-engine=InnoDB

#start redis
sh ./cleanup.sh redis
docker run  --name redis --net=overlay -e constraint:itype==misc --restart=always -d joey.pc:5000/redis

#start version-service
docker run -P --net=overlay -e constraint:itype==misc -e spring.profiles.active=it -d joey.pc:5000/version.service