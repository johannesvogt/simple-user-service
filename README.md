# Simple User Service

A simple spring-boot application serving a GET "user" endpoint, returning data via JPA from an h2 in-memory DB.

#### Requirements
* Java 11
* Maven 3

#### How does it work
* The contract-first API is defined in 'swagger.yaml', related objects and interfaces are generated on `mvn clean compile`
* The in-memory h2 DB is populated on startup (see `src/main/resources/data.sql`)

#### Build and Run
* `mvn clean compile` to build and generate sources
* `mvn spring-boot:run` to start application on 'http://localhost:8080/'

#### Endpoints

* Health-check endpoint under `/status/health`
* User endpoint `/user?surname=smith` (see swagger.yaml for details)