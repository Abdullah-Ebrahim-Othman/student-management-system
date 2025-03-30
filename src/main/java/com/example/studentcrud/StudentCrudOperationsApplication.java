package com.example.studentcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableJpaRepositories(basePackages = "com.example.studentcrud.repository.postgres")
@EnableMongoRepositories(basePackages = "com.example.studentcrud.repository.mongo")
@EnableAsync
@SpringBootApplication
public class StudentCrudOperationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCrudOperationsApplication.class, args);
    }

}
