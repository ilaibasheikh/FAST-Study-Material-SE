import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        System.out.println("Enter variable x");
        Scanner A = new Scanner(System.in);
        int x = A.nextInt();
        System.out.println("Enter variable y");
        int y;
        y = A.nextInt();
        System.out.println("Enter variable z");
        int z;
        z = A.nextInt();

        int a;
        a = (3*x)+y;
        int b;
        b = z+2;

        double c ;
        c = a/b;
        System.out.println("Output= "+c);
    }
}