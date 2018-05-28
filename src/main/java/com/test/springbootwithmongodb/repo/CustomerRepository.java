package com.test.springbootwithmongodb.repo;

import com.test.springbootwithmongodb.entity.Customer;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}
