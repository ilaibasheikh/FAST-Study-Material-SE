class account{
    double balance;
    public account() {
    }

    public account(double balance) {
        this.balance = balance;
    }

    public void debit(double value){
        if(value<=balance){
            balance=balance-value;
        }
        else{
            System.out.println("Insufficient balance");
        }

    }
    public void credit(float value){
        balance=balance+value;
    }
    public double getBalance() {
        return balance;
    }
}
class saving extends account{
    int time;
    double interest;


    public saving(double balance, int time) {
        super(balance);
        this.time = time;
    }
    public void calculateInterest(double rate) {
        interest = getBalance() * rate * time;
    }
    public void credit(){
        balance = getBalance() +interest;
    }
}
class checking extends account{
    @Override
    public double getBalance() {
        return super.getBalance();
    }
}
public class q4{
    public static void main(String[] args) {
        saving s = new saving(1000,4);
        System.out.println("Before transactions");
        System.out.println(s.getBalance());
        s.calculateInterest(0.05);
        s.credit();
        s.debit(120);
        System.out.println("After transactions:");
        System.out.println(s.getBalance() );
    }
}