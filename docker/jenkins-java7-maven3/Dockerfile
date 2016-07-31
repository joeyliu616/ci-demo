# use older version
FROM jenkins

ENV TZ "Asia/Shanghai" 

#install net-tools jdk git
USER root
RUN apt-get clean && \
	apt-get update && \
	apt-get install -y openjdk-7-jdk net-tools git openssh-server sudo
RUN rm -fr /var/lib/apt/lists/*

ADD dev-certs /docker-host-cert

EXPOSE 22
ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64
USER jenkins
