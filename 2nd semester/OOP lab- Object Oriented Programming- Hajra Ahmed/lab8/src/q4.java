abstract class Animals {
    public abstract void cats();
    public abstract void dogs();
}

class Cats extends Animals {
    public void cats() {
        System.out.println("Cats meow");
    }
    public void dogs() {
        // Do nothing, as Cats don't bark.
    }
}

class Dogs extends Animals {
    public void cats() {
        // Do nothing, as Dogs don't meow.
    }
    public void dogs() {
        System.out.println("Dogs bark");
    }
}

public class q4 {
    public static void main(String[] args) {
        Animals cat = new Cats();
        cat.cats(); // Output: "Cats meow"

        Animals dog = new Dogs();
        dog.dogs(); // Output: "Dogs bark"
    }
}

