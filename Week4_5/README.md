# BookstoreAPI

## Overview
This project is a RESTful API for an Online Bookstore. It is developed using Spring Boot and demonstrates various key concepts, including RESTful web services, data handling, validation, security, testing, and API documentation.

## Project Setup

### Prerequisites
- Java 17
- Maven 3.6+
- IDE: IntelliJ IDEA (preferred)

### Dependencies
The project includes the following dependencies:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Starter HATEOAS
- Spring Boot Starter Security
- Spring Boot DevTools
- H2 Database
- Lombok
- Spring Boot Actuator
- Springdoc OpenAPI (for API documentation)
- JUnit and Mockito (for testing)

### How to Run
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean install` to install dependencies.
4. Start the application with `mvn spring-boot:run` or by running the main class in your IDE.

---

## Exercise 1: Setting Up RESTful Services

### Description
Setup a Spring Boot project for the Online Bookstore API.

### Steps
1. Initialize a new Spring Boot project with the necessary dependencies.
2. Explore and document new features introduced in Spring Boot 3.

---

## Exercise 2: Creating Basic REST Controllers

### Description
Develop RESTful endpoints to manage books.

### Steps
1. Create a `BookController` class in `src/main/java/com/Week4/5/bookstore/controller`.
2. Define endpoints for handling GET, POST, PUT, and DELETE requests.
3. Ensure the controller returns JSON responses.

### Example Endpoints
- `GET /books` - Retrieve all books
- `POST /books` - Add a new book
- `PUT /books/{id}` - Update a book by ID
- `DELETE /books/{id}` - Delete a book by ID

---

## Exercise 3: Handling Path Variables and Query Parameters

### Description
Enhance the book management endpoints with path variables and query parameters.

### Steps
1. Implement an endpoint to fetch a book by its ID.
2. Implement an endpoint to filter books based on title and author.

---

## Exercise 4: Processing Request Body and Form Data

### Description
Create endpoints to accept and process JSON request bodies and form data for customer registrations.

### Steps
1. Implement a `POST /customers` endpoint to create a new customer with a JSON request body.
2. Implement an endpoint to process form data for customer registrations.

---

## Exercise 5: Customizing Response Status and Headers

### Description
Customize HTTP response statuses and headers for book management endpoints.

### Steps
1. Use `@ResponseStatus` to customize HTTP status codes.
2. Add custom headers to the response using `ResponseEntity`.

---

## Exercise 6: Exception Handling in REST Controllers

### Description
Implement global exception handling for the bookstore RESTful services.

### Steps
1. Create a `GlobalExceptionHandler` class in `src/main/java/com/Week4/5/bookstore/exception`.
2. Define methods to handle exceptions and return appropriate HTTP status codes.

---

## Exercise 7: Introduction to Data Transfer Objects (DTOs)

### Description
Use DTOs for transferring data between the client and server for books and customers.

### Steps
1. Create `BookDTO` and `CustomerDTO` classes in `src/main/java/com/Week4/5/bookstore/dto`.
2. Use a library like MapStruct to map entities to DTOs and vice versa.
3. Customize JSON serialization/deserialization using Jackson annotations.

---

## Exercise 8: Implementing CRUD Operations

### Description
Implement Create, Read, Update, and Delete operations for the Book and Customer entities.

### Steps
1. Implement CRUD endpoints in the respective controllers.
2. Validate input data using annotations like `@NotNull`, `@Size`, and `@Min`.
3. Implement optimistic locking for concurrent updates using JPA versioning.

---

## Exercise 9: Understanding HATEOAS

### Description
Enhance the REST API to follow HATEOAS principles for resource navigation.

### Steps
1. Use Spring HATEOAS to add links to resources in API responses.
2. Build hypermedia-driven APIs.

---

## Exercise 10: Configuring Content Negotiation

### Description
Support different media types (JSON, XML) for the bookstore's RESTful services.

### Steps
1. Configure Spring Boot to support content negotiation.
2. Implement logic to produce and consume different media types based on the Accept header.

---

## Exercise 11: Integrating Spring Boot Actuator

### Description
Monitor and manage the bookstore's RESTful services using Spring Boot Actuator.

### Steps
1. Add the Spring Boot Actuator dependency.
2. Enable and customize Actuator endpoints.
3. Expose custom metrics for monitoring the application.

---

## Exercise 12: Securing RESTful Endpoints with Spring Security

### Description
Secure RESTful endpoints using Spring Security with JWT-based authentication.

### Steps
1. Integrate Spring Security into the project.
2. Implement JWT-based authentication and authorization.
3. Configure CORS to handle cross-origin requests.

---

## Exercise 13: Unit Testing REST Controllers

### Description
Write unit tests for the REST controllers using JUnit and Mockito.

### Steps
1. Set up JUnit and Mockito in the project.
2. Use `MockMvc` to write unit tests for the REST controllers.
3. Ensure comprehensive test coverage.

---

## Exercise 14: Integration Testing for REST Services

### Description
Write integration tests for the RESTful services.

### Steps
1. Set up Spring Test for integration testing.
2. Use `MockMvc` for end-to-end testing.
3. Include database integration in tests using an in-memory database like H2.

---

## Exercise 15: API Documentation with Swagger

### Description
Document REST APIs using Swagger and Springdoc.

### Steps
1. Add the Springdoc OpenAPI dependency.
2. Annotate REST controllers to generate API documentation.
3. Review the documentation using Swagger UI.

---

## Author
- **Your Name**

## License
This project is licensed under the MIT License - see the LICENSE file for details.

