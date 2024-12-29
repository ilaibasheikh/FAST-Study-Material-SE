import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class PlaceholderTextFieldExample extends JFrame {

    public PlaceholderTextFieldExample() {
        setTitle("Placeholder JTextField Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a JTextField with placeholder text
        JTextField textField = new JTextField(20);
        textField.setText("Enter text here");
        textField.setForeground(Color.GRAY);

        // Add a DocumentListener to handle placeholder logic
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePlaceholder();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePlaceholder();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePlaceholder();
            }

            private void updatePlaceholder() {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText("Enter text here");
                } else {
                    textField.setForeground(Color.BLACK);
                }
            }
        });

        // Add the JTextField to the frame
        add(textField);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new PlaceholderTextFieldExample();
    }
}
