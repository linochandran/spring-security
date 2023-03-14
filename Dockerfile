FROM openjdk:17-alpine3.14
WORKDIR /usr/app
RUN mkdir -p "/usr/app/config"
COPY ./target/spring-security-0.0.1.jar /usr/app
COPY ./src/main/resources/*.yml /usr/app/config
ENTRYPOINT ["java", "-jar", "spring-security-0.0.1.jar"]
