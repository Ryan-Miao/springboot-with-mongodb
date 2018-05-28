package com.test.springbootwithmongodb.repo;

import com.test.springbootwithmongodb.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, ObjectId> {

}
