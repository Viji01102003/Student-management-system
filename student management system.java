import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Roll No: " + student.getRollNo());
            System.out.println("Name: " + student.getName());
            System.out.print("Marks: ");
            for (int mark : student.getMarks()) {
                System.out.print(mark + " ");
            }
            System.out.println();
            System.out.println("Total: " + student.calculateTotal());
            System.out.println("Average: " + student.calculateAverage());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter roll number: ");
                    int rollNo = scanner.nextInt();
                    System.out.print("Enter number of subjects: ");
                    int numSubjects = scanner.nextInt();
                    int[] marks = new int[numSubjects];
                    for (int i = 0; i < numSubjects; i++) {
                        System.out.print("Enter marks for subject " + (i + 1) + ": ");
                        marks[i] = scanner.nextInt();
                    }
                    Student student = new Student(name, rollNo, marks);
                    sms.addStudent(student);
                    break;
                case 2:
                    sms.displayAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}