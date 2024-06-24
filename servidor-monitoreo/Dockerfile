FROM openjdk:17-jdk-alpine
WORKDIR /monitoreo
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /monitoreo/server-monitoreo.jar
ENTRYPOINT ["java","-jar","/monitoreo/server-monitoreo.jar"]

