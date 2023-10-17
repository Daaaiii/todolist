FROM ubuntu:latest AS build 

RUN apt-get update
RUN apt-get install -y openjdk-21
RUN apt-get install maven -y

RUN mvn clean install 

COPY . .

FROM openjdk:21

EXPOSE 8081

COPY --from=build /target/todolist-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]