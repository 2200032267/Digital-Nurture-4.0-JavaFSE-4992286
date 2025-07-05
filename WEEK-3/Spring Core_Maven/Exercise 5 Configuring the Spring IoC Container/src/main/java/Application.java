package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        System.out.println("Application starting...");
 
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Spring context loaded successfully.");
 
        BookService bookService = context.getBean("bookService", BookService.class);
 
        String details = bookService.getBookDetails(42L);
 
        System.out.println("\n--- Result from Service ---");
        System.out.println(details);
        System.out.println("---------------------------\n");
 
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("Application finished.");
    }
}