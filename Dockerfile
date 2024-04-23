FROM docker.arvancloud.ir/openjdk:17.0.1-jdk-slim

COPY ./target/*.jar  /app/app.jar
WORKDIR /app
EXPOSE 9801
ENTRYPOINT ["java","-jar","app.jar"]

#AxonServer
