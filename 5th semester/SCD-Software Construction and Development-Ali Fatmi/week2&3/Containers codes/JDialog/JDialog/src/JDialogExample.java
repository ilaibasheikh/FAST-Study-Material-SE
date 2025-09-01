import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogExample extends JFrame {

    public JDialogExample() {
        setTitle("JDialog Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a button to open the dialog
        JButton openDialogButton = new JButton("Open Dialog");
        openDialogButton.addActionListener(e -> openDialog());

        // Add button to the frame
        add(openDialogButton, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    private void openDialog() {
        // Create a JDialog
        JDialog dialog = new JDialog(this, "Dialog Title", true);

        // Set the size and layout of the dialog
        dialog.setSize(300, 200);
        dialog.setLayout(new FlowLayout());

        // Create a label and a button for the dialog
        JLabel messageLabel = new JLabel("This is a modal dialog.");
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.dispose());

        // Add components to the dialog
        dialog.add(messageLabel);
        dialog.add(closeButton);

        // Center the dialog relative to the parent frame
        dialog.setLocationRelativeTo(this);

        // Make the dialog visible
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JDialogExample::new);
    }
}
