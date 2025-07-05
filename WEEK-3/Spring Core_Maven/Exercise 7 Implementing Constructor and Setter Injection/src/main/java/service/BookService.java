package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
 
    private final BookRepository bookRepository;
 
    private String libraryBranch;
 
    public BookService(BookRepository bookRepository) {
        System.out.println("DEBUG: BookService constructor called for CONSTRUCTOR INJECTION.");
        this.bookRepository = bookRepository;
    }
 
    public void setLibraryBranch(String libraryBranch) {
        System.out.println("DEBUG: setLibraryBranch called for SETTER INJECTION.");
        this.libraryBranch = libraryBranch;
    }
 
    public String getBookDetails(long bookId) {
        return bookRepository.findBookById(bookId);
    }
 
    public void displayServiceInfo() {
        System.out.println("\n--- Service Configuration ---");
        if (bookRepository != null) {
            System.out.println("Status: BookRepository is configured.");
        } else {
            System.out.println("Status: BookRepository is MISSING.");
        }
        if (libraryBranch != null && !libraryBranch.isEmpty()) {
            System.out.println("Operating at branch: " + this.libraryBranch);
        } else {
            System.out.println("Operating at: Branch not specified.");
        }
        System.out.println("---------------------------\n");
    }
}