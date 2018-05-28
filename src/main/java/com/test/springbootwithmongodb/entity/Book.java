package com.test.springbootwithmongodb.entity;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String title;
    @Field("published")
    private LocalDate publicationDate;

    // No args Constructor
    public Book(String title, LocalDate publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }

}
