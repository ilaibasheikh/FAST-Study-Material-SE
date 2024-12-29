import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CustomJFileChooserExample extends JFrame {

    private JLabel filePathLabel;

    public CustomJFileChooserExample() {
        setTitle("Custom JFileChooser Example");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        filePathLabel = new JLabel("No file selected", SwingConstants.CENTER);

        JButton openFileButton = new JButton("Open File");
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png"));
                int returnValue = fileChooser.showOpenDialog(CustomJFileChooserExample.this);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePathLabel.setText("Selected File: " + selectedFile.getAbsolutePath());
                } else {
                    filePathLabel.setText("No file selected");
                }
            }
        });

        JButton saveFileButton = new JButton("Save File");
        saveFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
                int returnValue = fileChooser.showSaveDialog(CustomJFileChooserExample.this);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePathLabel.setText("File to Save: " + selectedFile.getAbsolutePath());
                } else {
                    filePathLabel.setText("No file selected");
                }
            }
        });

        add(filePathLabel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openFileButton);
        buttonPanel.add(saveFileButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomJFileChooserExample::new);
    }
}
