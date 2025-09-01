import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDesktopPaneExample extends JFrame {

    private JDesktopPane desktopPane;

    public MyDesktopPaneExample() {
        // Set the title of the JFrame
        setTitle("JDesktopPane Example");

        // Set the size of the JFrame
        setSize(600, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JDesktopPane
        desktopPane = new JDesktopPane();

        // Create and add a JToolBar
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

        // Add the desktop pane to the frame's content pane
        add(desktopPane);

        // Make the frame visible
        setVisible(true);
    }

    // Method to create a new JInternalFrame
    private void createInternalFrame() {
        JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true, true, true, true);
        internalFrame.setSize(200, 150);
        internalFrame.setVisible(true);

        // Add the internal frame to the desktop pane
        desktopPane.add(internalFrame);

        try {
            internalFrame.setSelected(true);  // Bring the internal frame to the front
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create an instance of MyDesktopPaneExample
        new MyDesktopPaneExample();
    }
}
