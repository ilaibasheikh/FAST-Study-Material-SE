import java.util.ArrayList;
import java.util.List;

// Define a Student class
class Student1 {
    private int rollNumber;
    private String name;

    // Constructor
    public Student1(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    // Getter for rollNumber
    public int getRollNumber() {
        return rollNumber;
    }

    // Setter for rollNumber
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

	
	
	  // Override the equals method to compare based on rollNumber
	  
	  @Override public boolean equals(Object o) { if (this == o) return true; if (o
	  == null || getClass() != o.getClass()) return false; Student1 student =
	  (Student1) o; return rollNumber == student.rollNumber; }
	  
	  // Override the hashCode method
	  
	  @Override public int hashCode() { return rollNumber; }
	 
	 
}

public class CustomTypeExample {
    public static void main(String[] args) {
        // Create an ArrayList of Student objects
        List<Student1> studentList1 = new ArrayList<>();
        List<Student1> studentList2 = new ArrayList<>();

        // Create Student objects and add them to the lists
        Student1 s1 = new Student1(1, "Alice");
        Student1 s2 = new Student1(2, "Bob");
        Student1 s3 = new Student1(3, "Charlie");
        Student1 s4 = new Student1(3, "Charlie"); // Duplicate rollNumber
        Student1 s5 = new Student1(4, "David");

        studentList1.add(s1);
        studentList1.add(s2);
        studentList1.add(s3);

        studentList2.add(s3); // Common element
        studentList2.add(s4); // Duplicate rollNumber
        studentList2.add(s5);

        // Print the initial lists
        System.out.println("Initial List 1:");
        for (Student1 student : studentList1) {
            System.out.println("Roll Number: " + student.getRollNumber() + ", Name: " + student.getName());
        }

        System.out.println("Initial List 2:");
        for (Student1 student : studentList2) {
            System.out.println("Roll Number: " + student.getRollNumber() + ", Name: " + student.getName());
        }

        // Remove elements from List 1 that are not in List 2
        studentList1.removeAll(studentList2);

        // Print the result
        System.out.println("List 1 after removeAll:");
        for (Student1 student : studentList1) {
            System.out.println("Roll Number: " + student.getRollNumber() + ", Name: " + student.getName());
        }
    }
}
