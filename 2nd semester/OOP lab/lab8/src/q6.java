import java.util.Scanner;
 interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
 class SavingsAccount implements BankAccount {

    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}


public class q6 {

    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Get balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    savingsAccount.deposit(depositAmount);
                    System.out.println("Amount deposited successfully!");
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    savingsAccount.withdraw(withdrawAmount);
                    System.out.println("Amount withdrawn successfully!");
                    break;
                case 3:
                    System.out.println("Current balance: " + savingsAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using our application!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
