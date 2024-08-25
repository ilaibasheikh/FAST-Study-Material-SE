public class Task1 {
    public static void main(String[] args) {
        int result = sum(5, 10);
        System.out.println("The sum of numbers between 5 and 10 is : " + result);
    }

    public static int sum(int start, int end) {
        if (start > end) {
            return 0;
        }
        else {
            return start + sum(start + 1, end);
        }
    }
}
