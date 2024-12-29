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
@WebServlet("/manageItems")
public class ManageItemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        if (role == null || !role.equals("SuperAdmin")) {
            response.sendRedirect("home.jsp");
            return;
        }

        String action = request.getParameter("action");

        if (action == null) {
            // Display items management page
            RequestDispatcher dispatcher = request.getRequestDispatcher("manageItems.jsp");
            dispatcher.forward(request, response);
        } else if (action.equals("add")) {
            String itemName = request.getParameter("itemName");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO Items (ItemName, CategoryID, Price, Stock) VALUES (?, (SELECT CategoryID FROM Categories WHERE CategoryName = ?), ?, ?)")) {
                stmt.setString(1, itemName);
                stmt.setString(2, category);
                stmt.setDouble(3, price);
                stmt.setInt(4, stock);
                stmt.executeUpdate();
                response.sendRedirect("manageItems.jsp");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
