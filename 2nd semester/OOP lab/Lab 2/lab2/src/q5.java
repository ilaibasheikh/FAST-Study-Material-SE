import java.util.Objects;
import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        String us = "laiba";
        String pw = "fatima";
        String username;
        String password;
        System.out.println("Enter username");
        username = A.nextLine();
        System.out.println("Enter password");
        password = A.nextLine();
        String c;
        int choice;
        float deposit , amount, balance = 1000.0f;
            if ((us.equals(username)) && (pw.equals(password))) {
                System.out.println("You are in");
                do {
                    System.out.println("Main Menu ** Welcome to Bank of Pakistan**");
                    System.out.println("1. Deposit Money");
                    System.out.println("2. Withdraw Amount");
                    System.out.println("3. Account status");
                    System.out.println("Select your choice:");
                    choice = A.nextInt();

                    switch (choice){
                        case 1:
                            System.out.println("How much do you want to deposit");
                            deposit = A.nextFloat();
                            balance = balance + deposit;
                            break;
                        case 2:
                            System.out.println("How much do you want to withdraw");
                            amount = A.nextFloat();
                            balance = balance - amount;
                            break;
                        case 3:
                            if (balance == 0.0f){
                                System.out.println("Account is inactive");
                            }
                            else  {
                                System.out.println("Account is active");
                            }
                            break;
                        default:
                            System.out.println("not valid choice");
                    }

                    System.out.println("Do you want to continue? ");
                    c=A.next();

                } while(c.equals("y") || c.equals("Y"));
                System.out.println(username);
                System.out.println("Your remaining balance is: " + balance);
            }


    }
}
