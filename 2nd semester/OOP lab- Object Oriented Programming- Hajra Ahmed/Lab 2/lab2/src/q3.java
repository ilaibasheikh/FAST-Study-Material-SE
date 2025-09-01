import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        int n;
        System.out.println("Enter a number");
        n = A.nextInt();
        if (n % 3 == 0) {
            if (n % 5 == 0) {
                System.out.println("The number " + n + " is divisible by both 3 and 5");
            }
            else {
                System.out.println("The number " + n + " is divisible by 3 ");
            }
        }
        else if (n % 5 == 0) {
            System.out.println("The number " + n + " is divisible by 5 ");

        }
    }
}