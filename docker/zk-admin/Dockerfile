FROM joey.pc:5000/axeclbr/leiningen

#get zk-web from here==> https://github.com/qiuxiafei/zk-web/releases
ADD zk-web-master.zip /zk-web.zip
RUN unzip /zk-web.zip && \
	mv /zk-web-master /zk-web

#use local repo to build it faster.
ADD zk-web-conf.clj /root/zk-web-conf.clj
ADD zk-web-conf.clj /zk-web/conf/zk-web-conf.clj

## set zk address to joey.pc:2181 listen port 8080
ADD project.clj /zk-web/project.clj
EXPOSE 8080

WORKDIR /zk-web

# get deps
RUN lein deps

CMD  ["lein", "run"]
