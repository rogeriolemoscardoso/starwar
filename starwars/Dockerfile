FROM openjdk:8-jdk-alpine

RUN apk update && apk upgrade

LABEL maintainer="rogerio.lemos.cardosoo@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=/target/ame-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} ame-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ame-0.0.1-SNAPSHOT.jar"]
