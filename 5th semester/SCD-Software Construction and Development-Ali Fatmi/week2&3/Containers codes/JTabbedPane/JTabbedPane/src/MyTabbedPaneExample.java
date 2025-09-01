import javax.swing.*;
import java.awt.*;

public class MyTabbedPaneExample extends JFrame {

    public MyTabbedPaneExample() {
        // Set the title of the JFrame
        setTitle("JTabbedPane Example");

        // Set the size of the JFrame
        setSize(400, 300);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for different tabs
        JPanel panel1 = createPanel("This is the content of Tab 1", Color.LIGHT_GRAY);
        JPanel panel2 = createPanel("This is the content of Tab 2", Color.CYAN);
        JPanel panel3 = createPanel("This is the content of Tab 3", Color.PINK);

        // Add the panels to the tabbed pane with a title for each tab
        tabbedPane.addTab("Tab 1", panel1);
        tabbedPane.addTab("Tab 2", panel2);
        tabbedPane.addTab("Tab 3", panel3);

        // Add the tabbed pane to the frame's content pane
        add(tabbedPane);

        // Make the frame visible
        setVisible(true);
    }

    // Helper method to create a panel with a label
    private JPanel createPanel(String text, Color bgColor) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(label);
        return panel;
    }

    public static void main(String[] args) {
        // Create an instance of MyTabbedPaneExample
        new MyTabbedPaneExample();
    }
}
