Prototype Spring Boot Project

Overview

This is a multi-tenant billing and invoicing platform built with Java Spring Boot. Authentication and authorization are managed through Keycloak, allowing OAuth2-based secure API access. The app connects to a MySQL backend and supports tenant-based resource access.


Features

- JWT-based authentication using Keycloak OAuth2 resource server capabilities.
- Multi-tenant design with tenant resolution and isolation.
- REST API for managing tenants, tenants’ data, and users.
- MySQL database integration using Spring Data JPA.
- Secured endpoints with token validation and issuer verification.


Technology Stack

- Java 21, Spring Boot 3.5.6
- Spring Security with OAuth2 Resource Server
- Keycloak for identity and access management
- Docker and Docker Compose for containerization
- MySQL 8.0 as relational database
- Lombok for code reduction


Configuration

- Application properties are located in `src/main/resources/application.properties`.
- Keycloak issuer and JWKS endpoints are configured to connect via Docker host DNS (`host.docker.internal`) for container-to-host network communication.
- The database connection URL points to the Docker MySQL service.



Future Plans

- Implement Role-Based Access Control (RBAC) for finer access permissions.
- Add user roles and claims integration from Keycloak.
- Enhance tenant-based authorization.



