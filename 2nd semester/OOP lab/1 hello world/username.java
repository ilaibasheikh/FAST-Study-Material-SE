import java.util.Scanner;

public class username {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        System.out.println("Enter your username");
        String username;
        username = A.nextLine();
        System.out.println("Your username is " +username);
    }
}
