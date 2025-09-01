import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        String input ;

        System.out.println("Enter a string value:");

        input = a.nextLine();

        String reverse = reverseString(input);


        if (input.equals(reverse)) {
            System.out.println("PALINDROME");
        }
        else {
            System.out.println("NOT PALINDROME");
        }
    }

    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {

            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            start++;
            end--;
        }

        return new String(charArray);
    }
}





