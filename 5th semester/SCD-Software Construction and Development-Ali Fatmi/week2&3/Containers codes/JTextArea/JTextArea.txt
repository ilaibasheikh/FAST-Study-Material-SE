import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaExample extends JFrame {

    public JTextAreaExample() {
        setTitle("JTextArea Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JTextArea with initial text
        JTextArea textArea = new JTextArea("Enter your text here", 10, 30);
        textArea.setWrapStyleWord(true); // Wrap text by word
        textArea.setLineWrap(true); // Enable line wrapping

        // Add a scroll pane for the text area
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add an ActionListener to handle button clicks
        JButton printButton = new JButton("Print Text");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                System.out.println("Entered text: " + text);
            }
        });

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(printButton, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTextAreaExample();
    }
}
