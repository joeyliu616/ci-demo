From joey.pc:5000/java:openjdk-7u91-jdk-alpine

COPY version-service-pkg.tar.gz  /var/data/version-service.tar.gz
RUN tar -xf /var/data/version-service.tar.gz -C /var/data

ENV spring.profiles.active=it
ENV spring.datasource.username=root
ENV spring.datasource.password=root

WORKDIR /var/data

ENTRYPOINT  ["java", "-jar", "version-service.jar"]