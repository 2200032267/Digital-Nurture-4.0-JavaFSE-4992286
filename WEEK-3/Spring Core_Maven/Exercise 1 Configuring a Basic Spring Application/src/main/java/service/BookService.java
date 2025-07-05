package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("DEBUG: Injecting BookRepository into BookService.");
        this.bookRepository = bookRepository;
    }

    public String getBookDetails(long bookId) {
        if (bookRepository == null) {
            return "Error: BookRepository was not injected!";
        }
        System.out.println("INFO: BookService is using BookRepository to find book details.");
        return bookRepository.findBookById(bookId);
    }
}