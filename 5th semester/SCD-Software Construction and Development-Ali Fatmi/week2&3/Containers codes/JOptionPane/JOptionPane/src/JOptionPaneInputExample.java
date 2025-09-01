import javax.swing.*;

public class JOptionPaneInputExample {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(
            null,
            "Enter your name:",
            "Input",
            JOptionPane.QUESTION_MESSAGE
        );

        System.out.println("User entered: " + name);
    }
}
