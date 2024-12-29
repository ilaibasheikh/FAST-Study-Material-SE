import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPanel extends JFrame {
    private JTextField orderIdField;
    private JTable orderHistoryTable;
    private JButton trackOrderButton;
    private JButton updateProfileButton;
    private JTextField newPasswordField;
    private DefaultTableModel tableModel;
    private int userId;

    public UserPanel(int userId) {
        this.userId = userId;

        setTitle("User Panel");
        setLayout(new BorderLayout());

        JPanel trackOrderPanel = new JPanel();
        orderIdField = new JTextField(10);
        trackOrderButton = new JButton("Track Order");

        trackOrderButton.addActionListener(e -> trackOrder());

        trackOrderPanel.add(new JLabel("Order ID:"));
        trackOrderPanel.add(orderIdField);
        trackOrderPanel.add(trackOrderButton);

        tableModel = new DefaultTableModel(new String[]{"Order ID", "Item ID", "Status", "Order Date"}, 0);
        orderHistoryTable = new JTable(tableModel);

        loadOrderHistory();

        JPanel profilePanel = new JPanel();
        newPasswordField = new JTextField(10);
        updateProfileButton = new JButton("Update Password");

        updateProfileButton.addActionListener(e -> updateProfile());

        profilePanel.add(new JLabel("New Password:"));
        profilePanel.add(newPasswordField);
        profilePanel.add(updateProfileButton);

        add(trackOrderPanel, BorderLayout.NORTH);
        add(new JScrollPane(orderHistoryTable), BorderLayout.CENTER);
        add(profilePanel, BorderLayout.SOUTH);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadOrderHistory() {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Orders WHERE UserID = ?")) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("OrderID"),
                        rs.getInt("ItemID"),
                        rs.getString("Status"),
                        rs.getTimestamp("OrderTimestamp")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void trackOrder() {
        String orderId = orderIdField.getText();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Orders WHERE OrderID = ? AND UserID = ?")) {
            stmt.setInt(1, Integer.parseInt(orderId));
            stmt.setInt(2, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String status = rs.getString("Status");
                JOptionPane.showMessageDialog(this, "Order Status: " + status);
            } else {
                JOptionPane.showMessageDialog(this, "Order not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateProfile() {
        String newPassword = newPasswordField.getText();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE Users SET Password = ? WHERE UserID = ?")) {
            stmt.setString(1, newPassword);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Password updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
