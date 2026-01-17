# Task Tracker API

A RESTful API for managing tasks with CRUD operations built using Spring Boot. This application provides a complete backend solution for task management with status tracking, automatic timestamps, and validation.

## About

This project demonstrates a clean architecture approach using Spring Boot with:
- **Layered Architecture**: Separate controllers, services, and repositories
- **DTO Pattern**: Request/response objects for API communication
- **JPA Entities**: Database models with automatic timestamp management
- **Global Exception Handling**: Centralized error responses
- **Bean Validation**: Automatic request validation

The application uses an in-memory H2 database, making it perfect for development, testing, and quick demos without any external database setup.

## Tech Stack

- Java 17
- Spring Boot 4.0.1
- Spring Data JPA
- H2 Database (in-memory)
- Maven

## Getting Started

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Build

```bash
mvn clean install
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/api/tasks` | Create a new task |
| GET    | `/api/tasks` | Get all tasks |
| GET    | `/api/tasks/{id}` | Get task by ID |
| PUT    | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |

## Example Request

**Create Task:**
```json
POST /api/tasks

{
  "title": "Complete documentation",
  "description": "Write README file"
}
```

**Response:**
```json
{
  "id": 1,
  "title": "Complete documentation",
  "description": "Write README file",
  "status": "TODO",
  "createdAt": "2026-01-17T10:30:00Z",
  "updatedAt": "2026-01-17T10:30:00Z"
}
```

## Task Status

- `TODO` - Default status
- `DOING` - In progress
- `DONE` - Completed

## Database

The application uses H2 in-memory database for quick setup without configuration. Data is reset on each restart.

**H2 Console:** `http://localhost:8080/h2`
- JDBC URL: `jdbc:h2:mem:tasksdb`
- Username: `sa`
- Password: (empty)

## Features

- **CRUD Operations**: Complete create, read, update, and delete functionality
- **Status Tracking**: Track tasks through TODO, DOING, and DONE states
- **Timestamps**: Automatic createdAt and updatedAt fields
- **Validation**: Title is required; returns 400 for invalid requests
- **Error Handling**: Proper HTTP status codes (404 for not found, etc.)
- **No External Dependencies**: Runs without any external database setup

## Project Structure

```
task/
├── Task.java              # Entity model
├── TaskController.java    # REST endpoints
├── TaskService.java       # Business logic
├── TaskRepository.java    # Data access
└── dto/                   # Request/Response DTOs
```
