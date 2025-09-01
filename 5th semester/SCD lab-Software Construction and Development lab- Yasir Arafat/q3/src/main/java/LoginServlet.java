import com.example.utils.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =request.getParameter("username");
        String password = request.getParameter("password");


        System.out.println("Username: " + username);  // Debugging: print username
        System.out.println("Password: " + password);  // Debugging: print password

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT Role FROM resusers WHERE Username = ? AND Password = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("Role");
                System.out.println("Role: " + role);  // Debugging: print role
                HttpSession session = request.getSession();
                System.out.println("Executing query: SELECT Role FROM resusers WHERE Username = '" + username + "' AND Password = '" + password + "'");

                session.setAttribute("username", username);
                session.setAttribute("role", role);
                response.sendRedirect("home.jsp");
            } else {
                System.out.println("Invalid credentials");  // Debugging: print when credentials are invalid
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
