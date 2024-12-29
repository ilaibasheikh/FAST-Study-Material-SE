import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPanel extends JFrame {
    private JTable ordersTable;
    private JComboBox<String> statusComboBox;
    private JButton updateStatusButton;
    private DefaultTableModel tableModel;

    public AdminPanel() {
        setTitle("Admin Order Management");
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Order ID", "User ID", "Item ID", "Status"}, 0);
        ordersTable = new JTable(tableModel);
        loadOrders();

        statusComboBox = new JComboBox<>(new String[]{"Pending", "Processed", "Completed"});
        updateStatusButton = new JButton("Update Status");

        updateStatusButton.addActionListener(e -> updateOrderStatus());

        add(new JScrollPane(ordersTable), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Set Status:"));
        controlPanel.add(statusComboBox);
        controlPanel.add(updateStatusButton);
        add(controlPanel, BorderLayout.SOUTH);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadOrders() {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Orders")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("OrderID"),
                        rs.getInt("UserID"),
                        rs.getInt("ItemID"),
                        rs.getString("Status")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateOrderStatus() {
        int selectedRow = ordersTable.getSelectedRow();
        if (selectedRow != -1) {
            int orderId = (int) tableModel.getValueAt(selectedRow, 0);
            String status = (String) statusComboBox.getSelectedItem();

            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("UPDATE Orders SET Status = ? WHERE OrderID = ?")) {
                stmt.setString(1, status);
                stmt.setInt(2, orderId);
                stmt.executeUpdate();

                tableModel.setValueAt(status, selectedRow, 3);
                JOptionPane.showMessageDialog(this, "Order status updated.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select an order to update.");
        }
    }
}
