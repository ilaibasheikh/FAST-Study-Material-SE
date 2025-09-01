import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class JTextPaneExample extends JFrame {

    public JTextPaneExample() {
        setTitle("JTextPane Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JTextPane
        JTextPane textPane = new JTextPane();
        
        // Set some initial styled text
        StyledDocument doc = textPane.getStyledDocument();
        Style style = textPane.addStyle("Style", null);
        
        StyleConstants.setFontFamily(style, "Serif");
        StyleConstants.setFontSize(style, 16);
        StyleConstants.setForeground(style, Color.BLUE);
        StyleConstants.setBold(style, true);
        StyleConstants.setItalic(style, true);
        
        try {
            doc.insertString(doc.getLength(), "Styled Text Example\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        
        // Add some plain text
        try {
            doc.insertString(doc.getLength(), "This is a plain text area where you can type freely.\n", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Add JTextPane to the frame
        add(new JScrollPane(textPane), BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JTextPaneExample::new);
    }
}
