import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String grade;

    Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return "Roll No: " + rollNo +
               ", Name: " + name +
               ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    students.add(new Student(roll, name, grade));
                    System.out.println("Student Added Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Roll No to Remove: ");
                    int removeRoll = sc.nextInt();

                    boolean removed = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).rollNo == removeRoll) {
                            students.remove(i);
                            removed = true;
                            System.out.println("Student Removed Successfully.");
                            break;
                        }
                    }

                    if (!removed)
                        System.out.println("Student Not Found.");

                    break;

                case 3:
                    System.out.print("Enter Roll No to Search: ");
                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.rollNo == searchRoll) {
                            System.out.println(s);
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Student Not Found.");

                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No Students Available.");
                    } else {
                        System.out.println("\nStudent Records:");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter Roll No to Edit: ");
                    int editRoll = sc.nextInt();
                    sc.nextLine();

                    boolean edited = false;

                    for (Student s : students) {
                        if (s.rollNo == editRoll) {

                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter New Grade: ");
                            s.grade = sc.nextLine();

                            edited = true;
                            System.out.println("Student Updated Successfully.");
                            break;
                        }
                    }

                    if (!edited)
                        System.out.println("Student Not Found.");

                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}