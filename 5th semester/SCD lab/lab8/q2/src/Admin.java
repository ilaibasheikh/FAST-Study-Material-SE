import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Admin extends JFrame {
    private JTable userTable;
    private JButton editButton;
    private JButton refreshButton;
    private DefaultTableModel tableModel;

    public Admin() {
        setTitle("User Management");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "DOB"}, 0);
        userTable = new JTable(tableModel);

        editButton = new JButton("Edit User");
        refreshButton = new JButton("Refresh");

        setLayout(new BorderLayout());
        add(new JScrollPane(userTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);
        buttonPanel.add(refreshButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadUserss();

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow != -1) {
                    int u_id = (int) tableModel.getValueAt(selectedRow, 0);
                    String newName = JOptionPane.showInputDialog("Enter new name:", tableModel.getValueAt(selectedRow, 1));
                    String newDob = JOptionPane.showInputDialog("Enter new DOB:", tableModel.getValueAt(selectedRow, 2));

                    if (newName != null && newDob != null) {
                        updateUser(u_id, newName, newDob);
                        loadUserss();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a user to edit.");
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUserss();
            }
        });

        setVisible(true);
    }

    private void loadUserss() {
        tableModel.setRowCount(0);
        String sql = "SELECT u_id, email, dob FROM adminusers WHERE u_name NOT LIKE '%@admin.com' AND u_name != 'superadmin@gmail.com'";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("u_id");
                String name = resultSet.getString("email");
                String dob = resultSet.getString("dob");
                tableModel.addRow(new Object[]{id, name, dob});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading users from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateUser(int u_id, String newName, String newDob) {
        String sql = "UPDATE adminusers SET u_name = ?, dob = ? WHERE u_id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newDob);
            preparedStatement.setInt(3, u_id);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(this, "User updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating user.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
