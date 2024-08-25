
import java.util.Scanner;

    public class org {
    public int epnum;
     public String epname;
    public int ephone;
    private float esalary;

    float getEsalary(){
        return esalary;
    }
    void setEsalary( float esalary){
        this.esalary= esalary;
    }

    void display(){
        System.out.println("Employee num= " +epnum);
        System.out.println("Employee name = " +epname);
        System.out.println("Employee phone = " +ephone);
        System.out.println("Employee salary= " +getEsalary() );
    }

    public static void main(String[] args) {
        org e1 = new org();
        org e2 = new org();
        org e3 = new org();

        Scanner A = new Scanner(System.in);
        int num;
        String name;
        int phone;
        float salary;

        System.out.println("Enter the num of employee 1");
        num = A.nextInt();
        e1.epnum = num;
        System.out.println("Enter the name of employee 1");
        name = A.next();
        e1.epname = name;
        System.out.println("Enter the phone of employee 1");
        phone = A.nextInt();
        e1.ephone= phone;
        System.out.println("Enter the salary of employee 1");
        salary = A.nextFloat();
        e1.setEsalary(salary);

        System.out.println("Enter the num of employee 2");
        num = A.nextInt();
        e2.epnum = num;
        System.out.println("Enter the name of employee 2");
        name = A.next();
        e2.epname = name;
        System.out.println("Enter the phone of employee 2");
        phone = A.nextInt();
        e2.ephone= phone;
        System.out.println("Enter the salary of employee 2");
        salary = A.nextFloat();
        e2.setEsalary(salary);

        System.out.println("Enter the num of employee 3");
        num = A.nextInt();
        e3.epnum = num;
        System.out.println("Enter the name of employee 3");
        name = A.next();
        e3.epname = name;
        System.out.println("Enter the phone of employee 3");
        phone = A.nextInt();
        e3.ephone= phone;
        System.out.println("Enter the salary of employee 3");
        salary = A.nextFloat();
        e3.setEsalary(salary);

        float a,b,c;
        a = e1.getEsalary();
        b= e2.getEsalary();
        c= e3.getEsalary();

        System.out.println("Employee details");

        e1.display();
        e2.display();
        e3.display();


        if ((a>b) && (a>c)){
            System.out.println("Employee 1 has highest salary");

        }
        else if ((b>a) && (b>c)){
            System.out.println("Employee 2 has highest salary");
        }
        else {
            System.out.println("Employee 3 has highest salary");
        }
    }
}