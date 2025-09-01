import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class superadmin extends JFrame {
    private JTable userTable;
    private JButton editButton;
    private JButton refreshButton;
    private DefaultTableModel tableModel;

    public superadmin() {
        setTitle("User Management");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel(new String[]{"ID", "Email", "Name", "DOB"}, 0);
        userTable = new JTable(tableModel);

        editButton = new JButton("Edit User");
        refreshButton = new JButton("Refresh");

        setLayout(new BorderLayout());
        add(new JScrollPane(userTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);
        buttonPanel.add(refreshButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadUsers();

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow != -1) {
                    int u_id = (int) tableModel.getValueAt(selectedRow, 0);
                    String newEmail = JOptionPane.showInputDialog("Enter new email:", tableModel.getValueAt(selectedRow, 1));
                    String newName = JOptionPane.showInputDialog("Enter new name:", tableModel.getValueAt(selectedRow, 2));
                    String newDob = JOptionPane.showInputDialog("Enter new DOB:", tableModel.getValueAt(selectedRow, 3));

                    if (newEmail != null && newName != null && newDob != null) {
                        updateUser(u_id, newEmail, newName, newDob);
                        loadUsers();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a user to edit.");
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUsers();
            }
        });

        setVisible(true);
    }

    private void loadUsers() {
        tableModel.setRowCount(0);
        String sql = "SELECT u_id, email, u_name, dob FROM adminusers";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("u_id");
                String email = resultSet.getString("email");
                String name = resultSet.getString("u_name");
                String dob = resultSet.getString("dob");
                tableModel.addRow(new Object[]{id, email, name, dob});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading users from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateUser(int u_id, String newEmail, String newName, String newDob) {
        String sql = "UPDATE adminusers SET email = ?, u_name = ?, dob = ? WHERE u_id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, newEmail);
            preparedStatement.setString(2, newName);
            preparedStatement.setString(3, newDob);
            preparedStatement.setInt(4, u_id);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(this, "User updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating user.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new superadmin();
    }
}
