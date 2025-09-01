import javax.swing.*;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {
    private String role;

    public HomePage(String role) {
        this.role = role;
        setTitle("Home Page");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton manageCategoriesButton = new JButton("Manage Categories");
        manageCategoriesButton.addActionListener(this::openCategories);
        panel.add(manageCategoriesButton);

        JButton manageItemsButton = new JButton("Manage Items");
        manageItemsButton.addActionListener(this::openItems);
        panel.add(manageItemsButton);

        add(panel);
        setVisible(true);
    }

    private void openCategories(ActionEvent e) {
        new ManageCategory(role);
    }

    private void openItems(ActionEvent e) {
        if ("SuperAdmin".equals(role)) {
            new ManageItem(role);
        } else {
            JOptionPane.showMessageDialog(this, "Access Denied: Only SuperAdmins can manage items.");
        }
    }
}
