import com.example.utils.DatabaseConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
@WebServlet("/manageCategories")
public class ManageCategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            // Display categories management page
            RequestDispatcher dispatcher = request.getRequestDispatcher("manageCategories.jsp");
            dispatcher.forward(request, response);
        } else if (action.equals("add")) {
            // Handle category addition
            String categoryName = request.getParameter("categoryName");
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO Categories (CategoryName) VALUES (?)")) {
                stmt.setString(1, categoryName);
                stmt.executeUpdate();
                response.sendRedirect("manageCategories.jsp");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
