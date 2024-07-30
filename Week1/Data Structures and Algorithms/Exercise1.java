
import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 1: Inventory Management System
 *
 * Scenario:
 * Developing an inventory management system for a warehouse. Efficient data storage and retrieval are crucial.
 *
 * 1. Understand the Problem:
 *
 * Data Structures and Algorithms:
 * - Essential for handling large inventories to ensure efficient data retrieval and management.
 * - Helps in optimizing the time complexity of operations such as search, insertion, and deletion.
 *
 * Suitable Data Structures:
 * - ArrayList: Good for dynamic resizing but less efficient for search operations.
 * - HashMap: Provides efficient O(1) average time complexity for add, update, and delete operations.
 *
 * 2. Setup:
 * - Created a new project for the inventory management system.
 *
 * 3. Implementation:
 * - Define a class Product with attributes like productId, productName, quantity, and price.
 * - Use HashMap to store products with productId as the key.
 * - Implement methods to add, update, and delete products from the inventory.
 *
 * 4. Analysis:
 *
 * Time Complexity:
 * - Add: O(1) average case for HashMap.
 * - Update: O(1) average case for HashMap.
 * - Delete: O(1) average case for HashMap.
 *
 * Optimization:
 * - Use a proper hash function to minimize collisions.
 * - Manage load factor and resizing to balance space and time complexity.
 *
 * Detailed Implementation:
 * - Print the inventory list after each operation to show the current state.
 */

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

public class Exercise1 {

    private static Map<Integer, Product> inventory = new HashMap<>();

    /**
     * Adds a product to the inventory.
     *
     * @param product The product to be added.
     */
    public static void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product added: " + product);
        printInventory();
    }

    /**
     * Updates a product in the inventory.
     *
     * @param productId The ID of the product to be updated.
     * @param newProduct The new product details.
     */
    public static void updateProduct(int productId, Product newProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, newProduct);
            System.out.println("Product updated: " + newProduct);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        printInventory();
    }

    /**
     * Deletes a product from the inventory.
     *
     * @param productId The ID of the product to be deleted.
     */
    public static void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            Product removedProduct = inventory.remove(productId);
            System.out.println("Product deleted: " + removedProduct);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
        printInventory();
    }

    /**
     * Prints the current state of the inventory.
     */
    public static void printInventory() {
        System.out.println("Current Inventory:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Adding products
        addProduct(new Product(1, "Laptop", 10, 999.99));
        addProduct(new Product(2, "Smartphone", 20, 499.99));

        // Updating a product
        updateProduct(1, new Product(1, "Laptop", 15, 949.99));

        // Deleting a product
        deleteProduct(2);
    }
}

/**
 * Analysis:
 *
 * Time Complexity:
 * - Add: O(1) average case for HashMap.
 * - Update: O(1) average case for HashMap.
 * - Delete: O(1) average case for HashMap.
 *
 * Optimization:
 * - Proper hash function to reduce collisions.
 * - Manage load factor and initial capacity to optimize performance.
 * - Print statements after each operation to display the current state of the inventory.
 */
/*
Expected Output:
Product added: Product{productId=1, productName='Laptop', quantity=10, price=999.99}
Current Inventory:
Product{productId=1, productName='Laptop', quantity=10, price=999.99}

Product added: Product{productId=2, productName='Smartphone', quantity=20, price=499.99}
Current Inventory:
Product{productId=1, productName='Laptop', quantity=10, price=999.99}
Product{productId=2, productName='Smartphone', quantity=20, price=499.99}

Product updated: Product{productId=1, productName='Laptop', quantity=15, price=949.99}
Current Inventory:
Product{productId=1, productName='Laptop', quantity=15, price=949.99}
Product{productId=2, productName='Smartphone', quantity=20, price=499.99}

Product deleted: Product{productId=2, productName='Smartphone', quantity=20, price=499.99}
Current Inventory:
Product{productId=1, productName='Laptop', quantity=15, price=949.99}

 */