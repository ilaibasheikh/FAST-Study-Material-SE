import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCheckBoxStateManagementExample extends JFrame {

    public JCheckBoxStateManagementExample() {
        setTitle("JCheckBox State Management Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create JCheckBoxes
        JCheckBox checkBox1 = new JCheckBox("Option 1");
        JCheckBox checkBox2 = new JCheckBox("Option 2");
        JCheckBox checkBox3 = new JCheckBox("Option 3");

        // Add ActionListener to check boxes
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox source = (JCheckBox) e.getSource();
                if (source.isSelected()) {
                    System.out.println(source.getText() + " selected");
                } else {
                    System.out.println(source.getText() + " deselected");
                }
            }
        };

        checkBox1.addActionListener(listener);
        checkBox2.addActionListener(listener);
        checkBox3.addActionListener(listener);

        // Add check boxes to the frame
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new JCheckBoxStateManagementExample();
    }
}
