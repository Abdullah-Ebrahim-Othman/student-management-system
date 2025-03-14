package com.example.studentcrud.configuration.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Student CRUD API",
                version = "1.0",
                description = "API for managing students"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local Server"),
                @Server(url = "https://staging.example.com", description = "Staging Server"),
                @Server(url = "https://api.example.com", description = "Production Server")
        }
)
public class SwaggerConfig {}

