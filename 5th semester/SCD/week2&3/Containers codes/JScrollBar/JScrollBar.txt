import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class JScrollBarExample extends JFrame {

    public JScrollBarExample() {
        setTitle("JScrollBar Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a vertical JScrollBar
        JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL);
        verticalScrollBar.setMaximum(100);
        verticalScrollBar.setMinimum(0);
        verticalScrollBar.setValue(50);
        verticalScrollBar.setUnitIncrement(5); // Scroll amount for single click
        verticalScrollBar.setBlockIncrement(20); // Scroll amount for large click

        // Add an AdjustmentListener to handle scrollbar changes
        verticalScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int value = verticalScrollBar.getValue();
                System.out.println("Scroll position: " + value);
            }
        });

        // Create a text area with some content
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setText("Scroll down to see more content...\n".repeat(50));

        // Add the JTextArea to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Add the JScrollBar to the frame
        add(verticalScrollBar, BorderLayout.EAST);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new JScrollBarExample();
    }
}
