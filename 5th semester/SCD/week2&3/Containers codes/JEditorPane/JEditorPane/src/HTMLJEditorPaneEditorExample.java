import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.IOException;

public class HTMLJEditorPaneEditorExample extends JFrame {

    public HTMLJEditorPaneEditorExample() {
        setTitle("HTML Editor with JEditorPane");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JEditorPane for editing HTML
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText("<html><body><h1>Edit this HTML content</h1></body></html>");

        // Add a DocumentListener to detect changes
        editorPane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Text inserted");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Text removed");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Text changed");
            }
        });

        // Add editorPane to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(editorPane);

        // Add JScrollPane to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Add a button to save content
        JButton saveButton = new JButton("Save Content");
        saveButton.addActionListener(e -> {
            try {
                String content = editorPane.getText();
                // Here you can save the content to a file or process it as needed
                System.out.println("Content saved: \n" + content);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        add(saveButton, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HTMLJEditorPaneEditorExample::new);
    }
}
