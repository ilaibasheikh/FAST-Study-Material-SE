import javax.swing.*;
import java.awt.*;

public class VerticalSeparatorExample extends JFrame {

    public VerticalSeparatorExample() {
        setTitle("Vertical Separator Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create some buttons to display
        JButton leftButton = new JButton("Left Button");
        JButton rightButton = new JButton("Right Button");

        // Create a vertical separator
        JSeparator verticalSeparator = new JSeparator(SwingConstants.VERTICAL);

        // Add components to the frame
        add(leftButton, BorderLayout.WEST);
        add(verticalSeparator, BorderLayout.CENTER);
        add(rightButton, BorderLayout.EAST);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new VerticalSeparatorExample();
    }
}
