package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");

        String sql = "UPDATE adminusers SET email = ?, u_name = ?, dob = ? WHERE u_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, dob);
            preparedStatement.setInt(4, Integer.parseInt(id));
            int rowsUpdated = preparedStatement.executeUpdate();
            
            if (rowsUpdated > 0) {
                response.sendRedirect("admin");  // Redirect to the admin page after update
            } else {
                response.sendRedirect("editUser.jsp?id=" + id + "&error=Update failed");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("editUser.jsp?id=" + id + "&error=Database error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
