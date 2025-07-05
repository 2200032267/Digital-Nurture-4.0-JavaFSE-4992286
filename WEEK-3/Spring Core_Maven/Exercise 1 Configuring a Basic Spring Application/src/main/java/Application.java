package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        System.out.println("Starting Spring Application Context...");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Spring Context loaded successfully.");

        BookService bookService = context.getBean("bookService", BookService.class);

        long bookIdToFind = 1L;
        String bookDetails = bookService.getBookDetails(bookIdToFind);

        System.out.println("\n--- Book Search Result ---");
        System.out.println("Searching for book with ID: " + bookIdToFind);
        System.out.println("Found: " + bookDetails);
        System.out.println("--------------------------\n");

        context.close();
        System.out.println("Spring Application Context closed.");
    }
}