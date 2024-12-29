import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPasswordFieldExample extends JFrame {

    public JPasswordFieldExample() {
        setTitle("JPasswordField Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a JPasswordField
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setEchoChar('*'); // Set the character used to mask the input

        // Create a JButton to retrieve the password
        JButton showPasswordButton = new JButton("Show Password");
        showPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the password from the JPasswordField
                char[] password = passwordField.getPassword();
                // Convert char array to String
                String passwordStr = new String(password);
                // Display the password
                JOptionPane.showMessageDialog(null, "Password: " + passwordStr);
            }
        });

        // Add components to the frame
        add(new JLabel("Enter your password:"));
        add(passwordField);
        add(showPasswordButton);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new JPasswordFieldExample();
    }
}
