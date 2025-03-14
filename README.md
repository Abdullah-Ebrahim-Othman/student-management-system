# Student Management System 🚀
A **Spring Boot CRUD API** for managing students, integrated with **PostgreSQL & MongoDB**, following **best practices**.

📌 Features
- ✅ RESTful CRUD operations for student management
- ✅ PostgreSQL as the primary database
- ✅ MongoDB for data backup and synchronization
- ✅ Pagination & criteria-based search
- ✅ MapStruct for object mapping (DTOs)
- ✅ Swagger API documentation
- ✅ Docker Compose for easy setup

🏗️ Folder Structure
student-management-system/
│── src/
│   ├── main/
│   │   ├── java/com/example/studentmanagement/
│   │   │   ├── controller/      # Controllers (API Endpoints)
│   │   │   ├── service/         # Business Logic (BOs, DTOs)
│   │   │   ├── repository/      # Repositories (PostgreSQL, MongoDB)
│   │   │   ├── model/           # Entities, DTOs, BOs
│   │   │   ├── config/          # Configuration (Swagger, Security)
│   │   │   ├── exception/       # Global Exception Handling
│   │   │   ├── mapper/          # MapStruct Mappers
│   │   │   ├── StudentManagementApplication.java  # Main Class
│   ├── resources/
│   │   ├── application.yml      # Main Config File
│   │   ├── application-dev.yml  # Dev Profile Config
│   │   ├── application-prod.yml # Production Config
│   │   ├── schema.sql           # Database Schema (Optional)
│   ├── test/                    # Unit & Integration Tests
│── .gitignore                    # Ignore unnecessary files
│── pom.xml                        # Maven Dependencies
│── README.md                      # Documentation
│── docker-compose.yml              # Docker Setup (PostgreSQL, MongoDB, Spring Boot)

