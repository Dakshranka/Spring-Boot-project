# Blog RESTful API

A backend-only Spring Boot project that provides secure, role-based REST APIs for managing blog posts and comments. It includes user registration and login with JWT-based authentication, and supports `USER` and `ADMIN` roles.

## Features

- User registration and login
- Role-based access control (`USER`, `ADMIN`)
- CRUD operations for blog posts
- CRUD operations for comments
- RESTful API architecture (no frontend)
- MySQL database integration with Spring Data JPA (Hibernate)
- CSRF disabled for API-style authentication and testing

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Lombok

## Project Structure

```text
src/
├─ main/
│  ├─ java/com/thevarungupta/blog/rest/api/
│  │  ├─ config/         # Security and app configuration
│  │  ├─ controller/     # REST controllers (auth, posts, comments)
│  │  ├─ entity/         # JPA entities (User, Role, Post, Comment)
│  │  ├─ exception/      # Global exception handling
│  │  ├─ payload/        # DTOs / response objects
│  │  ├─ repository/     # Spring Data repositories
│  │  └─ service/        # Business logic
│  └─ resources/
│     └─ application.properties
└─ test/
   └─ java/...           # Unit / integration tests
```

## Setup and Installation

### Prerequisites

Make sure the following tools are installed:

- JDK 21
- Maven 3.9+
- MySQL 8+
- Postman (for API testing)

### Clone the Project

```bash
git clone <your-repository-url>
cd blog-rest-api
```

### Build the Project

Using Maven Wrapper (recommended):

```bash
./mvnw clean install
```

On Windows PowerShell:

```powershell
.\mvnw.cmd clean install
```

## Database Configuration

1. Create a MySQL database, for example:

```sql
CREATE DATABASE blog_api;
```

2. Open `src/main/resources/application.properties` and configure your DB credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_api
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

3. Save the file.

## Run the Application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

Default local URL:

```text
http://localhost:8080
```

## API Endpoint Examples

### Authentication

#### Register

`POST /api/auth/register`

Postman request:

- Method: `POST`
- URL: `http://localhost:8080/api/auth/register`
- Headers: `Content-Type: application/json`

```json
{
  "name": "John Doe",
  "username": "johndoe",
  "email": "john@example.com",
  "password": "Password@123"
}
```

#### Login

`POST /api/auth/login`

Postman request:

- Method: `POST`
- URL: `http://localhost:8080/api/auth/login`
- Headers: `Content-Type: application/json`

```json
{
  "usernameOrEmail": "johndoe",
  "password": "Password@123"
}
```

> Use the token returned by login in the `Authorization` header as `Bearer <token>` for protected endpoints.

### Blog Posts

Base path: `GET/POST/PUT/DELETE /api/posts`

Postman example (create post):

- Method: `POST`
- URL: `http://localhost:8080/api/posts`
- Headers:
  - `Content-Type: application/json`
  - `Authorization: Bearer <token>`

```json
{
  "title": "My First Post",
  "description": "Short summary",
  "content": "Post body content"
}
```

### Comments

Base path: `GET/POST/PUT/DELETE /api/comments`

Postman example (create comment):

- Method: `POST`
- URL: `http://localhost:8080/api/comments`
- Headers:
  - `Content-Type: application/json`
  - `Authorization: Bearer <token>`

```json
{
  "name": "Jane",
  "email": "jane@example.com",
  "body": "Great post!"
}
```

## Author

Daksh Ranka

