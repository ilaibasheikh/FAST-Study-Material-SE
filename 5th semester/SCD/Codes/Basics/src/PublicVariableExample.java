public class PublicVariableExample {
    // Public variable accessible from anywhere
    public int publicVar = 10;

    // Constructor to initialize the publicVar
    public PublicVariableExample(int value) {
        this.publicVar = value;
    }

    // Method to display the value of publicVar
    public void displayPublicVar() {
        System.out.println("publicVar inside the class: " + publicVar);
    }

    public static void main(String[] args) {
        // Create an instance of the class
        PublicVariableExample example = new PublicVariableExample(20);

        // Access the publicVar from inside the class
        example.displayPublicVar();

        // Access the publicVar from outside the class
        System.out.println("publicVar outside the class: " + example.publicVar);
    }
}
