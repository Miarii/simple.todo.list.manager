# Simple todo list manager
This repository contains an API REST for task management application designed to help you keep track of your todo list, with Framework Spring Boot.

## Built with

- [Spring Boot](https://spring.io/projects/spring-boot) (3.2.1) - The framework used for creating the web application.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Used for database integration and data handling.
- [Java](https://www.oracle.com/java/) (Version 21) - Programming language used.
- [Maven](https://maven.apache.org/) - Dependency management and build tool.
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) (Version 8.0.31) - JDBC driver for MySQL.
- [JPA API](https://jakarta.ee/specifications/persistence/) (Version 2.2) - Java Persistence API for ORM.

## Prerequisites
To run this project, you will need:
***
Java JDK 21 or later.
Maven (check if included with your IDE or install separately).
MySQL Database Server (or you can modify the `application.properties` to use a different database).
***

## Installing and running
````
git clone https://github.com/Miarii/simple.todo.list.manager.git
````

## Build the project with Maven
````
mvn clean install
````

## Run the application
````
mvn spring-boot:run
````

The application should now be running on http://localhost:8080 on local
