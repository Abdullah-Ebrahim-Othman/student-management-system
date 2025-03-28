package com.example.studentcrud.model;

import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    public static Specification<Student> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Student> hasLevel(String level) {
        return (root, query, criteriaBuilder) ->
                level == null ? null : criteriaBuilder.equal(root.get("level"), level);
    }

    public static Specification<Student> hasGpa(Double gpa) {
        return (root, query, criteriaBuilder) ->
                gpa == null ? null : criteriaBuilder.equal(root.get("gpa"), gpa);
    }
}