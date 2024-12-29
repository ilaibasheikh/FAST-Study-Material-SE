import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ManageCategory extends JFrame {

    public ManageCategory(String role) {
        setTitle("Manage Categories");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Add Category", createAddCategoryPanel());
        tabbedPane.add("Edit Category", createEditCategoryPanel());
        tabbedPane.add("Delete Category", createDeleteCategoryPanel());

        add(tabbedPane);
        setVisible(true);
    }

    private JPanel createAddCategoryPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Category Name:"));
        JTextField categoryNameField = new JTextField();
        panel.add(categoryNameField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String categoryName = categoryNameField.getText();
            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO Categories (CategoryName) VALUES (?)")) {
                stmt.setString(1, categoryName);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Category added successfully.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        panel.add(addButton);
        return panel;
    }

    private JPanel createEditCategoryPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Select Category:"));
        JComboBox<String> categoryDropdown = new JComboBox<>();
        populateCategoryDropdown(categoryDropdown);
        panel.add(categoryDropdown);

        panel.add(new JLabel("New Category Name:"));
        JTextField newCategoryNameField = new JTextField();
        panel.add(newCategoryNameField);

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(e -> {
            String selectedCategory = (String) categoryDropdown.getSelectedItem();
            String newCategoryName = newCategoryNameField.getText();
            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("UPDATE Categories SET CategoryName = ? WHERE CategoryName = ?")) {
                stmt.setString(1, newCategoryName);
                stmt.setString(2, selectedCategory);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Category updated successfully.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        panel.add(editButton);

        return panel;
    }

    private JPanel createDeleteCategoryPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Select Category:"));
        JComboBox<String> categoryDropdown = new JComboBox<>();
        populateCategoryDropdown(categoryDropdown);
        panel.add(categoryDropdown);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            String selectedCategory = (String) categoryDropdown.getSelectedItem();
            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM Categories WHERE CategoryName = ?")) {
                stmt.setString(1, selectedCategory);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Category deleted successfully.");
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
}
