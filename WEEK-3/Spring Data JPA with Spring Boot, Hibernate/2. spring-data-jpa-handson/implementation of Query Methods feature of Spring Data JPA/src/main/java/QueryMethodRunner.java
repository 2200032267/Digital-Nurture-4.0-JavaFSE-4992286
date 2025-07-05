package com.example.jpaquerydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class QueryMethodRunner implements CommandLineRunner {

    private final ProductRepository repository;

    public QueryMethodRunner(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        setupData();
        runQueries();
    }

    private void setupData() {
        repository.saveAll(Arrays.asList(
                new Product("Laptop Pro", "Electronics", 1499.99, LocalDate.of(2023, 1, 10)),
                new Product("Gaming Mouse", "Electronics", 75.50, LocalDate.of(2023, 3, 15)),
                new Product("Office Chair", "Furniture", 250.00, LocalDate.of(2022, 5, 20)),
                new Product("Ergonomic Keyboard", "Electronics", 120.00, LocalDate.of(2023, 2, 28)),
                new Product("Standing Desk", "Furniture", 450.00, LocalDate.of(2022, 11, 1)),
                new Product("USB-C Hub", "Electronics", 45.99, LocalDate.of(2023, 4, 5))
        ));
    }

    private void runQueries() {
        print("Find by name containing 'pro':",
                repository.findByNameContainingIgnoreCase("pro"));

        print("Find by category starting with 'Elec':",
                repository.findByCategoryStartingWith("Elec"));

        print("Find by price greater than 300.0:",
                repository.findByPriceGreaterThan(300.0));

        print("Find by manufactured date between 2023-01-01 and 2023-03-31:",
                repository.findByManufacturedDateBetween(
                        LocalDate.of(2023, 1, 1),
                        LocalDate.of(2023, 3, 31)));

        print("Find by category 'Electronics', sorted by price ascending:",
                repository.findByCategoryOrderByPriceAsc("Electronics"));

        print("Top 2 most expensive products:",
                repository.findTop2ByOrderByPriceDesc());
    }

    private void print(String message, List<Product> list) {
        System.out.println("\n=== " + message + " ===");
        list.forEach(System.out::println);
    }
}
