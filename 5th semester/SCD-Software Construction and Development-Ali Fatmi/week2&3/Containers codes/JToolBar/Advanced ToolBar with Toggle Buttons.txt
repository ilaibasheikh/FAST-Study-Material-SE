import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleButtonToolBarExample extends JFrame {

    public ToggleButtonToolBarExample() {
        // Set the title of the JFrame
        setTitle("Toggle Button ToolBar Example");

        // Set the size of the JFrame
        setSize(400, 300);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JToolBar
        JToolBar toolBar = new JToolBar();

        // Create toggle buttons
        JToggleButton boldButton = new JToggleButton("Bold");
        JToggleButton italicButton = new JToggleButton("Italic");

        // Add ActionListener to toggle buttons
        boldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boldButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Bold selected");
                } else {
                    JOptionPane.showMessageDialog(null, "Bold deselected");
                }
            }
        });

        italicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (italicButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Italic selected");
                } else {
                    JOptionPane.showMessageDialog(null, "Italic deselected");
                }
            }
        });

        // Add the toggle buttons to the toolbar
        toolBar.add(boldButton);
        toolBar.add(italicButton);

        // Add the toolbar to the top of the frame
        add(toolBar, "North");

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of ToggleButtonToolBarExample
        new ToggleButtonToolBarExample();
    }
}
