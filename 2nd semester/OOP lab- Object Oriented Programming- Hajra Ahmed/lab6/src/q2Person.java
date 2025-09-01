import java.util.Scanner;

public class q2Person {

    protected String name, nationality, address, cnic;
    protected int age;
    q2Person() {
        System.out.println("I am a person");
    }


    public void Input(){
        Scanner A= new Scanner(System.in);
        System.out.println("Enter name");
        name = A.next();
        System.out.println("Enter nationality");
        nationality = A.next();
        System.out.println("Enter address");
        address = A.next();
        System.out.println("Enter age");
        age = A.nextInt();
        do {
            System.out.println("Enter cnic");
            cnic = A.next();
            if (cnic.length() != 13) {
                System.out.println("Digits are not 13");
            }
        }while (cnic.length() != 13);



    }
    public void display(){
        System.out.println(name);
        System.out.println(nationality);
        System.out.println(address);
        System.out.println(age);
        System.out.println(cnic);
    }
}
class Employee extends q2Person{
    protected String company,city;
    protected int years;
    public Employee() {
        super();
        System.out.println("I am an employee");
    }
    public void Input(){
        Scanner A = new Scanner(System.in);
        System.out.println("Enter company name");
        company = A.next();
        System.out.println("Enter city name");
        city = A.next();
        System.out.println("Enter years");
        years = A.nextInt();
    }
    public void display(){
        System.out.println(company);
        System.out.println(city);
        System.out.println(years);

    }
}

class Manager extends Employee{
    Scanner A = new Scanner(System.in);
    String arr[]= new String[5];
    public Manager() {
        super();
        System.out.println("I am a manager");
    }
    public void Input(){
        for(int i =0;i<5;i++){
            System.out.println("Enter name of employee" +(i+1) );
            arr[i]= A.next();
        }
    }

    public void display() {
        for (int i = 0; i < 5; i++) {
            System.out.println(" name of employee" + (i + 1) + " " + arr[i]);
        }

    }

    public static void main(String[] args) {
        q2Person p = new q2Person();
        p.Input();
        p.display();
        Employee e = new Employee();
        e.Input();
        e.display();
        Manager m = new Manager();
        m.Input();
        m.display();
    }

}
