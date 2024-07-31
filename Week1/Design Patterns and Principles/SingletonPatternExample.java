

/**
 * Exercise 1: Implementing the Singleton Pattern
 *
 * Scenario:
 * Ensure that a logging utility class in your application has only one instance throughout the application lifecycle to ensure consistent logging.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named SingletonPatternExample.
 * 2. Define a Singleton Class:
 *    - Create a class named Logger that has a private static instance of itself.
 *    - Ensure the constructor of Logger is private.
 *    - Provide a public static method to get the instance of the Logger class.
 * 3. Implement the Singleton Pattern:
 *    - Write code to ensure that the Logger class follows the Singleton design pattern.
 * 4. Test the Singleton Implementation:
 *    - Create a test class to verify that only one instance of Logger is created and used across the application.
 */

class Logger {
    // Step 2: Define a Singleton Class

    // Private static instance of the Logger class
    private static volatile Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Private constructor to prevent instantiation
    }

    // Public static method to get the instance of the Logger class
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log INFO messages
    public void logInfo(String message) {
        System.out.println("INFO: " + message);
    }

    // Method to log WARN messages
    public void logWarn(String message) {
        System.out.println("WARN: " + message);
    }

    // Method to log ERROR messages
    public void logError(String message) {
        System.out.println("ERROR: " + message);
    }
}

public class SingletonPatternExample {
    // Step 4: Test the Singleton Implementation
    public static void main(String[] args) {
        // Getting the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Logging messages with different severity levels
        logger1.logInfo("This is an info message.");
        logger1.logWarn("This is a warning message.");
        logger1.logError("This is an error message.");

        // Verifying that both logger1 and logger2 refer to the same instance
        if (logger1 == logger2) {
            System.out.println("logger1 and logger2 refer to the same instance.");
        } else {
            System.out.println("logger1 and logger2 refer to different instances.");
        }
    }
}
/*Expected Output:
INFO: This is an info message.
WARN: This is a warning message.
ERROR: This is an error message.
logger1 and logger2 refer to the same instance.
 */