# Mapping_API
This project implements a Mapping API using Spring Boot. It provides REST API endpoints for managing students, laptops, courses, books, and addresses.

## Technologies Used
- Java
- Spring Boot
- Hibernate
- MySql
- Maven (Dependency management)

## API Endpoints
The following API endpoints are available:
### Students
- **POST /students:** Create a new student.
- **GET /students/{id}:** Get student by ID.
- **PUT /students/{id}:** Update an existing student.
- **DELETE /students/{id}:** Delete a student.

### Laptops
- **POST /laptops:** Create a new laptop.
- **GET /laptops/{id}:** Get laptop by ID.
- **PUT /laptops/{id}:** Update an existing laptop.
- **DELETE /laptops/{id}:** Delete a laptop.

### Courses
- **POST /courses:** Create a new course.
- **GET /courses/{id}:** Get course by ID.
- **PUT /courses/{id}:** Update an existing course.
- **DELETE /courses/{id}:** Delete a course.

### Books
- **POST /books:** Create a new book.
- **GET /books/{id}:** Get book by ID.
- **PUT /books/{id}:** Update an existing book.
- **DELETE /books/{id}:** Delete a book.

### Addresses
- **POST /addresses:** Create a new address.
- **GET /addresses/{id}:** Get address by ID.
- **PUT /addresses/{id}:** Update an existing address.
- **DELETE /addresses/{id}:** Delete an address.

## Project Summary
The Mapping API project is a Java-based web application developed using Spring Boot. It provides RESTful API endpoints for managing students, laptops, courses, books, and addresses. The project utilizes Hibernate for object-relational mapping and MySql as the underlying database. With this API, users can perform CRUD operations on the various entities, including creating, retrieving, updating, and deleting records. The project follows a modular structure, allowing for easy scalability and maintainability. It serves as a foundation for building an application that handles the mapping of different entities in a relational database.
