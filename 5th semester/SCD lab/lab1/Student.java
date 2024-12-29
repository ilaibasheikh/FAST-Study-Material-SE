import java.util.Scanner;

public class Student {
    private String FirstName;
    private String LastName;
    private int RollNumber;
    private String Major;
    private int CompletedCreditHrs;
    private int TotalCreditHrs;
    private float GPA;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(int rollNumber) {
        RollNumber = rollNumber;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public int getCompletedCreditHrs() {
        return CompletedCreditHrs;
    }

    public void setCompletedCreditHrs(int completedCreditHrs) {
        CompletedCreditHrs = completedCreditHrs;
    }

    public int getTotalCreditHrs() {
        return TotalCreditHrs;
    }

    public void setTotalCreditHrs(int totalCreditHrs) {
        TotalCreditHrs = totalCreditHrs;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public float CalculateGPA(){

        return CompletedCreditHrs/TotalCreditHrs;
    }

    public void display(){
        System.out.println("First Name: " +getFirstName() );
        System.out.println("Last Name: " +getLastName());
        System.out.println("Roll Number: " +getRollNumber());
        System.out.println("GPA: " +CalculateGPA());
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        Student s1 = new Student();
        System.out.println("Whats your first name?");
        s1.setFirstName(inp.next());
        System.out.println("Whats your last name?");
        s1.setLastName(inp.next());
        System.out.println("Whats your roll number?");
        s1.setRollNumber(inp.nextInt());
        System.out.println("Enter number of credit hours completed");
        s1.setCompletedCreditHrs(inp.nextInt());
        System.out.println("Enter number of credit hours required");
        s1.setTotalCreditHrs(inp.nextInt());


        s1.display();


    }
}
