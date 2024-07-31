//package com.example.adapterpattern;

/**
 * Exercise 4: Implementing the Adapter Pattern
 *
 * Scenario:
 * You are developing a payment processing system that needs to integrate with multiple third-party payment gateways with different interfaces. Use the Adapter Pattern to achieve this.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named AdapterPatternExample.
 * 2. Define Target Interface:
 *    - Create an interface PaymentProcessor with methods like processPayment().
 * 3. Implement Adaptee Classes:
 *    - Create classes for different payment gateways with their own methods.
 * 4. Implement the Adapter Class:
 *    - Create an adapter class for each payment gateway that implements PaymentProcessor and translates the calls to the gateway-specific methods.
 * 5. Test the Adapter Implementation:
 *    - Create a test class to demonstrate the use of different payment gateways through the adapter.
 */

// Step 2: Define Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 3: Implement Adaptee Classes
class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

class Stripe {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

// Step 4: Implement the Adapter Class
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

// Step 5: Test the Adapter Implementation
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Using PayPal through the adapter
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        payPalProcessor.processPayment(100.0);

        // Using Stripe through the adapter
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment(200.0);
    }
}
/*Expected Output:
Processing payment of $100.0 through PayPal.
Processing payment of $200.0 through Stripe.
 */