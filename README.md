# Quote of the Day API

API REST para gestionar frases motivacionales con un endpoint especial que devuelve la frase del día basada en la fecha actual.

## 🚀 Tecnologías

- Java 21
- Spring Boot 3.5.13
- PostgreSQL
- Spring Data JPA
- Lombok
- Swagger/OpenAPI
- Maven

## 📋 Características

- CRUD completo de frases motivacionales
- Filtrado por categoría
- Endpoint especial que devuelve la misma frase cada día del año
- Documentación interactiva con Swagger
- Arquitectura en capas (Controller → Service → Repository)

## 🔧 Requisitos previos

- JDK 21
- PostgreSQL 12+
- Maven 3.6+

## ⚙️ Configuración

1. Clonar el repositorio:
```bash
git clone https://github.com/Javacefu/quote-of-the-day-api.git
cd quote-of-the-day-api
```

2. Crear la base de datos en PostgreSQL:
```sql
CREATE DATABASE quotes_db;
```

3. Configurar las credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.username=postgres
spring.datasource.password=TU_PASSWORD_AQUI
```

O configurar la variable de entorno:
```bash
DB_PASSWORD=tu_password
```

4. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## 📖 Documentación API

Una vez iniciada la aplicación, accede a la documentación Swagger en:

http://localhost:8080/swagger-ui.html

## 🎯 Endpoints principales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/quotes` | Obtener todas las frases |
| GET | `/api/quotes/{id}` | Obtener frase por ID |
| GET | `/api/quotes/category/{category}` | Filtrar por categoría |
| GET | `/api/quotes/today` | Obtener la frase del día |
| POST | `/api/quotes` | Crear nueva frase |
| PUT | `/api/quotes/{id}` | Actualizar frase |
| DELETE | `/api/quotes/{id}` | Eliminar frase |

## 📝 Ejemplo de uso

**Crear una frase:**
```json
POST /api/quotes
{
  "content": "El éxito es la suma de pequeños esfuerzos repetidos cada día",
  "author": "Robert Collier",
  "category": "Motivación"
}
```

**Obtener la frase del día:**
```json
GET /api/quotes/today

Response:
{
  "id": 3,
  "content": "El conocimiento es poder",
  "author": "Francis Bacon",
  "category": "Conocimiento"
}
```

## 👤 Autor

**Javier** - [GitHub](https://github.com/Javacefu)

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la Licencia MIT.