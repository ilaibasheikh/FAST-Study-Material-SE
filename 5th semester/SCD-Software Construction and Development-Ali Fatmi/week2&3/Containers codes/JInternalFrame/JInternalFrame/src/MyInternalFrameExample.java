import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyInternalFrameExample extends JFrame {

    private JDesktopPane desktopPane;

    public MyInternalFrameExample() {
        // Set the title of the JFrame
        setTitle("JInternalFrame Example");

        // Set the size of the JFrame
        setSize(600, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JDesktopPane
        desktopPane = new JDesktopPane();

        // Add the desktop pane to the frame's content pane
        add(desktopPane);

        // Create and add a JToolBar with a button to create new internal frames
        JToolBar toolBar = new JToolBar();
        JButton newFrameButton = new JButton("New Frame");
        toolBar.add(newFrameButton);
        add(toolBar, "North");

        // Add an ActionListener to the button to create a new internal frame
        newFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInternalFrame();
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    // Method to create a new JInternalFrame
    private void createInternalFrame() {
        // Create a new internal frame with basic properties
        JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true, true, true, true);
        internalFrame.setSize(300, 200);
        internalFrame.setVisible(true);

        // Add the internal frame to the desktop pane
        desktopPane.add(internalFrame);

        try {
            // Bring the internal frame to the front
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create an instance of MyInternalFrameExample
        new MyInternalFrameExample();
    }
}
