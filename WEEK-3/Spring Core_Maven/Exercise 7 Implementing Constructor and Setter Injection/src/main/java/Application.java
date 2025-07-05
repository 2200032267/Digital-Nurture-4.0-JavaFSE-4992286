package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        System.out.println("Loading Spring Context...");
 
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Spring Context Loaded.");
 
        BookService bookService = context.getBean("bookService", BookService.class);
 
        bookService.displayServiceInfo();
 
        System.out.println("Searching for a book...");
        String bookDetails = bookService.getBookDetails(101L);
        System.out.println("Result: " + bookDetails);
 
        context.close();
        System.out.println("\nApplication Finished.");
    }
}