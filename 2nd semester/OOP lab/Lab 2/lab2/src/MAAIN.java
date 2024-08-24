import java.util.Scanner;

class student{
    int studentid;
    String studentname;
    float marks;

    public student() {
        studentid = 1;
        studentname = "Harry";
        marks = 0.1f;
    }

    public student(int id, String n, float m) {
        this.studentid = id;
        this.studentname = n;
        this.marks = m;
    }

    void display(){

        System.out.println("Id = " + studentid);
        System.out.println("name = " +studentname);
        System.out.println("Marks = " +marks);
    }
}


public class MAAIN {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        System.out.println("Enter id ");
        int id = A.nextInt();
        System.out.println("Enter name ");
String name = A.next();
        System.out.println("Enter marks ");
        float marks = A.nextFloat();

        student s1 = new student(id, name, marks);
        student s2 = new student();

        s1.display();
        s2.display();




    }


}
