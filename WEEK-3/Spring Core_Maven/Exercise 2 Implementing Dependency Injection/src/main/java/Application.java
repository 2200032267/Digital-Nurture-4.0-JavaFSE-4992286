package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        System.out.println("Starting Spring Application Context...");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Spring Context loaded successfully.");

        BookService bookService = context.getBean("bookService", BookService.class);

        String bookDetails = bookService.getBookDetails(1L);

        System.out.println("\n--- Book Search Result ---");
        System.out.println("Found: " + bookDetails);
        System.out.println("--------------------------\n");

        context.close();
        System.out.println("Spring Application Context closed.");
    }
}