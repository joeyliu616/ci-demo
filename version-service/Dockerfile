From java:openjdk-7u91-jdk-alpine

ADD target/version-service.jar /var/data/version-service.jar

ENV spring.profiles.active=ut

WORKDIR /var/data

ENTRYPOINT  ["java", "-jar", "version-service.jar"]
