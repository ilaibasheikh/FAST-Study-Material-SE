import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameExample {

    public JFrameExample() {
        // Create a JFrame instance
        JFrame frame = new JFrame("JFrame Example");

        // Set the size of the frame
        frame.setSize(400, 300);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout manager
        frame.setLayout(new FlowLayout());

        // Create a label and a button
        JLabel label = new JLabel("Hello, Swing!");
        JButton button = new JButton("Click Me");

        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        // Add components to the frame
        frame.add(label);
        frame.add(button);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Invoke the JFrameExample constructor on the Event Dispatch Thread
        SwingUtilities.invokeLater(JFrameExample::new);
    }
}
