# Use an official Java runtime as base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built Spring Boot application JAR
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
