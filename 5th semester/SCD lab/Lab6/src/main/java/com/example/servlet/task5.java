package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class task5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String input = request.getParameter("input");
        int[] frequency = new int[256];

        if (input != null) {
            for (char c : input.toCharArray()) {
                frequency[c]++;
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Character Frequency</h2>");
        out.println("<p>Input String: " + input + "</p>");
        out.println("<table border='1'><tr><th>Character</th><th>Frequency</th></tr>");

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                out.println("<tr><td>" + (char) i + "</td><td>" + frequency[i] + "</td></tr>");
            }
        }

        out.println("</table>");
        out.println("<a href='task5.html'>Go back</a>");
        out.println("</body></html>");
    }
}
