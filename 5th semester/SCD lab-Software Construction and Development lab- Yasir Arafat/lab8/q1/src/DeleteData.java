import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteData {
    public void deleteuser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");  } catch (SQLException e) {
            System.out.println("Connection or delete failed!");  e.printStackTrace();
        }
    }
}
