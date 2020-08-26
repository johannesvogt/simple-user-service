# Simple User Service

A simple spring-boot application serving a "user" endpoint, returning data via JPA from an h2 in-memory DB.

### How does it work
* The contract-first API is defined in 'swagger.yaml', related objects and interfaces are generated on `mvn build:compile`
* The in-memory h2 DB is populated on startup (see `src/main/resources/data.sql`)

### Build and Start
`mvn clean compile` to build and generate sources
`mvn spring-boot:run` to start application on 'http://localhost:8080'

### Endpoints

* Health-check endpoint under `/status/health`
* User endpoint `/user?surname=test` (see swagger.yaml for details)