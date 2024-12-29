import javax.swing.*;
import java.awt.*;

public class ButtonGroupExample extends JFrame {

    public ButtonGroupExample() {
        setTitle("ButtonGroup Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create JRadioButtons
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        JRadioButton radioButton3 = new JRadioButton("Option 3");

        // Create ButtonGroup
        ButtonGroup group = new ButtonGroup();

        // Add radio buttons to the ButtonGroup
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        // Add radio buttons to the frame
        add(radioButton1);
        add(radioButton2);
        add(radioButton3);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonGroupExample();
    }
}
