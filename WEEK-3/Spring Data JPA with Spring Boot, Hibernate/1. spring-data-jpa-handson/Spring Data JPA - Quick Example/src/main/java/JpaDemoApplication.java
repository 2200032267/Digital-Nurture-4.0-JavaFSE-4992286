package com.example.jpa_demo;

import com.example.jpa_demo.entity.Book;
import com.example.jpa_demo.repository.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class JpaDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(JpaDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repo) {
        return args -> {
            repo.save(new Book("Book A", new BigDecimal("10.00"), LocalDate.of(2023, 1, 1)));
            repo.save(new Book("Book B", new BigDecimal("20.00"), LocalDate.of(2023, 6, 1)));
            repo.save(new Book("Book C", new BigDecimal("30.00"), LocalDate.of(2023, 8, 1)));

            log.info("All books:");
            repo.findAll().forEach(b -> log.info(b.toString()));

            log.info("Find by title:");
            repo.findByTitle("Book B").forEach(b -> log.info(b.toString()));

            log.info("Books published after 2023-05-01:");
            repo.findByPublishedDateAfter(LocalDate.of(2023, 5, 1)).forEach(b -> log.info(b.toString()));
        };
    }
}
