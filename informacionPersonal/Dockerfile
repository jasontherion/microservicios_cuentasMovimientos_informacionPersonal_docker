FROM openjdk:17-jdk-alpine
WORKDIR /app
# empaquetamos la app y omitimos las pruebas con -DskipTest
# RUN mvn package -DskipTes
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]