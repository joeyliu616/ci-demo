#!/bin/sh

help()
{
    echo "$0 {service-name} {host-label} {portMapping}"
    echo "tips: $0 rest-api frontend -P"
}

if [ "$1" =  "" ];then
    echo "container label not set"
    help;
    exit 255
fi


if [ "$2" =  "" ];then
    echo "machine label not set"
    help;
    exit 255
fi

backendNum=$(docker-machine ls --filter label=itype=$2 -q | wc -l)

docker stop $(docker ps -a -q --filter label=$1) > /dev/null 2>&1
docker rm $(docker ps -a -q --filter label=$1) > /dev/null 2>&1

for i in `seq 1 $backendNum`
do
    docker run $3 -l $1 --net=overlay -e constraint:itype==$2 -e spring.profiles.active=it -d joey.pc:5000/$1
done