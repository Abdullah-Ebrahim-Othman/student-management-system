package com.example.studentcrud.repository.mongo;

import com.example.studentcrud.model.ArchivedStudent;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMongoRepository  extends MongoRepository<ArchivedStudent, String> , JpaSpecificationExecutor<ArchivedStudent> {}
