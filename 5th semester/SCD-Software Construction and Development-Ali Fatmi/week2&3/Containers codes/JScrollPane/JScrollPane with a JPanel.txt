import javax.swing.*;
import java.awt.*;

public class ScrollablePanelExample extends JFrame {

    public ScrollablePanelExample() {
        // Set the title of the JFrame
        setTitle("Scrollable JPanel Example");

        // Set the size of the JFrame
        setSize(400, 300);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with a large preferred size
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20, 1));  // 20 rows, 1 column
        panel.setPreferredSize(new Dimension(300, 1000));  // Much taller than the frame

        // Add some components to the panel
        for (int i = 1; i <= 20; i++) {
            panel.add(new JLabel("Label " + i));
        }

        // Create a JScrollPane and add the JPanel to it
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the JScrollPane to the frame
        add(scrollPane);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of ScrollablePanelExample
        new ScrollablePanelExample();
    }
}
