import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EditableTableExample extends JFrame {

    public EditableTableExample() {
        setTitle("Editable JTable Example");
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

        // Custom cell renderer
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (column == 1 && value instanceof Integer && (Integer) value > 30) {
                    cell.setBackground(Color.YELLOW);
                } else {
                    cell.setBackground(Color.WHITE);
                }
                return cell;
            }
        });

        // Make the "Age" column editable
        table.setDefaultEditor(Integer.class, new DefaultCellEditor(new JTextField()) {
            @Override
            public Object getCellEditorValue() {
                String text = (String) super.getCellEditorValue();
                return Integer.parseInt(text);
            }
        });

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add JScrollPane to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EditableTableExample::new);
    }
}
