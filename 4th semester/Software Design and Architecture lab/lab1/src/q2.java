import java.util.Scanner;
class BankAccount{
    Scanner a = new Scanner(System.in);
    int accountbalance ;
   public void deposit(){
        accountbalance=100;
        System.out.println("Your balance is " +accountbalance);
        System.out.println("Amount to deposit:");
        int amount = a.nextInt();
        accountbalance += amount;
        System.out.println("Your updated balance is " +accountbalance);
    }
    public void withdraw(){
        System.out.println("Amount to withdraw:");
        int amount = a.nextInt();
        if (amount <accountbalance){
            System.out.println("Withdrawn");
            accountbalance -= amount;
            System.out.println("Your updated balance is " +accountbalance);
        }
        else{
            System.out.println("Error");
        }
    }
}
class SavingsAccount extends BankAccount{
    @Override
   public void withdraw() {
        System.out.println("Enter your account balance");
       int accbalance = a.nextInt();
        System.out.println("Your balance is " +accbalance);
        if (accbalance <100){
            System.out.println("Can't withdraw");
        }
        else{
            super.withdraw();
        }
    }
}
public class q2 {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.deposit();
        b.withdraw();
        SavingsAccount s = new SavingsAccount();
        s.withdraw();
    }
}
