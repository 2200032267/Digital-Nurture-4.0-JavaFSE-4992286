package singletonexample;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern Test ---");
        System.out.println("Attempting to get the first logger instance...");

        Logger logger1 = Logger.getInstance();

        logger1.log("This is the first message from logger1.");

        System.out.println("\nAttempting to get a second logger instance...");

        Logger logger2 = Logger.getInstance();

        logger2.log("This is the second message from logger2.");

        System.out.println("\nVerifying if logger1 and logger2 are the same instance...");

        if (logger1 == logger2) {
            System.out.println("Success: logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Failure: logger1 and logger2 are different instances.");
        }

        System.out.println("Hash code of logger1: " + logger1.hashCode());
        System.out.println("Hash code of logger2: " + logger2.hashCode());
    }
}
