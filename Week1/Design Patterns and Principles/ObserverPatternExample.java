//package com.example.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 7: Implementing the Observer Pattern
 *
 * Scenario:
 * You are developing a stock market monitoring application where multiple clients need to be notified whenever stock prices change. Use the Observer Pattern to achieve this.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named ObserverPatternExample.
 * 2. Define Subject Interface:
 *    - Create an interface Stock with methods to register, deregister, and notify observers.
 * 3. Implement Concrete Subject:
 *    - Create a class StockMarket that implements Stock and maintains a list of observers.
 * 4. Define Observer Interface:
 *    - Create an interface Observer with a method update().
 * 5. Implement Concrete Observers:
 *    - Create classes MobileApp, WebApp that implement Observer.
 * 6. Test the Observer Implementation:
 *    - Create a test class to demonstrate the registration and notification of observers.
 */

// Step 2: Define Subject Interface
interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

// Step 4: Define Observer Interface
interface Observer {
    void update(String stockName, double stockPrice);
}

// Step 3: Implement Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    public void setStockInfo(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}

// Step 5: Implement Concrete Observers
class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(name + " received update: " + stockName + " is now $" + stockPrice);
    }
}

class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(name + " received update: " + stockName + " is now $" + stockPrice);
    }
}

// Step 6: Test the Observer Implementation
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.register(mobileApp1);
        stockMarket.register(mobileApp2);
        stockMarket.register(webApp1);

        stockMarket.setStockInfo("AAPL", 150.00);
        System.out.println();
        stockMarket.setStockInfo("GOOGL", 2750.00);

        stockMarket.deregister(mobileApp2);
        System.out.println();
        stockMarket.setStockInfo("MSFT", 299.00);
    }
}
/*Expected Output:
MobileApp1 received update: AAPL is now $150.0
MobileApp2 received update: AAPL is now $150.0
WebApp1 received update: AAPL is now $150.0

MobileApp1 received update: GOOGL is now $2750.0
MobileApp2 received update: GOOGL is now $2750.0
WebApp1 received update: GOOGL is now $2750.0

MobileApp1 received update: MSFT is now $299.0
WebApp1 received update: MSFT is now $299.0
 */