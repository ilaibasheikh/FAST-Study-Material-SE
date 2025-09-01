import javax.swing.*;
import java.awt.*;

public class MySplitPaneExample extends JFrame {

    public MySplitPaneExample() {
        // Set the title of the JFrame
        setTitle("JSplitPane Example");

        // Set the size of the JFrame
        setSize(600, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create two panels to be placed in the split pane
        JPanel leftPanel = createPanel("Left Panel", Color.CYAN);
        JPanel rightPanel = createPanel("Right Panel", Color.PINK);

        // Create a JSplitPane with horizontal split
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

        // Set the divider location (initial position)
        splitPane.setDividerLocation(250);

        // Set the continuous layout property
        splitPane.setContinuousLayout(true);

        // Set the one-touch expandable feature
        splitPane.setOneTouchExpandable(true);

        // Add the split pane to the frame's content pane
        add(splitPane);

        // Make the frame visible
        setVisible(true);
    }

    // Helper method to create a panel with a label
    private JPanel createPanel(String text, Color bgColor) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(label);
        return panel;
    }

    public static void main(String[] args) {
        // Create an instance of MySplitPaneExample
        new MySplitPaneExample();
    }
}
