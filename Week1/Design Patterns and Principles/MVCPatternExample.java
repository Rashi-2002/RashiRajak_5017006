//package com.example.mvcpattern;

/**
 * Exercise 10: Implementing the MVC Pattern
 *
 * Scenario:
 * You are developing a simple web application for managing student records using the MVC pattern.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named MVCPatternExample.
 * 2. Define Model Class:
 *    - Create a class Student with attributes like name, id, and grade.
 * 3. Define View Class:
 *    - Create a class StudentView with a method displayStudentDetails().
 * 4. Define Controller Class:
 *    - Create a class StudentController that handles the communication between the model and the view.
 * 5. Test the MVC Implementation:
 *    - Create a main class to demonstrate creating a Student, updating its details using StudentController, and displaying them using StudentView.
 */

// Step 2: Define Model Class
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// Step 3: Define View Class
class StudentView {
    public void displayStudentDetails(String name, int id, String grade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}

// Step 4: Define Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public int getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// Step 5: Test the MVC Implementation
public class MVCPatternExample {
    public static void main(String[] args) {
        // Create a Student model
        Student student = new Student("John Doe", 1, "A");

        // Create a view
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(student, view);

        // Update view with initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Smith");
        controller.setStudentId(2);
        controller.setStudentGrade("B");

        // Update view with new student details
        controller.updateView();
    }
}
/*Expected Output:
Connected to the target VM, address: '127.0.0.1:54966', transport: 'socket'
Student Details:
Name: John Doe
ID: 1
Grade: A
Student Details:
Name: Jane Smith
ID: 2
Grade: B
Disconnected from the target VM, address: '127.0.0.1:54966', transport: 'socket'
 */