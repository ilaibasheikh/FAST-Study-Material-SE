import javax.swing.*;
import java.awt.*;

public class AdvancedInternalFrameExample extends JFrame {

    private JDesktopPane desktopPane;

    public AdvancedInternalFrameExample() {
        setTitle("Advanced JInternalFrame Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        add(desktopPane);

        createInternalFrame("Document 1", 50, 50);
        createInternalFrame("Document 2", 100, 100);

        setVisible(true);
    }

    private void createInternalFrame(String title, int x, int y) {
        JInternalFrame internalFrame = new JInternalFrame(title, true, true, true, true);
        internalFrame.setSize(300, 200);
        internalFrame.setLocation(x, y);
        internalFrame.setVisible(true);

        JTextArea textArea = new JTextArea("Enter your text here...");
        JButton saveButton = new JButton("Save");
        JButton closeButton = new JButton("Close");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        internalFrame.getContentPane().add(panel);

        saveButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Document Saved!"));
        closeButton.addActionListener(e -> internalFrame.dispose());

        desktopPane.add(internalFrame);
        try {
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AdvancedInternalFrameExample();
    }
}
