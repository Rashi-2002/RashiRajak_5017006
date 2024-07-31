//package com.example.dependencyinjection;

import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 11: Implementing Dependency Injection
 *
 * Scenario:
 * You are developing a customer management application where the service class depends on a repository class.
 * Use Dependency Injection to manage these dependencies.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named DependencyInjectionExample.
 * 2. Define Repository Interface:
 *    - Create an interface CustomerRepository with methods like findCustomerById().
 * 3. Implement Concrete Repository:
 *    - Create a class CustomerRepositoryImpl that implements CustomerRepository.
 * 4. Define Service Class:
 *    - Create a class CustomerService that depends on CustomerRepository.
 * 5. Implement Dependency Injection:
 *    - Use constructor injection to inject CustomerRepository into CustomerService.
 * 6. Test the Dependency Injection Implementation:
 *    - Create a main class to demonstrate creating a CustomerService with CustomerRepositoryImpl and using it to find a customer.
 */

// Step 2: Define Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Step 3: Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<Integer, String> customerData;

    public CustomerRepositoryImpl() {
        customerData = new HashMap<>();
        // Adding sample customers
        customerData.put(1, "Alice Smith, Email: alice.smith@example.com, Phone: 123-456-7890");
        customerData.put(2, "Bob Johnson, Email: bob.johnson@example.com, Phone: 987-654-3210");
        customerData.put(3, "Charlie Brown, Email: charlie.brown@example.com, Phone: 555-123-4567");
        customerData.put(4, "Diana Prince, Email: diana.prince@example.com, Phone: 555-987-6543");
        customerData.put(5, "Eve Adams, Email: eve.adams@example.com, Phone: 555-555-5555");
    }

    @Override
    public String findCustomerById(int id) {
        return customerData.getOrDefault(id, "Customer not found");
    }
}

// Step 4: Define Service Class
class CustomerService {
    private final CustomerRepository customerRepository;

    // Step 5: Implement Dependency Injection using constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerInfo(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// Step 6: Test the Dependency Injection Implementation
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create a concrete repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to get customer information
        System.out.println(customerService.getCustomerInfo(1)); // Should display details for Alice Smith
        System.out.println(customerService.getCustomerInfo(2)); // Should display details for Bob Johnson
        System.out.println(customerService.getCustomerInfo(3)); // Should display details for Charlie Brown
        System.out.println(customerService.getCustomerInfo(4)); // Should display details for Diana Prince
        System.out.println(customerService.getCustomerInfo(5)); // Should display details for Eve Adams
        System.out.println(customerService.getCustomerInfo(6)); // Should display "Customer not found"
    }
}
/*Expected Output:
Alice Smith, Email: alice.smith@example.com, Phone: 123-456-7890
Bob Johnson, Email: bob.johnson@example.com, Phone: 987-654-3210
Charlie Brown, Email: charlie.brown@example.com, Phone: 555-123-4567
Diana Prince, Email: diana.prince@example.com, Phone: 555-987-6543
Eve Adams, Email: eve.adams@example.com, Phone: 555-555-5555
Customer not found
 */