# Usa una imagen base de OpenJDK con soporte para Java 23
FROM openjdk:23-jdk-slim AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado desde la carpeta build/libs a la carpeta del contenedor
COPY /build/libs/backend-0.0.1-SNAPSHOT.jar app.jar
# Expone el puerto en el que la aplicación Spring Boot se ejecutará
EXPOSE 8080

# Define el comando para ejecutar la aplicación Spring Boot dentro del contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]
