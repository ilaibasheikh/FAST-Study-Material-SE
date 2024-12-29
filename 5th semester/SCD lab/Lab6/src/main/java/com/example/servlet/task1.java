package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class task1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setContentType("text/html");

            double number1 = Double.parseDouble(request.getParameter("num1"));
            double number2 = Double.parseDouble(request.getParameter("num2"));
            String operation = request.getParameter("operation");

            double result = 0;
            String message = "";

            switch (operation) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        message = "Error: Division by zero is not allowed.";
                    }
                    break;
                default:
                    message = "Error: Invalid operation.";
                    break;
            }

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Result:</h2>");
            if (!message.isEmpty()) {
                out.println("<p>" + message + "</p>");
            } else {
                out.println("<p>The result of " + number1 + " " + operation + " " + number2 + " is: " + result + "</p>");

            }
            out.println("<a href='task1.html'>Go back</a>");
            out.println("</body></html>");
    }
}
