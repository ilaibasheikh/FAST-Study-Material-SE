import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ManageItem extends JFrame {

    public ManageItem(String role) {
        setTitle("Manage Items");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Add Item", createAddItemPanel());
        tabbedPane.add("Edit Item", createEditItemPanel());
        tabbedPane.add("Delete Item", createDeleteItemPanel());

        add(tabbedPane);
        setVisible(true);
    }

    private JPanel createAddItemPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Item Name:"));
        JTextField itemNameField = new JTextField();
        panel.add(itemNameField);

        panel.add(new JLabel("Category:"));
        JComboBox<String> categoryDropdown = new JComboBox<>();
        populateCategoryDropdown(categoryDropdown);
        panel.add(categoryDropdown);

        panel.add(new JLabel("Price:"));
        JTextField priceField = new JTextField();
        panel.add(priceField);

        panel.add(new JLabel("Stock:"));
        JTextField stockField = new JTextField();
        panel.add(stockField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String itemName = itemNameField.getText();
            String category = (String) categoryDropdown.getSelectedItem();
            double price = Double.parseDouble(priceField.getText());
            int stock = Integer.parseInt(stockField.getText());

            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO Items (ItemName, CategoryID, Price, Stock) VALUES (?, (SELECT CategoryID FROM Categories WHERE CategoryName = ?), ?, ?)")) {
                stmt.setString(1, itemName);
                stmt.setString(2, category);
                stmt.setDouble(3, price);
                stmt.setInt(4, stock);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Item added successfully.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        panel.add(addButton);
        return panel;
    }

    private JPanel createEditItemPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Select Item:"));
        JComboBox<String> itemDropdown = new JComboBox<>();
        populateItemDropdown(itemDropdown);
        panel.add(itemDropdown);

        panel.add(new JLabel("New Item Name:"));
        JTextField newItemNameField = new JTextField();
        panel.add(newItemNameField);

        panel.add(new JLabel("New Price:"));
        JTextField newPriceField = new JTextField();
        panel.add(newPriceField);

        panel.add(new JLabel("New Stock:"));
        JTextField newStockField = new JTextField();
        panel.add(newStockField);

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(e -> {
            String selectedItem = (String) itemDropdown.getSelectedItem();
            String newItemName = newItemNameField.getText();
            double newPrice = Double.parseDouble(newPriceField.getText());
            int newStock = Integer.parseInt(newStockField.getText());

            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                         "UPDATE Items SET ItemName = ?, Price = ?, Stock = ? WHERE ItemName = ?")) {
                stmt.setString(1, newItemName);
                stmt.setDouble(2, newPrice);
                stmt.setInt(3, newStock);
                stmt.setString(4, selectedItem);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Item updated successfully.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        panel.add(editButton);

        return panel;
    }

    private JPanel createDeleteItemPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Select Item:"));
        JComboBox<String> itemDropdown = new JComboBox<>();
        populateItemDropdown(itemDropdown);
        panel.add(itemDropdown);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            String selectedItem = (String) itemDropdown.getSelectedItem();
            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM Items WHERE ItemName = ?")) {
                stmt.setString(1, selectedItem);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Item deleted successfully.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        panel.add(deleteButton);

        return panel;
    }

    private void populateCategoryDropdown(JComboBox<String> dropdown) {
        dropdown.removeAllItems();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT CategoryName FROM Categories")) {
            while (rs.next()) {
                dropdown.addItem(rs.getString("CategoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateItemDropdown(JComboBox<String> dropdown) {
        dropdown.removeAllItems();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ItemName FROM Items")) {
            while (rs.next()) {
                dropdown.addItem(rs.getString("ItemName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
