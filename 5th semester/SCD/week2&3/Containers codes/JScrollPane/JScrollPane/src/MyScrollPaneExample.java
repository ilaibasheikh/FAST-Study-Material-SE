import javax.swing.*;
import java.awt.*;

public class MyScrollPaneExample extends JFrame {

    public MyScrollPaneExample() {
        // Set the title of the JFrame
        setTitle("JScrollPane Example");

        // Set the size of the JFrame
        setSize(400, 300);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JTextArea with some sample text
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setText("This is an example of a JTextArea inside a JScrollPane.\n" +
                         "You can add as much text as you want, and it will become scrollable.\n" +
                         "Line 1\nLine 2\nLine 3\nLine 4\nLine 5\nLine 6\nLine 7\nLine 8\n" +
                         "Line 9\nLine 10\nLine 11\nLine 12\nLine 13\nLine 14\nLine 15\nLine 16");

        // Wrap lines at word boundaries
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Create a JScrollPane and add the JTextArea to it
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Set vertical and horizontal scrollbar policies
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the JScrollPane to the frame's content pane
        add(scrollPane);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of MyScrollPaneExample
        new MyScrollPaneExample();
    }
}
