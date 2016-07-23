##启动命令
docker run -p 8080:8080 -p 50000:50000 -v <your dir to backup data>:/var/jenkins_home --dns=192.168.199.1 --restart=always -d --name=jenkis-master joeyliu616/jenkins

##工具与环境支持
添加了JDK7, git
添加了net-tools 用于网络检测 支持 ping, ifconfig, hostname等命令
添加了openssh-server
1. cp ~/.ssh/id_rsa.pub 至 <your dir to backup data> 重启容器
2. docker exec <container> /etc/init.d/ssh start
3. ssh -p <your exposed ssh port> jenkins@localhost

预装config-file-provider插件 用于自定义maven settings.xml文件. [使用方法](https://wiki.jenkins-ci.org/display/JENKINS/Config+File+Provider+Plugin)
PS: 由于文件权限原因， 你仍然需要在web页面安装maven支持