# use older version
FROM jenkins:1.651.3

ENV MAVEN_VERSION 3.3.9

#install net-tools jdk git
USER root
RUN apt-get clean && \
	apt-get update && \
	apt-get install -y openjdk-7-jdk net-tools git openssh-server sudo
RUN rm -fr /var/lib/apt/lists/*

#some times need to ssh to server. will figure out how to do ssh login without password
EXPOSE 22

ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64

# install jenkins
RUN curl -fsSL https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /usr/local \
  && mv /usr/local/apache-maven-$MAVEN_VERSION /usr/local/maven \
  && ln -s /usr/local/maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/local/maven
ADD settings.xml /usr/local/maven/conf
RUN mkdir -p /var/jenkins_home/.m2/setting.xml

USER jenkins

# install plugins 然而并没什么卵用. 并不能解析插件之间的依赖
# ADD plugins.txt /usr/share/jenkins/plugins.txt
# RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
