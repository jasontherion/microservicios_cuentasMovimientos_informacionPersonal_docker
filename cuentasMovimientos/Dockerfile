FROM openjdk:17-jdk-alpine
WORKDIR /app
# empaquetamos la app y omitimos las pruebas con -DskipTest
# RUN mvn package -DskipTest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/cuentas-movimientos.jar
ENTRYPOINT ["java","-jar","/app/cuentas-movimientos.jar"]