public class AccessModifiersExample {
    // Public variable accessible from anywhere
    public int publicVar = 10;

    // Private variable accessible only within the class
    private int privateVar = 20;

    // Constructor to initialize both variables
    public AccessModifiersExample(int publicValue, int privateValue) {
        this.publicVar = publicValue;
        this.privateVar = privateValue;
    }

    // Method to display the value of privateVar
    public void displayPrivateVar() {
        System.out.println("privateVar inside the class: " + privateVar);
    }

    public static void main(String[] args) {
        // Create an instance of the class
        AccessModifiersExample example = new AccessModifiersExample(30, 40);

        // Access the publicVar from inside the class
        System.out.println("publicVar inside the class: " + example.publicVar);

        // Access the privateVar from inside the class using a method
        example.displayPrivateVar();

        // Attempt to access privateVar directly from outside the class (will result in a compile error)
        // System.out.println("privateVar outside the class: " + example.privateVar);
    }
}
