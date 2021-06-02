FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait

