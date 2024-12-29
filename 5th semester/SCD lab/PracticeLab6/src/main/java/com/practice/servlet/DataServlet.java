package com.practice.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String name = req.getParameter("name");
String email = req.getParameter("email");
String password = req.getParameter("password");

req.setAttribute("name", name);
req.setAttribute("email", email);
req.setAttribute("password", password);

RequestDispatcher rd = req.getRequestDispatcher("data.jsp");
rd.forward(req, resp);

    }
}
