import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanelExample extends JFrame {

    public MyPanelExample() {
        // Set the title of the JFrame
        setTitle("JPanel Example");

        // Set the size of the JFrame
        setSize(400, 200);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel
        JPanel panel = new JPanel();

        // Set layout for the panel (optional, but allows more control)
        panel.setLayout(new GridBagLayout());

        // Create GridBagConstraints for layout positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Set padding

        // Create a label and add it to the panel
        JLabel label = new JLabel("Enter your name:");
        gbc.gridx = 0;  // Column 0
        gbc.gridy = 0;  // Row 0
        panel.add(label, gbc);

        // Create a text field and add it to the panel
        JTextField textField = new JTextField(15);
        gbc.gridx = 1;  // Column 1
        gbc.gridy = 0;  // Row 0
        panel.add(textField, gbc);

        // Create a button and add it to the panel
        JButton button = new JButton("Submit");
        gbc.gridx = 0;  // Column 0
        gbc.gridy = 1;  // Row 1
        gbc.gridwidth = 2;  // Span two columns
        panel.add(button, gbc);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                JOptionPane.showMessageDialog(panel, "Hello, " + name + "!");
            }
        });

        // Add the panel to the frame's content pane
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of MyPanelExample
        new MyPanelExample();
    }
}

