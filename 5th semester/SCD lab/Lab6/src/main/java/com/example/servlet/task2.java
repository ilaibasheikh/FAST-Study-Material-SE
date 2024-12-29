package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class task2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        double temperature = Double.parseDouble(request.getParameter("temperature"));
        String type = request.getParameter("type");

        double convertedTemp = 0;
        String result = "";
        String message = "";

        switch (type) {
            case "CtoF":
                convertedTemp = (temperature * 9 / 5) + 32;
                result = String.format("%.2f Celsius is %.2f Fahrenheit", temperature, convertedTemp);
                break;
            case "FtoC":
                convertedTemp = (temperature - 32) * 5 / 9;
                result = String.format("%.2f Fahrenheit is %.2f Celsius", temperature, convertedTemp);
                break;
            default:
                message = "Error: Invalid operation.";
                break;
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Converted Temperature:</h2>");

        if (!message.isEmpty()) {
            out.println("<p>" + message + "</p>");
        } else {
            out.println("<p>" + result + "</p>");
        }

        out.println("<a href='task2.html'>Go back</a>");
        out.println("</body></html>");

    }
}
