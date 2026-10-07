package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Add
    public void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        System.out.print("Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        if (findStudent(roll) != null) {
            System.out.println("Roll number already exists!");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Department: ");
        String department = sc.nextLine();

        System.out.print("Marks 1: ");
        double m1 = sc.nextDouble();

        System.out.print("Marks 2: ");
        double m2 = sc.nextDouble();

        System.out.print("Marks 3: ");
        double m3 = sc.nextDouble();

        students.add(new Student(
                roll, name, age, department, m1, m2, m3
        ));

        System.out.println("Student added successfully!");
    }

    // Search
    public void searchStudent() {

        System.out.print("\nEnter Roll Number: ");
        int roll = sc.nextInt();

        Student s = findStudent(roll);

        if (s != null)
            s.display();
        else
            System.out.println("Student not found.");
    }

    // Update
    public void updateStudent() {

        System.out.print("\nEnter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(roll);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("New Name: ");
        String name = sc.nextLine();

        System.out.print("New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("New Department: ");
        String department = sc.nextLine();

        System.out.print("New Marks 1: ");
        double m1 = sc.nextDouble();

        System.out.print("New Marks 2: ");
        double m2 = sc.nextDouble();

        System.out.print("New Marks 3: ");
        double m3 = sc.nextDouble();

        s.update(name, age, department, m1, m2, m3);

        System.out.println("Student updated successfully!");
    }

    // Delete
    public void deleteStudent() {

        System.out.print("\nEnter Roll Number: ");
        int roll = sc.nextInt();

        Student s = findStudent(roll);

        if (s != null) {
            students.remove(s);
            Student.decreaseCount();
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display
    public void displayStudents() {

        System.out.println("\n===== ALL STUDENTS =====");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students)
            s.display();

        System.out.println("Total Students: "
                + Student.getStudentCount());
    }

    // Grade
    public void calculateGrade() {

        System.out.print("\nEnter Roll Number: ");
        int roll = sc.nextInt();

        Student s = findStudent(roll);

        if (s != null) {
            s.calculateGrade();
            s.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    // Result
    public void generateResult() {

        System.out.print("\nEnter Roll Number: ");
        int roll = sc.nextInt();

        Student s = findStudent(roll);

        if (s != null)
            s.generateResult();
        else
            System.out.println("Student not found.");
    }

    // Find student
    private Student findStudent(int roll) {

        for (Student s : students) {

            if (s.getRollNumber() == roll)
                return s;
        }

        return null;
    }
}