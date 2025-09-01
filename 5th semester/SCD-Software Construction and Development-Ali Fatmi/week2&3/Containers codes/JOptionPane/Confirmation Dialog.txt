import javax.swing.*;

public class JOptionPaneConfirmationExample {

    public static void main(String[] args) {
        int response = JOptionPane.showConfirmDialog(
            null,
            "Do you want to continue?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (response == JOptionPane.YES_OPTION) {
            System.out.println("User selected Yes");
        } else {
            System.out.println("User selected No");
        }
    }
}
