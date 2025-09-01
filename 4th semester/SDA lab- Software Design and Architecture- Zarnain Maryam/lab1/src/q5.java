import java.util.Scanner;
abstract class GameTester{
    abstract void calculateSalary();
}
class FullTimeGameTester extends GameTester{
    @Override
    void calculateSalary() {
        System.out.println("Your salary is $3000");
    }
}
class PartTimeGameTester extends GameTester{
    Scanner a = new Scanner(System.in);
    @Override
    void calculateSalary() {
        System.out.println("Your salary is 20$ per hour");
        System.out.println("Enter your no. of hours");
        int hour = a.nextInt();
        int salary= hour*20;
        System.out.println("Your salary is " +salary +"$");
    }
}
public class q5 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        FullTimeGameTester f = new FullTimeGameTester();
        PartTimeGameTester p = new PartTimeGameTester();
        System.out.println("Enter f or p");
        String choice = a.next();
        switch(choice){
            case "f" :
                f.calculateSalary();
                break;
            case "p" :
                p.calculateSalary();
                break;
            default:
                System.out.println("Error");
        }
    }
}
