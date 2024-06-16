# Proyecto de Microservicios con Docker Compose

Este proyecto utiliza Docker Compose para orquestar un conjunto de microservicios que incluyen una base de datos PostgreSQL y dos servicios de Spring Boot: `informacion-personal` y `cuentas-movimientos`.

## Requisitos Previos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Estructura del Proyecto

- `postgres`: Contenedor para la base de datos PostgreSQL.
- `informacion-personal`: Microservicio de información personal construido con Spring Boot.
- `cuentas-movimientos`: Microservicio de cuentas y movimientos construido con Spring Boot.

## Archivos de Configuración

### docker-compose.yml

```yaml
version: "3.8"

services:

  postgres:
    image: postgres:13.2
    container_name: "postgres"
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: postgres
    ports:
      - "5432:5432"
    volumes:
      - ../informacionPersonal/src/main/resources/db/BaseDatos.sql:/docker-entrypoint-initdb.d/BaseDatos.sql # Copiar el script SQL
    profiles:
      - core

  informacion-personal:
    build: ../informacionPersonal # Ruta al Dockerfile del microservicio informacionPersonal
    ports:
      - "8022:8022" # Mapeo el puerto del contenedor al host
    depends_on: # Esperar a que la base de datos esté lista antes de iniciar
      - postgres
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/postgres?useUnicode=true&characterEncoding=utf8 # Conectar a la base de datos en el contenedor 'postgres'
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres
    profiles:
      - core

  cuentas-movimientos:
    build: ../cuentasMovimientos # Ruta al Dockerfile del microservicio cuentasMovimientos
    ports:
      - "8021:8021" # Mapeo el puerto del contenedor al host
    depends_on:
      - postgres
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/postgres?useUnicode=true&characterEncoding=utf8 # Conectar a la base de datos en el contenedor 'postgres'
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres
    profiles:
      - core
