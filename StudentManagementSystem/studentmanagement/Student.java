package studentmanagement;

public class Student extends Person implements ResultOperations {

    private int rollNumber;
    private String department;
    private double marks1, marks2, marks3;
    private double percentage;
    private char grade;

    static int studentCount = 0;

    // Constructor
    public Student(int rollNumber, String name, int age,
                   String department, double marks1,
                   double marks2, double marks3) {

        super(name, age);

        this.rollNumber = rollNumber;
        this.department = department;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;

        studentCount++;
        calculateGrade();
    }

    // Method overloading
    public Student(int rollNumber, String name, int age) {
        this(rollNumber, name, age, "CSE", 0, 0, 0);
    }

    public int getRollNumber() {
        return rollNumber;
    }

    // Method overloading
    public void setMarks(double marks) {
        marks1 = marks;
        marks2 = marks;
        marks3 = marks;
        calculateGrade();
    }

    public void setMarks(double m1, double m2, double m3) {
        marks1 = m1;
        marks2 = m2;
        marks3 = m3;
        calculateGrade();
    }

    public void update(String name, int age, String department,
                       double m1, double m2, double m3) {

        this.name = name;
        this.age = age;
        this.department = department;

        setMarks(m1, m2, m3);
    }

    @Override
    public void calculateGrade() {

        percentage = (marks1 + marks2 + marks3) / 3;

        if (percentage >= 90)
            grade = 'A';
        else if (percentage >= 80)
            grade = 'B';
        else if (percentage >= 70)
            grade = 'C';
        else if (percentage >= 60)
            grade = 'D';
        else if (percentage >= 40)
            grade = 'E';
        else
            grade = 'F';
    }

    public void display() {

        System.out.println("-----------------------------");
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Department  : " + department);
        System.out.println("Marks       : " + marks1 + ", " + marks2 + ", " + marks3);
        System.out.printf("Percentage  : %.2f%%\n", percentage);
        System.out.println("Grade       : " + grade);
        System.out.println("-----------------------------");
    }

    @Override
    public void generateResult() {

        System.out.println("\n========== RESULT ==========");
        display();

        if (grade == 'F')
            System.out.println("Result      : FAIL");
        else
            System.out.println("Result      : PASS");
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static void decreaseCount() {
        studentCount--;
    }
}