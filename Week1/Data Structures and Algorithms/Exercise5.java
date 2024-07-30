
/**
 * Exercise 5: Task Management System
 *
 * Scenario:
 * Efficiently managing tasks in a task management system.
 *
 * 1. Understand Linked Lists:
 * Linked Lists:
 * - Singly Linked List: Each node contains data and a reference to the next node in the sequence. The last node points to null.
 * - Doubly Linked List: Each node contains data, a reference to the next node, and a reference to the previous node. The first node's previous pointer and the last node's next pointer point to null.
 *
 * Advantages of Linked Lists:
 * - Dynamic Size: Linked lists can grow and shrink dynamically, making them more flexible than arrays which have a fixed size.
 * - Easy Insertions/Deletions: Insertions and deletions can be done efficiently (O(1) time) if the position is known, without shifting elements.
 *
 * 2. Setup:
 * - Create a class Task with attributes like taskId, taskName, and status.
 *
 * 3. Implementation:
 * - Implement a singly linked list to manage tasks.
 * - Implement methods to add, search, traverse, and delete tasks in the linked list.
 *
 * 4. Analysis:
 * - Analyze the time complexity of each operation.
 * - Discuss the advantages of linked lists over arrays for dynamic data.
 *
 * Time Complexity Analysis:
 * - Add: O(1) when adding to the beginning. O(n) when adding to the end if we need to traverse the list.
 * - Search: O(n) in the worst case.
 * - Traverse: O(n).
 * - Delete: O(n) in the worst case due to traversal.
 */

class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class Exercise5 {
    private Node head;

    public Exercise5() {
        this.head = null;
    }

    /**
     * Add a task to the beginning of the linked list.
     * Time Complexity: O(1).
     */
    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Search for a task by taskId.
     * Time Complexity: O(n) in the worst case.
     */
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Traverse the linked list and print all tasks.
     * Time Complexity: O(n).
     */
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    /**
     * Delete a task by taskId.
     * Time Complexity: O(n) in the worst case due to traversal.
     */
    public boolean deleteTask(int taskId) {
        Node current = head;
        Node previous = null;
        while (current != null && current.task.taskId != taskId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false; // Task not found
        }

        if (previous == null) {
            head = current.next; // Task to be deleted is the head
        } else {
            previous.next = current.next; // Bypass the node to delete it
        }

        return true;
    }

    public static void main(String[] args) {
        Exercise5 taskManagementSystem = new Exercise5();

        // Adding tasks
        taskManagementSystem.addTask(new Task(1, "Task One", "Incomplete"));
        taskManagementSystem.addTask(new Task(2, "Task Two", "Incomplete"));
        taskManagementSystem.addTask(new Task(3, "Task Three", "Complete"));

        // Traversing tasks
        System.out.println("All Tasks:");
        taskManagementSystem.traverseTasks();

        // Searching for a task
        System.out.println("\nSearching for Task with ID 2:");
        Task task = taskManagementSystem.searchTask(2);
        System.out.println(task != null ? task : "Task not found");

        // Deleting a task
        System.out.println("\nDeleting Task with ID 1:");
        boolean isDeleted = taskManagementSystem.deleteTask(1);
        System.out.println(isDeleted ? "Task deleted successfully" : "Task not found");


        // Traversing tasks after deletion
        System.out.println("\nAll Tasks after deletion:");
        taskManagementSystem.traverseTasks();
    }
}
/*

Expected Output:
All Tasks:
Task{taskId=3, taskName='Task Three', status='Complete'}
Task{taskId=2, taskName='Task Two', status='Incomplete'}
Task{taskId=1, taskName='Task One', status='Incomplete'}

Searching for Task with ID 2:
Task{taskId=2, taskName='Task Two', status='Incomplete'}

Deleting Task with ID 1:
Task deleted successfully

All Tasks after deletion:
Task{taskId=3, taskName='Task Three', status='Complete'}
Task{taskId=2, taskName='Task Two', status='Incomplete'}
*/