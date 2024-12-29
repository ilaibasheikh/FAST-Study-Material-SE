import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyToolBarExample extends JFrame {

    public MyToolBarExample() {
        // Set the title of the JFrame
        setTitle("JToolBar Example");

        // Set the size of the JFrame
        setSize(400, 300);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JToolBar
        JToolBar toolBar = new JToolBar();

        // Create some buttons to add to the toolbar
        JButton newButton = new JButton("New");
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");

        // Add an ActionListener to each button
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "New File Created");
            }
        });

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "File Opened");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "File Saved");
            }
        });

        // Add the buttons to the toolbar
        toolBar.add(newButton);
        toolBar.add(openButton);
        toolBar.add(saveButton);

        // Optional: Add a separator between buttons
        toolBar.addSeparator();

        // Optional: Add another component like a label or text field
        toolBar.add(new JLabel("Search:"));
        toolBar.add(new JTextField(10));

        // Add the toolbar to the top of the frame
        add(toolBar, "North");

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of MyToolBarExample
        new MyToolBarExample();
    }
}
