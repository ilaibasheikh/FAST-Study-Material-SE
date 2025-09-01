import java.util.Scanner;

public class employee {
    String firstname;
    String lastname;
    double salary;

    void display(){
        System.out.println("Employee first name= " +firstname);
        System.out.println("Employee last name = " +lastname);
        System.out.println("Employee salary= " +salary );
    }
    public static void main(String[] args) {
        employee e1 = new employee();
        employee e2 = new employee();

        String fname, lname;
        double sal;
        double a,b , c, d;
        Scanner A = new Scanner(System.in);
        System.out.println("Enter the first name of employee 1");
        fname = A.next();
        e1.firstname = fname;
        System.out.println("Enter the last name of employee 1");
        lname = A.next();
        e1.lastname = lname;
        System.out.println("Enter the salary of employee 1");
        sal = A.nextDouble();
        e1.salary = sal;
        a= sal * 0.1;
        b= sal + a;

        System.out.println("Enter the first name of employee 2");
        fname = A.next();
        e2.firstname = fname;
        System.out.println("Enter the last name of employee 2");
        lname = A.next();
        e2.lastname = lname;
        System.out.println("Enter the salary of employee 2");
        sal = A.nextDouble();
        e2.salary = sal;
        c= sal * 0.1;
        d= sal + c;

        System.out.println("Displaying:");

        e1.display();
        e2.display();

        e1.salary = b;
        e2.salary = d;

        System.out.println("Displaying after 10% raise:");

        e1.display();
        e2.display();





    }
}

