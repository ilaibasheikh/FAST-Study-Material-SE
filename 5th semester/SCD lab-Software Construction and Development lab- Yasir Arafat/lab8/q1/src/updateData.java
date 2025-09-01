import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class updateData {
    public void updateUser(int id, String newName, String mail)  {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id  = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, mail);
            preparedStatement.setInt(3, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        } catch (SQLException e) {
            System.out.println("Connection or update failed!");
            e.printStackTrace();
        }
    }
}
