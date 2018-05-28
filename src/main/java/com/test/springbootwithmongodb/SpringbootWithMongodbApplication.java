package com.test.springbootwithmongodb;

import com.google.common.collect.Lists;
import com.test.springbootwithmongodb.entity.Author;
import com.test.springbootwithmongodb.entity.Book;
import com.test.springbootwithmongodb.entity.Customer;
import com.test.springbootwithmongodb.entity.Hobby;
import com.test.springbootwithmongodb.repo.AuthorRepository;
import com.test.springbootwithmongodb.repo.BookRepository;
import com.test.springbootwithmongodb.repo.CustomerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWithMongodbApplication implements CommandLineRunner {

    private final CustomerRepository repository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public SpringbootWithMongodbApplication(CustomerRepository repository,
        BookRepository bookRepository,
        AuthorRepository authorRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWithMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith", Lists.newArrayList(new Hobby("读书", 1), new Hobby("看电影", 2))));
        repository.save(new Customer("Bob", "Smith", Lists.newArrayList()));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

        bookRepository.deleteAll();
        authorRepository.deleteAll();
        Book ci = new Book("Continous Integration", LocalDate.now());
        // id will be generated after save
        bookRepository.save(ci);
        Book c2 = new Book("Java编程思想", LocalDate.now());
        Book c3 = new Book("Java核心技术", LocalDate.now());
        Book c4 = new Book("Effective Java", LocalDate.now());
        Book c5 = new Book("深入理解虚拟机", LocalDate.now());
        Book c6 = new Book("深入理解虚拟机", LocalDate.now());
        bookRepository.save(c2);
        bookRepository.save(c3);
        bookRepository.save(c4);
        bookRepository.save(c5);
        bookRepository.save(c6);

        List<Book> books = bookRepository.findAll();
        System.out.println(books);

        Author julius = new Author("Julius");
        julius.setBooks(Stream.of(ci, c2, c3, c4, c5, c6).collect(Collectors.toSet()));
        authorRepository.save(julius);
        System.out.println(authorRepository.findAll());

    }
}
