
# 🧾 usuarios-mongodb

Microservicio REST desarrollado con Spring Boot y MongoDB para gestionar usuarios.

## 🚀 Características

- Registro de usuarios con validación de datos.
- MongoDB como base de datos (Docker).
- Estructura de respuesta estándar (`ApiResponseDTO` con `Meta`).
- Validación personalizada y manejo global de excepciones.
- Separación de entidades y DTOs (entrada y salida).
- Uso de índice único en MongoDB para evitar duplicados de correo.

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot 3.4.2
- MongoDB (vía Docker)
- Maven
- JUnit 5 + Mockito
- ModelMapper
- Lombok

## 📦 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/tuusuario/usuarios-mongodb.git
cd usuarios-mongodb
```


## Compilación

```bash
mvn clean install
```

## Ejecutar la aplicación


```bash
mvn spring-boot:run
````


## How to Test

Run all tests (unit and integration) using:

```bash
mvn test
````

## Endpoints

- **POST** `/api/v1/grupo-salinas-usuarios`
  ```
  {"nombre": "Luz",
  "apellidoPaterno": "Soriano",
  "correoElectronico": "luz@example.com",
  "fechaNacimiento": "1995-05-18",
  "aceptaTerminos": true}
  ```

- **GET** `/api/v1/grupo-salinas-usuarios`

  Devuelve la lista de todos los usuarios registrados.
  

## Ejecutar MongoDB con Docker

```bash
docker run -d \
--name mongo-auth \
-p 27017:27017 \
-e MONGO_INITDB_ROOT_USERNAME=root \
-e MONGO_INITDB_ROOT_PASSWORD=password \
mongo
```

- **Database Name**: `mongo-auth`
- **Username**: `root`
- **Password**: `password`
- **Port**: `27017`

- La configuración de conexión a la base de datos está definida en el archivo application.yml. ✅


## 🧪 Pruebas
Ejecutar todas las pruebas unitarias:

```bash
mvn test
```

## Cliente Postman

Hay una **colección adjunta* en la raíz de este proyecto con ejemplos de las diferentes respuestas que la aplicación puede retornar.
```bash
curl --location 'http://localhost:8080/api/v1/grupo-salinas-usuarios' \
--data-raw '{
  "nombre": "Luz",
  "apellidoPaterno": "Soriano",
  "correoElectronico": "mango@gmail.com",
  "fechaNacimiento": "1995-03-01",
  "aceptaTerminos": true
}
'
```