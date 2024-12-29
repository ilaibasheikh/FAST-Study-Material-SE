package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SuperAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the logged-in user is the super admin
        String user = (String) request.getSession().getAttribute("user");
        
        if (user == null || !user.equals("superadmin@gmail.com")) {
            response.sendRedirect("login.jsp?error=Not authorized");
            return;
        }

        // Here, you can handle the logic for the super admin page (e.g., show user management dashboard, reports, etc.)
        request.setAttribute("message", "Welcome, Super Admin!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("superAdminDashboard.jsp");
        dispatcher.forward(request, response);
    }

}
