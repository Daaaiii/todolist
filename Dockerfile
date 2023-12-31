FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y


RUN apt-get install maven:3.9 -y
RUN mvn clean install

COPY . .

FROM openjdk:17-jdk-slim
EXPOSE 8081

COPY --from=build /target/todolist-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]