package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        
        if (user == null || !user.endsWith("@admin.com")) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT u_id, email, dob FROM adminusers")) {
            
            request.setAttribute("users", resultSet);
            RequestDispatcher dispatcher = request.getRequestDispatcher("userManagement.jsp");
            dispatcher.forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=Database error");
        }
    }
}
