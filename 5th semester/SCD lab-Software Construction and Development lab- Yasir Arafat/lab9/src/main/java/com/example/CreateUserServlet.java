package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");

        if (id == null || id.isEmpty()) {
            response.sendRedirect("createUser.jsp?error=ID is required");
            return;
        }

        String sql = "INSERT INTO adminusers (u_id, email, u_name, password, dob) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, Integer.parseInt(id));  // This is safe now as we ensure ID is not null
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, dob);
            preparedStatement.executeUpdate();

            response.sendRedirect("admin");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("createUser.jsp?error=Database error");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("createUser.jsp?error=Invalid ID format");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
