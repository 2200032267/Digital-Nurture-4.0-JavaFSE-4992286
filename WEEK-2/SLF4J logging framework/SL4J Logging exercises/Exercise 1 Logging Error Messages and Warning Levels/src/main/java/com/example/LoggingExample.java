package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        System.out.println("Starting the logging example...");

        logger.warn("This is a warning message. The system can continue, but this should be looked into.");
        logger.error("This is an error message. Something has gone wrong!");

        String user = "admin";
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("An arithmetic exception occurred for user '{}'.", user, e);
        }

        System.out.println("Logging example finished.");
    }
}
