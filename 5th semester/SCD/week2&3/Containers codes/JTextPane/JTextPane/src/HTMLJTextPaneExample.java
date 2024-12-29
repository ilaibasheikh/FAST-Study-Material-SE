import javax.swing.*;
import java.awt.*;

public class HTMLJTextPaneExample extends JFrame {

    public HTMLJTextPaneExample() {
        setTitle("HTML JTextPane Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JTextPane with HTML content
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText("<html><body><h1>HTML Content</h1><p>This is a paragraph with <b>bold</b> and <i>italic</i> text.</p></body></html>");

        // Add JTextPane to the frame
        add(new JScrollPane(textPane), BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HTMLJTextPaneExample::new);
    }
}
