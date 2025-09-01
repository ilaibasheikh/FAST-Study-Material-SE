import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JFileChooserExample extends JFrame {

    private JLabel filePathLabel;

    public JFileChooserExample() {
        setTitle("JFileChooser Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a label to display the selected file path
        filePathLabel = new JLabel("No file selected", SwingConstants.CENTER);

        // Create a button to open the file chooser
        JButton openFileButton = new JButton("Open File");
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a JFileChooser instance
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(JFileChooserExample.this);

                // Check if a file was selected
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePathLabel.setText("Selected File: " + selectedFile.getAbsolutePath());
                } else {
                    filePathLabel.setText("No file selected");
                }
            }
        });

        // Add components to the frame
        add(filePathLabel, BorderLayout.CENTER);
        add(openFileButton, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JFileChooserExample::new);
    }
}
