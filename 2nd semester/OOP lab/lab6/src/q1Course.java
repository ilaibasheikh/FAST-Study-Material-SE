import java.util.Scanner;

public class q1Course {
    protected String coursename, coursecode, classvenue;
    protected int credithours;

    public q1Course(String a, String b, String c, int d) {
        this.coursename = a;
        this.classvenue = b;
        this.coursecode = c;
        this.credithours = d;
    }
}
class JavaCourse extends q1Course {
    protected String teachername;

    public JavaCourse(String a, String b, String c, int d) {
        super(a, b, c, d);
        this.teachername = "Laiba";
    }

    public void display(){
        System.out.println(coursename);
        System.out.println(teachername);
        System.out.println(coursecode);
        System.out.println(classvenue);
        System.out.println(credithours);
    }

    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        String a, b, c, tn;
        int d;


        System.out.println("Enter course name");
        a = A.next();
        System.out.println("Enter course code");
        b= A.next();
        System.out.println("Enter class venue");
        c= A.next();
//        System.out.println("Enter teacher name");
    //    tn= A.next();
        System.out.println("Enter credit hours");
        d= A.nextInt();

        JavaCourse J = new JavaCourse(a,b,c,d);
        J.display();
    }
}