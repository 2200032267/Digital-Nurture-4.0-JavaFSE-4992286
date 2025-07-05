package com.example.jpaquerydemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String keyword);
    List<Product> findByCategoryStartingWith(String prefix);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByManufacturedDateBetween(LocalDate start, LocalDate end);
    List<Product> findByCategoryOrderByPriceAsc(String category);
    List<Product> findTop2ByOrderByPriceDesc();
}
