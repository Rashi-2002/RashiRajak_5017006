
import java.util.Arrays;

/**
 * Exercise 6: Library Management System
 *
 * Scenario:
 * Users can search for books by title or author in a library management system.
 *
 * 1. Understand Search Algorithms:
 *
 * Linear Search:
 * - Checks each element in the list sequentially until the desired element is found or the list ends.
 * - Time Complexity: O(n) in the worst case.
 *
 * Binary Search:
 * - Works on sorted arrays.
 * - Divides the search interval in half. If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half. Otherwise, narrow it to the upper half.
 * - Time Complexity: O(log n) in the worst case.
 *
 * 2. Setup:
 * - Create a class Book with attributes like bookId, title, and author.
 *
 * 3. Implementation:
 * - Implement linear search to find books by title.
 * - Implement binary search to find books by title (assuming the list is sorted).
 *
 * 4. Analysis:
 * - Compare the time complexity of linear and binary search.
 * - Discuss when to use each algorithm based on the data set size and order.
 */

class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}

public class Exercise6 {
    private Book[] books;
    private int count;

    public Exercise6(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    /**
     * Add a book to the array.
     * Time Complexity: O(1) if there's space, O(n) if resizing is needed.
     */
    public void addBook(Book book) {
        if (count == books.length) {
            // Resize array if full
            books = Arrays.copyOf(books, books.length * 2);
        }
        books[count++] = book;
    }

    /**
     * Linear search for a book by title.
     * Time Complexity: O(n) in the worst case.
     */
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    /**
     * Binary search for a book by title (assumes the array is sorted).
     * Time Complexity: O(log n) in the worst case.
     */
    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, 0, count); // Sort the array before performing binary search
        int left = 0;
        int right = count - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp < 0) {
                left = mid + 1;
            } else if (cmp > 0) {
                right = mid - 1;
            } else {
                return books[mid];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Exercise6 libraryManagementSystem = new Exercise6(2);

        // Adding books
        libraryManagementSystem.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        libraryManagementSystem.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        libraryManagementSystem.addBook(new Book(3, "1984", "George Orwell"));

        // Linear search for a book by title
        System.out.println("\nLinear Search for '1984':");
        Book book = libraryManagementSystem.linearSearchByTitle("1984");
        System.out.println(book != null ? book : "Book not found");

        // Binary search for a book by title
        System.out.println("\nBinary Search for '1984':");
        book = libraryManagementSystem.binarySearchByTitle("1984");
        System.out.println(book != null ? book : "Book not found");
    }
}

/**
 * Analysis:
 *
 * Time Complexity Comparison:
 * - Linear Search: O(n) in the worst case, as it may need to check each element in the array.
 * - Binary Search: O(log n) in the worst case, as it divides the search interval in half each time.
 *
 * When to Use Each Algorithm:
 * - Use Linear Search when the list is unsorted or when the dataset is small, as sorting an unsorted list before performing binary search may not be efficient.
 * - Use Binary Search when the list is sorted, especially for large datasets, as it is much faster than linear search due to its logarithmic time complexity.
 */
/*
Expected Output:
Linear Search for '1984':
Book{bookId=3, title='1984', author='George Orwell'}

Binary Search for '1984':
Book{bookId=3, title='1984', author='George Orwell'}

 */