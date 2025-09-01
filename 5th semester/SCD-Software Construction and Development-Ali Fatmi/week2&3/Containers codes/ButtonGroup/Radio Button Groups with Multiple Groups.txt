import javax.swing.*;
import java.awt.*;

public class MultipleButtonGroupsExample extends JFrame {

    public MultipleButtonGroupsExample() {
        setTitle("Multiple ButtonGroups Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        // Create first set of radio buttons
        JRadioButton rb1 = new JRadioButton("Group 1 - Option 1");
        JRadioButton rb2 = new JRadioButton("Group 1 - Option 2");
        JRadioButton rb3 = new JRadioButton("Group 1 - Option 3");

        // Create second set of radio buttons
        JRadioButton rb4 = new JRadioButton("Group 2 - Option 1");
        JRadioButton rb5 = new JRadioButton("Group 2 - Option 2");
        JRadioButton rb6 = new JRadioButton("Group 2 - Option 3");

        // Create ButtonGroups
        ButtonGroup group1 = new ButtonGroup();
        ButtonGroup group2 = new ButtonGroup();

        // Add radio buttons to ButtonGroups
        group1.add(rb1);
        group1.add(rb2);
        group1.add(rb3);
        group2.add(rb4);
        group2.add(rb5);
        group2.add(rb6);

        // Add radio buttons to the frame
        add(rb1);
        add(rb2);
        add(rb3);
        add(rb4);
        add(rb5);
        add(rb6);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new MultipleButtonGroupsExample();
    }
}
