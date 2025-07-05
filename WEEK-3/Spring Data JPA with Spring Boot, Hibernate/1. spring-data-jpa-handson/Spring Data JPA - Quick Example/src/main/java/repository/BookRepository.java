package com.example.jpa_demo.repository;

import com.example.jpa_demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.publishedDate > :date")
    List<Book> findByPublishedDateAfter(LocalDate date);
}
