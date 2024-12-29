import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertData {
    public void insertEmployee(int u_id, String u_name,String email,String password,String confirmPassword)  {


        String sql = "INSERT INTO users (id , name,email,password , confirm_password ) VALUES (? , ? , ? , ? , ? )";
        try (Connection connection = DatabaseUtil.getConnection();  PreparedStatement preparedStatement =
                connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, u_id);
            preparedStatement.setString(2, u_name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, confirmPassword);


            int rowsAffected = preparedStatement.executeUpdate();  System.out.println(rowsAffected + " row(s) inserted.");  } catch (SQLException e) {
            System.out.println("Connection or insert failed!");  e.printStackTrace();
        }
    }
}
