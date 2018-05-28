package com.test.springbootwithmongodb.repo;

import com.test.springbootwithmongodb.entity.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, ObjectId> {

}
