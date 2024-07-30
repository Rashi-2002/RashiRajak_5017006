
/**
 * Exercise 3: Sorting Customer Orders
 *
 * Scenario:
 * Sorting customer orders by their total price on an e-commerce platform. This helps in prioritizing high-value orders.
 *
 * 1. Understand Sorting Algorithms:
 *
 * Bubble Sort:
 * - Simple comparison-based sorting algorithm.
 * - Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
 * - Time Complexity: O(n^2) in the average and worst cases.
 *
 * Insertion Sort:
 * - Builds the sorted array one item at a time by repeatedly taking the next item and inserting it into the correct position.
 * - Time Complexity: O(n^2) in the average and worst cases.
 *
 * Quick Sort:
 * - Divide-and-conquer algorithm.
 * - Picks an element as a pivot and partitions the array around the pivot.
 * - Time Complexity: O(n log n) on average, O(n^2) in the worst case.
 *
 * Merge Sort:
 * - Divide-and-conquer algorithm.
 * - Divides the array into halves, sorts each half, and then merges the sorted halves.
 * - Time Complexity: O(n log n) in all cases.
 *
 * 2. Setup:
 * - Create a class Order with attributes like orderId, customerName, and totalPrice.
 *
 * 3. Implementation:
 * - Implement Bubble Sort to sort orders by totalPrice.
 * - Implement Quick Sort to sort orders by totalPrice.
 *
 * 4. Analysis:
 * - Compare the performance (time complexity) of Bubble Sort and Quick Sort.
 * - Discuss why Quick Sort is generally preferred over Bubble Sort.
 */

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

public class Exercise3 {

    /**
     * Bubble Sort algorithm to sort orders by totalPrice.
     * Time Complexity: O(n^2)
     *
     * @param orders The array of orders to be sorted.
     */
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Quick Sort algorithm to sort orders by totalPrice.
     * Time Complexity: O(n log n) on average
     *
     * @param orders The array of orders to be sorted.
     * @param low    The starting index.
     * @param high   The ending index.
     */
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high]
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Creating an array of orders for testing
        Order[] orders = {
                new Order(1, "Alice", 150.0),
                new Order(2, "Bob", 200.0),
                new Order(3, "Charlie", 50.0),
                new Order(4, "Dave", 100.0),
                new Order(5, "Eve", 250.0)
        };

        // Performing Bubble Sort
        bubbleSort(orders);
        System.out.println("Bubble Sort Result:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Creating another array of orders for testing Quick Sort
        Order[] orders2 = {
                new Order(1, "Alice", 150.0),
                new Order(2, "Bob", 200.0),
                new Order(3, "Charlie", 50.0),
                new Order(4, "Dave", 100.0),
                new Order(5, "Eve", 250.0)
        };

        // Performing Quick Sort
        quickSort(orders2, 0, orders2.length - 1);
        System.out.println("Quick Sort Result:");
        for (Order order : orders2) {
            System.out.println(order);
        }
    }
}

/**
 * Analysis:
 *
 * Time Complexity Comparison:
 * - Bubble Sort: O(n^2) in the average and worst cases due to the nested loops.
 * - Quick Sort: O(n log n) on average due to the divide-and-conquer approach, O(n^2) in the worst case if the pivot elements are not well-chosen.
 *
 * Preference for Quick Sort:
 * - Quick Sort is generally preferred over Bubble Sort for large datasets because it has a much better average-case time complexity.
 * - Bubble Sort is simple to implement but inefficient for large datasets.
 * - Quick Sort's divide-and-conquer approach allows it to handle large datasets more efficiently by reducing the problem size in each recursive step.
 */
/*
Bubble Sort Result:
Order{orderId=3, customerName='Charlie', totalPrice=50.0}
Order{orderId=4, customerName='Dave', totalPrice=100.0}
Order{orderId=1, customerName='Alice', totalPrice=150.0}
Order{orderId=2, customerName='Bob', totalPrice=200.0}
Order{orderId=5, customerName='Eve', totalPrice=250.0}
Quick Sort Result:
Order{orderId=3, customerName='Charlie', totalPrice=50.0}
Order{orderId=4, customerName='Dave', totalPrice=100.0}
Order{orderId=1, customerName='Alice', totalPrice=150.0}
Order{orderId=2, customerName='Bob', totalPrice=200.0}
Order{orderId=5, customerName='Eve', totalPrice=250.0}

 */