//package com.example.strategypattern;

/**
 * Exercise 8: Implementing the Strategy Pattern
 *
 * Scenario:
 * You are developing a payment system where different payment methods (e.g., Credit Card, PayPal) can be selected at runtime. Use the Strategy Pattern to achieve this.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named StrategyPatternExample.
 * 2. Define Strategy Interface:
 *    - Create an interface PaymentStrategy with a method pay().
 * 3. Implement Concrete Strategies:
 *    - Create classes CreditCardPayment, PayPalPayment that implement PaymentStrategy.
 * 4. Implement Context Class:
 *    - Create a class PaymentContext that holds a reference to PaymentStrategy and a method to execute the strategy.
 * 5. Test the Strategy Implementation:
 *    - Create a test class to demonstrate selecting and using different payment strategies.
 */

// Step 2: Define Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Implement Concrete Strategies

// Concrete Strategy for Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card. Card Number: " + cardNumber);
    }
}

// Concrete Strategy for PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal. Email: " + email);
    }
}

// Step 4: Implement Context Class

// Context class for payment
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Step 5: Test the Strategy Implementation
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card Payment Strategy
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        context.executePayment(100.0);

        // Use PayPal Payment Strategy
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(200.0);
    }
}
/*
Expected Output:
Paid $100.0 using Credit Card. Card Number: 1234-5678-9012-3456
Paid $200.0 using PayPal. Email: user@example.com
 */

