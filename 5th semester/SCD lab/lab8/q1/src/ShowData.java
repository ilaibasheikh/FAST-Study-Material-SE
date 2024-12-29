import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowData {
    public void displayEmployees() {
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("ID\tName\tEmail");
            System.out.println("---------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + "\t" + name + "\t" + email);
            }
        } catch (SQLException e) {
            System.out.println("Connection or query failed!");
            e.printStackTrace();
        }
    }
}
