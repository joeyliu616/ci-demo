From java:openjdk-7u91-jdk-alpine

ADD target/version-service.jar /var/data/version-service.jar

ENV spring.profiles.active=ut

ENV spring.datasource.url=jdbc:mysql://db/db_version
ENV spring.datasource.username=root
ENV spring.datasource.password=root

WORKDIR /var/data

ENTRYPOINT  ["java", "-jar", "version-service.jar"]
