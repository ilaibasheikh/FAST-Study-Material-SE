import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemCatalog extends JFrame {
    private JTable itemTable;
    private JButton orderButton;
    private DefaultTableModel tableModel;

    public ItemCatalog() {
        setTitle("Item Catalog");
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Item ID", "Name", "Category", "Price", "Stock"}, 0);
        itemTable = new JTable(tableModel);
        orderButton = new JButton("Place Order");

        loadItems();

        add(new JScrollPane(itemTable), BorderLayout.CENTER);
        add(orderButton, BorderLayout.SOUTH);

        orderButton.addActionListener(e -> placeOrder());

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadItems() {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orderitems")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("ItemID"),
                        rs.getString("ItemName"),
                        rs.getString("Category"),
                        rs.getDouble("Price"),
                        rs.getInt("Stock")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void placeOrder() {
        int selectedRow = itemTable.getSelectedRow();
        if (selectedRow != -1) {
            int itemId = (int) itemTable.getValueAt(selectedRow, 0);
            String userId = "1";
            createOrder(itemId, userId);
        } else {
            JOptionPane.showMessageDialog(this, "Select an item to order.");
        }
    }

    private void createOrder(int itemId, String userId) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Orders (OrderID, UserID, ItemID, OrderTimestamp, Status, PaymentMethod) VALUES (ORDER_SEQ.NEXTVAL, ?, ?, SYSTIMESTAMP, 'Pending', 'Cash on Delivery')")) {
            stmt.setString(1, userId);
            stmt.setInt(2, itemId);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Order placed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
