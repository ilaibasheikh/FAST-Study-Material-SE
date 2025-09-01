abstract class Vehicle{
    abstract void startEngine();
    abstract void stopEngine();
}
class car extends Vehicle{
    @Override
    void startEngine() {
        System.out.println("Car started");
    }
    @Override
    void stopEngine() {
        System.out.println("Car stopped");
    }
}
class Motorcycle extends Vehicle{
    @Override
    void startEngine() {
        System.out.println("Motorcycle started");
    }
    @Override
    void stopEngine() {
        System.out.println("Motorcycle stopped");
    }
}
public class q4 {
    public static void main(String[] args) {
        car c = new car();
        c.startEngine();
        c.stopEngine();
        Motorcycle m = new Motorcycle();
        m.startEngine();
        m.stopEngine();
    }
}
