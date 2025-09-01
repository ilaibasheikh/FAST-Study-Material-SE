import java.util.ArrayList;
import java.util.List;

// Define a Student class with specific properties
class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNumber=" + rollNumber + "]";
    }
}

// Define a Teacher class with specific properties
class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher [name=" + name + ", subject=" + subject + "]";
    }
}

public class GernericUsageExample {
    public static void main(String[] args) {
        // Create a generic list for students
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alice", 101));
        studentList.add(new Student("Bob", 102));

        // Create a generic list for teachers
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("Mr. Smith", "Math"));
        teacherList.add(new Teacher("Ms. Johnson", "History"));

        // Using generics, no need for typecasting
        Student student1 = studentList.get(0); // Retrieving a Student object
        Teacher teacher1 = teacherList.get(0); // Retrieving a Teacher object

        System.out.println("Student 1: " + student1);
        System.out.println("Teacher 1: " + teacher1);

        // Without generics, typecasting required
        Object obj = teacherList.get(1);
        Teacher teacher2 = (Teacher) obj; // Typecasting to Teacher

        
        Teacher teacher3 = (Teacher)teacherList.get(1); // Typecasting to Teacher

        
        System.out.println("Teacher 2: " + teacher2);

        // Accessing generic list without typecasting
        for (Student student : studentList) {
            System.out.println("Student: " + student);
        }

        // Creating a non-generic list without specifying the type
        List nonGenericList = new ArrayList();

        // Adding a Student and a Teacher to the non-generic list
        nonGenericList.add(new Student("Carol", 103));
        nonGenericList.add(new Teacher("Mr. Brown", "Science"));

        // Attempting to retrieve elements from the non-generic list
        // This will cause a runtime error due to lack of type information
        for (int i = 0; i < nonGenericList.size(); i++) {
            Object element = nonGenericList.get(i);
            // Try to cast the element to Student
            try {
                Student student = (Student) element; // This may throw ClassCastException
                System.out.println("Student: " + student);
            } catch (ClassCastException e) {
                System.out.println("Runtime Error: Cannot cast to Student.");
            }
        }
    }
}
