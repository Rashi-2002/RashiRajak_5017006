import java.util.Arrays;

/**
 * Exercise 4: Employee Management System
 *
 * Scenario:
 * Efficiently managing employee records is crucial in an employee management system.
 *
 * 1. Understand Array Representation:
 * Arrays in Memory:
 * - Arrays are stored in contiguous memory locations.
 * - Each element is accessed using an index, making access time O(1).
 * - Arrays have a fixed size, which must be declared at the time of creation.
 *
 * Advantages of Arrays:
 * - Fast access time (O(1)) for reading or writing elements.
 * - Simple and easy to use for fixed-size collections of elements.
 * - Memory locality improves cache performance.
 *
 * 2. Setup:
 * - Create a class Employee with attributes like employeeId, name, position, and salary.
 *
 * 3. Implementation:
 * - Use an array to store employee records.
 * - Implement methods to add, search, traverse, and delete employees in the array.
 *
 * 4. Analysis:
 * - Analyze the time complexity of each operation (add, search, traverse, delete).
 * - Discuss the limitations of arrays and when to use them.
 *
 * Time Complexity Analysis:
 * - Add: O(1) if there's space, O(n) if resizing is needed.
 * - Search: O(n) in the worst case.
 * - Traverse: O(n).
 * - Delete: O(n) in the worst case due to shifting elements.
 *
 * Limitations of Arrays:
 * - Fixed size: Once created, the size cannot be changed. Resizing requires creating a new array and copying elements.
 * - Inefficient for dynamic collections where size frequently changes.
 * - Deletion and insertion operations can be costly due to shifting elements.
 */

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Exercise4 {

    private Employee[] employees;
    private int count;

    public Exercise4(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    /**
     * Add an employee to the array.
     * Time Complexity: O(1) if there's space, O(n) if resizing is needed.
     */
    public void addEmployee(Employee employee) {
        if (count == employees.length) {
            // Resize array if full
            employees = Arrays.copyOf(employees, employees.length * 2);
        }
        employees[count++] = employee;
    }

    /**
     * Search for an employee by employeeId.
     * Time Complexity: O(n) in the worst case.
     */
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    /**
     * Traverse the array and print all employees.
     * Time Complexity: O(n).
     */
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    /**
     * Delete an employee by employeeId.
     * Time Complexity: O(n) in the worst case due to shifting elements.
     */
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                // Shift elements to the left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null; // Decrease count and nullify the last element
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Exercise4 employeeManagementSystem = new Exercise4(2);

        // Adding employees
        employeeManagementSystem.addEmployee(new Employee(1, "Alice", "Developer", 80000));
        employeeManagementSystem.addEmployee(new Employee(2, "Bob", "Manager", 90000));
        employeeManagementSystem.addEmployee(new Employee(3, "Charlie", "Designer", 70000));

        // Traversing employees
        System.out.println("All Employees:");
        employeeManagementSystem.traverseEmployees();

        // Searching for an employee
        System.out.println("\nSearching for Employee with ID 2:");
        Employee employee = employeeManagementSystem.searchEmployee(2);
        System.out.println(employee != null ? employee : "Employee not found");

        // Deleting an employee
        System.out.println("\nDeleting Employee with ID 1:");
        boolean isDeleted = employeeManagementSystem.deleteEmployee(1);
        System.out.println(isDeleted ? "Employee deleted successfully" : "Employee not found");

        // Traversing employees after deletion
        System.out.println("\nAll Employees after deletion:");
        employeeManagementSystem.traverseEmployees();
    }
}
/*
Expected Output:
All Employees:
Employee{employeeId=1, name='Alice', position='Developer', salary=80000.0}
Employee{employeeId=2, name='Bob', position='Manager', salary=90000.0}
Employee{employeeId=3, name='Charlie', position='Designer', salary=70000.0}

Searching for Employee with ID 2:
Employee{employeeId=2, name='Bob', position='Manager', salary=90000.0}

Deleting Employee with ID 1:
Employee deleted successfully

All Employees after deletion:
Employee{employeeId=2, name='Bob', position='Manager', salary=90000.0}
Employee{employeeId=3, name='Charlie', position='Designer', salary=70000.0}
*/
