FROM ubuntu:latest AS build 

RUN apt-get update
RUN apt-get install openjdk:21-jdk-slim 

COPY . .
RUN apt-get install maven -y

RUN mvn clean install 

FROM openjdk:21-jdk-slim

EXPOSE 8081

COPY --from=build /target/todolist-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]