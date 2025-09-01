import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class JFormattedTextFieldExample extends JFrame {

    public JFormattedTextFieldExample() {
        setTitle("JFormattedTextField Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a NumberFormat for formatting numeric input
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false); // Prevent invalid input

        // Create a JFormattedTextField with the number formatter
        JFormattedTextField formattedTextField = new JFormattedTextField(numberFormatter);
        formattedTextField.setColumns(15);
        formattedTextField.setValue(1234); // Set initial value

        // Add the JFormattedTextField to the frame
        add(new JLabel("Enter a number:"));
        add(formattedTextField);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new JFormattedTextFieldExample();
    }
}
