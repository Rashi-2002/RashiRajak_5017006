package com.example.week1;
import java.util.Arrays;

/**
 * Exercise 2: E-commerce Platform Search Function
 *
 * Scenario:
 * Developing the search functionality of an e-commerce platform. The search needs to be optimized for fast performance.
 *
 * 1. Understand Asymptotic Notation:
 *
 * Big O Notation:
 * - Describes the upper bound of the time complexity of an algorithm, showing how the runtime grows with input size.
 * - Helps in analyzing the efficiency of algorithms, especially for large inputs.
 *
 * Best, Average, and Worst-Case Scenarios:
 * - Best Case: The minimum time required for the algorithm to complete (e.g., finding an element in the first position).
 * - Average Case: The expected time required for the algorithm to complete, averaged over all possible inputs.
 * - Worst Case: The maximum time required for the algorithm to complete (e.g., searching through the entire array).
 *
 * 2. Setup:
 * - Create a class Product with attributes for searching, such as productId, productName, and category.
 *
 * 3. Implementation:
 * - Implement linear search and binary search algorithms.
 * - Store products in an array for linear search and a sorted array for binary search.
 *
 * 4. Analysis:
 * - Compare the time complexity of linear and binary search algorithms.
 * - Discuss which algorithm is more suitable for your platform and why.
 */

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class Exercise2 {

    /**
     * Linear search algorithm to find a product by name.
     * Time Complexity: O(n)
     *
     * @param products  The array of products.
     * @param productName The name of the product to search for.
     * @return The product if found, otherwise null.
     */
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Binary search algorithm to find a product by name.
     * Time Complexity: O(log n)
     *
     * @param products The sorted array of products.
     * @param productName The name of the product to search for.
     * @return The product if found, otherwise null.
     */
    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(productName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Creating an array of products for testing
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Smartphone", "Electronics"),
                new Product(3, "Tablet", "Electronics"),
                new Product(4, "Headphones", "Accessories"),
                new Product(5, "Charger", "Accessories")
        };

        // Performing linear search
        Product resultLinear = linearSearch(products, "Tablet");
        System.out.println("Linear Search Result: " + resultLinear);

        // Sorting the array for binary search
        Arrays.sort(products, (p1, p2) -> p1.productName.compareToIgnoreCase(p2.productName));

        // Performing binary search
        Product resultBinary = binarySearch(products, "Tablet");
        System.out.println("Binary Search Result: " + resultBinary);
    }
}

/**
 * Analysis:
 *
 * Time Complexity of Linear Search:
 * - Best Case: O(1) (if the target is at the first position)
 * - Average Case: O(n)
 * - Worst Case: O(n) (if the target is at the last position or not present)
 *
 * Time Complexity of Binary Search:
 * - Best Case: O(1) (if the target is at the middle position initially)
 * - Average Case: O(log n)
 * - Worst Case: O(log n) (after splitting the array multiple times)
 *
 * Suitability for Platform:
 * - Linear Search: Suitable for small datasets where the overhead of sorting is not justified.
 * - Binary Search: Suitable for large datasets that are or can be sorted, as it provides much faster search times.
 */
/*
Expected Output:
Linear Search Result: Product{productId=3, productName='Tablet', category='Electronics'}
Binary Search Result: Product{productId=3, productName='Tablet', category='Electronics'}
 */