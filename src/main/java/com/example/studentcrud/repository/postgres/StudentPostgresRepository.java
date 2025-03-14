package com.example.studentcrud.repository.postgres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.studentcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPostgresRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

    Page<Student> findAll(Pageable pageable);
}
