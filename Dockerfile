FROM maven:3.9.9-amazoncorretto-21-alpine AS build

WORKDIR /app

COPY pom.xml /app/
COPY src /app/src/

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/technical-test-cyber-academy-incor.jar /app/technical-test-cyber-academy-incor.jar

ENTRYPOINT ["java", "-jar", "/app/technical-test-cyber-academy-incor.jar"]
