
public class Task2a {
    public static int arithmeticSequence(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n + arithmeticSequence(n - 1);
        }
    }

    public static void main(String[] args) {
        int terms = 7;


        System.out.println("The arithmetic sequence is: ");
        for (int i = 1; i <= terms; i++) {
            System.out.println( arithmeticSequence(i));
        }
    }
}



