# TechTaste - Backend Monorepo

![GitHub language top](https://img.shields.io/github/languages/top/dvargas42/techtaste-monorepo?color=%23177edf)
<a href="https://www.linkedin.com/in/daniel-santos-040983ab/" target="_blank" rel="noopener noreferrer">
![Made by](https://img.shields.io/badge/made%20by-daniel%20vargas-%23177edf)
</a>
![Repository size](https://img.shields.io/github/repo-size/dvargas42/techtaste-monorepo?color=%23177edf)
![GitHub last commit](https://img.shields.io/github/last-commit/dvargas42/techtaste-monorepo?color=%23177edf)
![Repository issues](https://img.shields.io/github/issues/dvargas42/techtaste-monorepo?color=%23177edf)
![GitHub](https://img.shields.io/github/license/dvargas42/techtaste-monorepo?color=%23177edf)

# 

A backend monorepo built in Java - Spring Boot, containing multiple microservices designed to handle specific domains of the application. Each microservice is independent, allowing for scalability, maintainability, and modular development.

## 🚀 Technologies

Technologies used in this monorepo:

- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Spring Boot 3.4](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/)
- [Maven 3.4](https://maven.apache.org/guides/index.html)
- [PostgreSQL 17](https://www.postgresql.org/docs/17/)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Docker Compose 2](https://docs.docker.com/compose/install/)

## 🖼️ System Architecture

![System Architecture](https://res.cloudinary.com/dvargas42/image/upload/v1743219235/Architecture_xazvia.png)

## 🌐 Microservices Overview

The project is structured into the following microservices:

### **user-ms**

This microservice is responsible for managing user-related operations, such as:

- User registration
- User authentication
- Retrieving user details

### **order-ms**

This microservice handles order management, including:

- Creating new orders
- Updating order statuses
- Retrieving order details

### **payment-ms**

This microservice is responsible for processing payments, including:

- Handling payment transactions
- Managing payment statuses
- Integrating with external payment gateways

### **api-gateway**

The API Gateway acts as the entry point for all client requests. It is responsible for:

- Routing requests to the appropriate microservices
- Centralizing authentication and authorization
- Providing a unified API for clients

### **config-server**

The Config Server provides centralized configuration management for all microservices. It allows:

- Dynamic configuration updates
- Centralized storage of configuration files
- Environment-specific configurations

### **service-registry**

The Service Registry is based on Eureka and is responsible for:

- Service discovery
- Load balancing between instances of microservices
- Ensuring high availability of services

## 💻 Getting started

Clone the project:

```bash
$ git clone https://github.com/dvargas42/techtaste-monorepo
```

Enter the project directory:

```bash
$ cd techtaste-monorepo
```

Start all containers and services:

```bash
$ docker compose up -d
```

To stop and remove all containers and volumes:

```bash
$ docker compose down -v
```

If you want to run all microservice, ensure the infrastructure is running via Docker Compose:

```bash
$ chmod +x start.sh
$ ./start.sh
```

## 🔍 How to access

### 🌐 **Eureka Server**
Access Eureka at:

```
http://localhost:8081/
```

### 🐰 **RabbitMQ**
Access RabbitMQ at:

```
http://localhost:15672/
```

Default credentials: `admin` / `admin`

### ⚙️ **Config Service**
Access Config-Service at:

```
http://localhost:8888/application/default
http://localhost:8888/service-registry/default
...
```

## 🤝 Contributing

**Make a fork of this repository**

```bash
$ gh repo fork dvargas42/techtaste-monorepo
```

**Follow the steps below**

```bash
# Clone your fork
$ git clone your-fork-url && cd techtaste-monorepo

# Create a branch with your feature
$ git checkout -b my-feature

# Make the commit with your changes
$ git commit -m 'feat: My new feature'

# Send the code to your remote branch
$ git push origin my-feature
```

After your pull request is merged, you can delete your branch.

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 💇🏼 Author

Made with 💜 &nbsp;by Daniel Vargas 👋 &nbsp;[See my LinkedIn](https://www.linkedin.com/in/daniel-santos-040983ab/)