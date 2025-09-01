import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        System.out.println("Enter variable x");
        int x;
        Scanner A = new Scanner(System.in);
        x = A.nextInt();
        System.out.println("Enter variable y");
        int y;
        y = A.nextInt();
        System.out.println("Enter variable z");
        int z;
        z = A.nextInt();
        int sum, product;
        double avg;

        sum = x+y+z;
        product = x*y*z;
        avg = (x+y+z) / 3 ;

        System.out.println("sum = " +sum);
        System.out.println("Product = "+product);
        System.out.println("Average = "+avg);

    }
}