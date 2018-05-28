package com.test.springbootwithmongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hobby {

    private String name;
    private int order;

}
