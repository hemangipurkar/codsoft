import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("Welcome to the Student Grade Calculator ");
        System.out.println("===========================================");

        System.out.print("\nEnter the number of subjects: ");
        int numSubjects = 0;

        while (true) {
            try {
                numSubjects = Integer.parseInt(scanner.nextLine());
                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        double[] marks = new double[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                    double mark = Double.parseDouble(scanner.nextLine());
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

        double totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        String grade = calculateGrade(averagePercentage);

        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    // Method to calculate total marks
    private static double calculateTotalMarks(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    // Method to calculate average percentage
    private static double calculateAveragePercentage(double totalMarks, int numSubjects) {
        return totalMarks / numSubjects;
    }

    // Method to calculate grade based on average percentage
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C";
        } else {
            return "F";
        }
    }

    // Method to display results
    private static void displayResults(double totalMarks, double averagePercentage, String grade) {
        System.out.println("\n================ Results =================");
        System.out.printf("Total Marks Obtained: %.2f\n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("===========================================");
    }
}
