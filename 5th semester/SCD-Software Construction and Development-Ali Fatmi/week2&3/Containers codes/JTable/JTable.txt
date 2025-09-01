import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JTableExample extends JFrame {

    public JTableExample() {
        setTitle("JTable Example");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Column names
        String[] columnNames = {"Name", "Age", "City"};

        // Data to be displayed in the table
        Object[][] data = {
            {"John Doe", 30, "New York"},
            {"Jane Smith", 25, "Los Angeles"},
            {"Alice Johnson", 35, "Chicago"}
        };

        // Create a DefaultTableModel with data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        JTable table = new JTable(model);

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add JScrollPane to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JTableExample::new);
    }
}
