# clients_message

Prueba técnica desarrollada en Spring Boot.

## Tecnologías

- Java
- Spring Boot
- Maven
- JPA
- Mockito
- JUnit

## Funcionalidad

Sistema para gestionar créditos y generar cuotas automáticamente.

#como levantar la bd 
CREATE DATABASE clients_message;
crear el usuario y contrasenia
CREATE USER clients_user WITH PASSWORD '4u52HKxRBb0z';
otorgarle permisos 
GRANT ALL PRIVILEGES ON DATABASE clients_message TO clients_user;
dar permisos sobre esquema public
GRANT ALL ON SCHEMA public TO clients_user;
permitir creacion de tablas
ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT ALL ON TABLES TO clients_user;

Instalar Ollama desde:
https://ollama.com
Luego ejecutar:
ollama pull llama3
Iniciar Ollama:
ollama serve
Esto levantará el servicio en:
http://localhost:11434

EJECUTAR LA APLICACION

Desde Eclipse
Ejecutar la clase:
ClientsMessageApplication
La aplicación se ejecutará en:
http://localhost:8080


El proyecto incluye pruebas unitarias utilizando:
JUnit
Mockito
Para ejecutar las pruebas:
mvn test

## Autor

Angie Huertas