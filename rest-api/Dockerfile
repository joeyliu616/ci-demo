From java:openjdk-7u91-jdk-alpine

ADD target/rest-api.jar /var/data/rest-api.jar

ENV spring.profiles.active=ut

EXPOSE 18899

WORKDIR /var/data

ENTRYPOINT  ["java", "-jar", "rest-api.jar"]

