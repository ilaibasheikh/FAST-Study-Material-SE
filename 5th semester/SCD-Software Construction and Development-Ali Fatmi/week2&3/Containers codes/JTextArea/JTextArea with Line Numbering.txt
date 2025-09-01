import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class LineNumberedTextArea extends JFrame {

    public LineNumberedTextArea() {
        setTitle("Line Numbered JTextArea Example");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JTextArea
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Create a JTextArea for line numbers
        JTextArea lineNumberArea = new JTextArea("1\n2\n3\n4\n5\n", 10, 3);
        lineNumberArea.setEditable(false);
        lineNumberArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        lineNumberArea.setBackground(Color.LIGHT_GRAY);

        // Add a DocumentListener to update line numbers
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not needed
            }

            private void updateLineNumbers() {
                int lines = textArea.getLineCount();
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= lines; i++) {
                    sb.append(i).append("\n");
                }
                lineNumberArea.setText(sb.toString());
            }
        });

        // Add components to the frame
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(lineNumberArea, BorderLayout.WEST);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new LineNumberedTextArea();
    }
}
