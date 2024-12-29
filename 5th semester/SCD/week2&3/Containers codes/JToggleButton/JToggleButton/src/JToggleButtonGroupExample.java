import javax.swing.*;
import java.awt.*;

public class JToggleButtonGroupExample extends JFrame {

    public JToggleButtonGroupExample() {
        setTitle("JToggleButton Group Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create JToggleButtons
        JToggleButton toggleButton1 = new JToggleButton("Option 1");
        JToggleButton toggleButton2 = new JToggleButton("Option 2");
        JToggleButton toggleButton3 = new JToggleButton("Option 3");

        // Group toggle buttons
        ButtonGroup group = new ButtonGroup();
        group.add(toggleButton1);
        group.add(toggleButton2);
        group.add(toggleButton3);

        // Add toggle buttons to frame
        add(toggleButton1);
        add(toggleButton2);
        add(toggleButton3);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new JToggleButtonGroupExample();
    }
}
