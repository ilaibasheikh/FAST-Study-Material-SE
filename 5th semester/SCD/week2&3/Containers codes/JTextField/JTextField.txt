import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldExample extends JFrame {

    public JTextFieldExample() {
        setTitle("JTextField Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a JTextField with an initial text
        JTextField textField = new JTextField("Enter text here", 20);

        // Add an ActionListener to handle text input
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                System.out.println("Entered text: " + text);
            }
        });

        // Add the JTextField to the frame
        add(textField);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTextFieldExample();
    }
}
