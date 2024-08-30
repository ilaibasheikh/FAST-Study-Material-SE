import java.util.Scanner;
interface Teacher{
     void inputTeacher();
     void displayTeacher();
}
interface Author {
    void inputAuthor();
    void displayAuthor();
}
class Scholar implements Teacher, Author{
    Scanner a = new Scanner(System.in);
    String teacherName;
    int teacherAge;
    String teacherAddress;
    String authorName;
    String authorAddress;
    int numberOfBooks;
    @Override
    public void inputTeacher() {
        System.out.println("Enter teacher name: ");
        teacherName = a.next();
        System.out.println("Enter teacher age: ");
        teacherAge = a.nextInt();
        System.out.println("Enter teacher address: ");
        teacherAddress = a.next();
    }
    @Override
    public void displayTeacher() {
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Teacher Age: " + teacherAge);
        System.out.println("Teacher Address: " + teacherAddress);
    }
    @Override
    public void inputAuthor() {
        System.out.println("Enter author name: ");
        authorName = a.next();
        System.out.println("Enter author address: ");
        authorAddress = a.next();
        System.out.println("Enter Number of Books Written: ");
        numberOfBooks = a.nextInt();
    }
    @Override
    public void displayAuthor() {
        System.out.println("Author Name: " + authorName);
        System.out.println("Author Address: " + authorAddress);
        System.out.println("Number of Books Written: " + numberOfBooks);
    }
}
public class q3 {
    public static void main(String[] args) {
        Scholar s = new Scholar();
        s.inputTeacher();
        s.inputAuthor();
        s.displayTeacher();
        s.displayAuthor();
    }
}
