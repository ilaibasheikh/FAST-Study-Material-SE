package scd.assignment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            request.setAttribute("ErrorMessage", "Username or Password cannot be empty");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            return;
        }
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        try (Connection connection = Database.getConnection()) {
            if (connection != null) {
                System.out.println("Database connected successfully");
            }

            String query = "SELECT u.role_id, r.role_name FROM users u " +
                    "JOIN roles r ON u.role_id = r.role_id " +
                    "WHERE u.user_name = ? AND u.password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int roleId = resultSet.getInt("role_id");
                    String roleName = resultSet.getString("role_name");

                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", username);
                    session.setAttribute("role_id", roleId);
                    session.setAttribute("role_name", roleName);

                    System.out.println("User logged in with role ID: " + roleId + " and role name: " + roleName);
                    response.sendRedirect("dashboard");
                } else {
                    request.setAttribute("ErrorMessage", "Invalid username or password");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("ErrorMessage", "Internal error occurred. Please try again later.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}
