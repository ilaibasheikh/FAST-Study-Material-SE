import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PasswordStrengthExample extends JFrame {

    private JPasswordField passwordField;
    private JLabel strengthLabel;

    public PasswordStrengthExample() {
        setTitle("Password Strength Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a JPasswordField
        passwordField = new JPasswordField(15);
        strengthLabel = new JLabel("Password strength: ");

        // Add a KeyListener to monitor password changes
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String password = new String(passwordField.getPassword());
                strengthLabel.setText("Password strength: " + getPasswordStrength(password));
            }
        });

        // Add components to the frame
        add(new JLabel("Enter your password:"));
        add(passwordField);
        add(strengthLabel);

        // Make the frame visible
        setVisible(true);
    }

    private String getPasswordStrength(String password) {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() < 12) {
            return "Moderate";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        new PasswordStrengthExample();
    }
}
