From joey.pc:5000/java:openjdk-7u91-jdk-alpine

COPY rest-api-pkg.tar.gz /var/data/rest-api.tar.gz
RUN tar -xf /var/data/rest-api.tar.gz -C /var/data

ENV spring.profiles.active=it

EXPOSE 18888

WORKDIR /var/data

ENTRYPOINT  ["java", "-jar", "rest-api.jar"]