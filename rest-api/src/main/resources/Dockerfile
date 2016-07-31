From java:openjdk-7u91-jdk-alpine

COPY rest-api-pkg.tar.gz /var/data/rest-api-pkg.tar.gz
RUN tar -xvf /var/data/rest-api-pkg.tar.gz -C /var/data/

ENV spring.profiles.active=it

EXPOSE 18899

WORKDIR /var/data

ENTRYPOINT  ["java", "-jar", "rest-api.jar"]