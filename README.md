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

## Instalación
Para implementar esta aplicación usando Docker Compose, siga estos pasos: [1]

**Asegúrese de que Docker y Docker Compose estén instalados**: asegúrese de tener Docker y Docker Compose instalados en su máquina. Puede descargarlos desde el sitio web oficial de Docker (https://www.docker.com/get-started).
**Navegue hasta el directorio que contiene el archivo Docker Compose**: abra una terminal o símbolo del sistema y navegue hasta el directorio docker donde se encuentra el archivo `docker-compose.yml`.
**Cree las imágenes de Docker**: antes de ejecutar la aplicación, debe crear las imágenes de Docker para cada servicio. Puedes hacer esto ejecutando el siguiente comando:
- docker-compose build

Este comando creará las imágenes de Docker para todos los servicios definidos en el
docker-compose.yml
 archivo, incluyendo
informacion-personal
 y
cuentas-movimientos
  ademas de
postgres

.

**Inicie los servicios de Docker Compose**: una vez creadas las imágenes, puede iniciar los servicios ejecutando el siguiente comando:

- docker-compose  --profile core up


**Verificar el estado de los servicios**: Puede verificar el estado de los servicios en ejecución ejecutando el siguiente comando:
- docker-compose ps

**Detener los servicios**: cuando haya terminado de usar la aplicación, puede detener los servicios ejecutando el siguiente comando:
- docker-compose  --profile core down

[1] Docker Compose: Deploy a Containerized Application - DEV Community
dev.tooayandadocker-compose-deploy-a-containerized-php-application-52ll
[2] Docker Compose overview. Docker Compose is a tool that… | by Meghasharmaa | Apr, 2024 | Medium

#Author: Jeyson G Correa Martinez
