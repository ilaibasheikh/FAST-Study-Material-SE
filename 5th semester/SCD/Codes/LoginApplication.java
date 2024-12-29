import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApplication {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel usernameLabel, passwordLabel, messageLabel;
    private static JTextField usernameField, passwordField;
    private static JButton loginButton;

    public static void main(String[] args) {
        frame = new JFrame("Login Page");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        messageLabel = new JLabel("");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                String password = passwordField.getText();
                if (password.contains("_") || password.contains("@")) {
                    messageLabel.setText("Password contains '_' or '@' and is not required.");
                } else {
                    messageLabel.setText("Login Successful!");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(messageLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
