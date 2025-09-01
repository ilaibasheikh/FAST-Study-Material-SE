import java.util.Scanner;

public class CourseSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the student to enter marks in percentage
        System.out.print("Enter your marks in the Operating Systems course (in percentage): ");
        double osMarks = scanner.nextDouble();

        // Check if the student is allowed to take Software Requirements
        if (osMarks >= 40) {
            System.out.println("You are allowed to take Software Requirements.");
            
            // Check if the student can also take Parallel and Distributed Computing
            if (osMarks > 50) {
                System.out.println("You can also enroll in Parallel and Distributed Computing.");
                
                // Check if the student is eligible for Teaching Assistantship
                if (osMarks > 80) {
                    System.out.println("Congratulations! You've been offered a Teaching Assistantship.");
                    // Student can choose other courses here.
                } else if (osMarks > 70) {
                    System.out.println("Congratulations! You've been offered a Student Lab Assistantship.");
                }
            }
        } else {
            System.out.println("Sorry, you are not eligible for any additional courses at the moment.");
        }

        scanner.close(); // Close the scanner when done.
    }
}
