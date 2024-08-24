abstract class bank {
    abstract void getBalance();
}
class BankA extends bank {
    public void getBalance(){
        System.out.println("$100 deposited");
    }
}
class BankB extends bank {
    public void getBalance(){
        System.out.println("$150 deposited");
    }
}
class BankC extends bank {
    public void getBalance(){
        System.out.println("$200 deposited");
    }
}
public class q1 {
    public static void main(String[] args) {
        bank obj = new BankA();
        obj.getBalance();
        bank obj1 = new BankB();
        obj1.getBalance();
        bank obj2 = new BankC();
        obj2.getBalance();
    }
}