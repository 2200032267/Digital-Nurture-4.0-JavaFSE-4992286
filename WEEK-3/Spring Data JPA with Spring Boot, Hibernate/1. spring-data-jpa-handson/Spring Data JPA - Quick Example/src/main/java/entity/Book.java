package com.example.jpa_demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotNull(message = "Price is mandatory")
    private BigDecimal price;

    @NotNull(message = "Published date is mandatory")
    private LocalDate publishedDate;

    public Book() {}

    public Book(String title, BigDecimal price, LocalDate publishedDate) {
        this.title = title;
        this.price = price;
        this.publishedDate = publishedDate;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public BigDecimal getPrice() { return price; }
    public LocalDate getPublishedDate() { return publishedDate; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", price=" + price +
            ", publishedDate=" + publishedDate +
            '}';
    }
}
