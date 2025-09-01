import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class HorizontalScrollBarExample extends JFrame {

    public HorizontalScrollBarExample() {
        setTitle("Horizontal JScrollBar Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a horizontal JScrollBar
        JScrollBar horizontalScrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        horizontalScrollBar.setMaximum(100);
        horizontalScrollBar.setMinimum(0);
        horizontalScrollBar.setValue(50);
        horizontalScrollBar.setUnitIncrement(5);
        horizontalScrollBar.setBlockIncrement(20);

        // Add an AdjustmentListener to handle scrollbar changes
        horizontalScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int value = horizontalScrollBar.getValue();
                System.out.println("Scroll position: " + value);
            }
        });

        // Create a JTextArea with wide content
        JTextArea textArea = new JTextArea(5, 30);
        textArea.setText("This is a very long line of text that will require horizontal scrolling.\n".repeat(10));
        textArea.setLineWrap(false); // Disable line wrapping for horizontal scrolling

        // Add the JTextArea to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Add the JScrollBar to the frame
        add(horizontalScrollBar, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new HorizontalScrollBarExample();
    }
}
