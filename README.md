# Campaign Management Backend

This is the backend API for the Campaign Management System, built with **Spring Boot** and **H2 Database**.

## Features
- RESTful API for campaign management
- H2 database with an admin console
- User balance tracking with **Emerald Funds**

## Setup and Installation

### 1. Clone the repository
```sh
git clone https://github.com/HKordula/Campaigns-backend
cd campaign-backend
```

### 2. Configure the Database
Modify `src/main/resources/application.properties` if needed:

```properties
spring.datasource.url=jdbc:h2:file:./data/testdb
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### 3. Run the Application
Use **Maven** to build and start the backend:

```sh
./mvnw spring-boot:run
```

### 4. Access the API
Once running, the API is available at:
- **Base URL:** `http://localhost:8080/api`
- **H2 Console:** `http://localhost:8080/h2-console`
    - **JDBC URL:** `jdbc:h2:file:./data/testdb`
    - **Username:** `sa`
    - **Password:** *(leave empty)*

### 5. Example API Endpoints
- **Get all campaigns** → `GET http://localhost:8080/api/campaigns`
- **Add a campaign** → `POST http://localhost:8080/api/campaigns/{userId}`
- **Get user balance** → `GET http://localhost:8080/api/users/{userId}/balance`

## Deploying on Render
To deploy, make sure:
- Your database is **H2 file-based** (`jdbc:h2:file:./data/testdb`).
- You **enable the H2 console** for debugging.

Then, deploy on **Render** and access:
```
https://campaigns-mvur.onrender.com/
```
