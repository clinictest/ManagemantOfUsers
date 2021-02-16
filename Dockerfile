
FROM maven:3.6.1-jdk-8-alpine as builder

MAINTAINER Author AndreiKviatkouski <a.kviatkouski@softteco.com>

WORKDIR /build
COPY pom.xml .
COPY src src

RUN mvn clean package

FROM openjdk:8-jdk-alpine

RUN apk add --no-cache curl tar bash

WORKDIR /app

FROM adoptopenjdk/openjdk8:alpine-slim

# Copy the jar to the production image from the builder stage.
COPY --from=builder /build/target/ManagemantOfUsers-1.0-SNAPSHOT.jar /app/app.jar

# Run the web service on container startup.
CMD ["java", "-jar", "target/ManagemantOfUsers.jar "]


