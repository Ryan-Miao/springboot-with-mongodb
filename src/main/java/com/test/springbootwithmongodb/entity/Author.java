package com.test.springbootwithmongodb.entity;

import java.util.Set;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "authors")
public class Author {
    @Id
    private ObjectId id;
    @Indexed
    private String name;
    @DBRef
    private Set<Book> books;

    // No args Constructor
    public Author(String name) {
        this.name = name;
    }

}
