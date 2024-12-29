import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil{
    private static final String url = "jdbc:mysql://localhost:3306/scdlab8";
    private static final String user = "rootLaiba";
    private static final String password = "laiba5195";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(url, user, password);
    }
}
