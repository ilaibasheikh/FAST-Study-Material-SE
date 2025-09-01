import javax.swing.*;
import java.awt.*;

public class JSeparatorExample extends JFrame {

    public JSeparatorExample() {
        setTitle("JSeparator Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JPanel with a FlowLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1)); // Vertical layout for separators

        // Create some buttons to display
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // Create horizontal separators
        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);

        // Add components to the panel
        panel.add(button1);
        panel.add(separator1);
        panel.add(button2);
        panel.add(separator2);
        panel.add(button3);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new JSeparatorExample();
    }
}
