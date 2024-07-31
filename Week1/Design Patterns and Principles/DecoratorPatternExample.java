//package com.example.decoratorpattern;

/**
 * Exercise 5: Implementing the Decorator Pattern
 *
 * Scenario:
 * You are developing a notification system where notifications can be sent via multiple channels (e.g., Email, SMS). Use the Decorator Pattern to add functionalities dynamically.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named DecoratorPatternExample.
 * 2. Define Component Interface:
 *    - Create an interface Notifier with a method send().
 * 3. Implement Concrete Component:
 *    - Create a class EmailNotifier that implements Notifier.
 * 4. Implement Decorator Classes:
 *    - Create abstract decorator class NotifierDecorator that implements Notifier and holds a reference to a Notifier object.
 *    - Create concrete decorator classes like SMSNotifierDecorator, SlackNotifierDecorator that extend NotifierDecorator.
 * 5. Test the Decorator Implementation:
 *    - Create a test class to demonstrate sending notifications via multiple channels using decorators.
 */

// Step 2: Define Component Interface
interface Notifier {
    void send(String message);
}

// Step 3: Implement Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

// Step 4: Implement Decorator Classes
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack notification: " + message);
    }
}

// Step 5: Test the Decorator Implementation
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        String message = "Your order has been shipped!";

        System.out.println("Sending notifications through multiple channels:");
        slackNotifier.send(message);
    }
}
/*Expected Output:
Sending notifications through multiple channels:
Sending email notification: Your order has been shipped!
Sending SMS notification: Your order has been shipped!
Sending Slack notification: Your order has been shipped!
 */