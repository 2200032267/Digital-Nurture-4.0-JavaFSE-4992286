package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("DEBUG: Spring container is calling setBookRepository to inject the dependency.");
        this.bookRepository = bookRepository;
    }

    public String getBookDetails(long bookId) {
        if (bookRepository == null) {
            return "Error: BookRepository dependency was not injected!";
        }
        System.out.println("INFO: BookService is using the injected BookRepository.");
        return bookRepository.findBookById(bookId);
    }
}