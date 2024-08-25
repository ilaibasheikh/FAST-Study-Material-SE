import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Start of range:");
        int start = a.nextInt();
        System.out.println("End of range:");
        int end = a.nextInt();

        System.out.println("Composite numbers in the given range " + start + " to " + end + ":");
        Composites(start, end);
        System.out.println();
        System.out.println("Prime numbers in the givenrange " + start + " to " + end + ":");
        Primes(start, end);
    }

    public static void Composites(int start, int end) {
        if (start > end) {
            return;
        }

        if (isComposite(start)) {
            System.out.print(start + " ");
        }

        Composites(start + 1, end);
    }

    public static boolean isComposite(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return true;
            }
        }

        return false;
    }
    public static void Primes(int start, int end) {
        if (start > end) {
            return;
        }

        if (isPrime(start)) {
            System.out.print(start + " ");
        }

        Primes(start + 1, end);
    }



    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}


