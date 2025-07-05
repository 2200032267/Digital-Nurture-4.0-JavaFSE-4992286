package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
 
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("DEBUG: Spring IoC container is injecting BookRepository into BookService.");
        this.bookRepository = bookRepository;
    }
 
    public String getBookDetails(long bookId) {
        if (bookRepository == null) {
            throw new IllegalStateException("Dependency 'bookRepository' was not injected!");
        }
        System.out.println("INFO: BookService is using its repository to find book details.");
        return bookRepository.findBookById(bookId);
    }
}