import java.util.ArrayList;
import java.util.Scanner;

public class q4 {
    public static boolean isprime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {


        Scanner A = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        System.out.println("Enter the 5 numbers");
        for (int i = 0; i < 5; i++) {
            list.add(A.nextInt());
        }


        boolean prime = false;
        for (int number : list) {
            if (isprime(number)){
                prime = true;
                break;
            }
            }

        System.out.println(prime);


        if (prime) {
            System.out.println("The list has prime numbers");
            for (int i = 0; i < list.size(); i = i + 2) {
                sum = sum + list.get(i);
            }
        }
        else  {
            System.out.println("The list does not have prime numbers");
            for (int i = 1; i < list.size(); i = i + 2) {
                sum =sum + list.get(i);
            }

        }
        System.out.println("The sum is " + sum);
    }
}
