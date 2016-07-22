启动命令
docker run -p 8080:8080 -p 50000:50000 -v `pwd`/master-volume --dns=192.168.199.1 --restart=always -d --name=jenkis-master joeyliu616/jenkins-java7-maven3
