package quarter2.studentgrades;

import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = readPositiveInt(scanner, "Enter number of students: ");
        int numSubjects = readPositiveInt(scanner, "Enter number of subjects: ");

        int[][] grades = new int[numStudents][numSubjects];

        for (int student = 0; student < numStudents; student++) {
            for (int subject = 0; subject < numSubjects; subject++) {
                System.out.print("Enter grade for Student " + (student + 1)
                        + ", Subject " + (subject + 1) + ": ");
                grades[student][subject] = scanner.nextInt();
            }
            System.out.println();
        }

        for (int student = 0; student < numStudents; student++) {
            System.out.print("Student " + (student + 1) + ": ");

            int total = 0;
            for (int subject = 0; subject < numSubjects; subject++) {
                if (subject > 0) {
                    System.out.print(" ");
                }
                System.out.print(grades[student][subject]);
                total += grades[student][subject];
            }

            double average = (double) total / numSubjects;
            System.out.println();
            System.out.printf("Average: %.2f%n", average);
            System.out.println();
        }

        scanner.close();
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            int value = scanner.nextInt();
            if (value > 0) {
                return value;
            }
            System.out.println("Please enter a number greater than 0.");
        }
    }
}
