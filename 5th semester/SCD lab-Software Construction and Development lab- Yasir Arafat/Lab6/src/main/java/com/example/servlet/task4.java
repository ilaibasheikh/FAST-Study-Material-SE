package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class task4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String number = request.getParameter("number");
        List<Integer> fibonacciSequence = generateFibonacci(Integer.parseInt(number));

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Fibonacci Sequence for number " + number + ":</h2>");
        out.println("<ul>");

        for (int num : fibonacciSequence) {
            out.println("<li>" + num + "</li>");
        }

        out.println("</ul>");
        out.println("<a href='task4.html'>Go back</a>");
        out.println("</body></html>");
    }

    private List<Integer> generateFibonacci(int number) {
        List<Integer> sequence = new ArrayList<>();
        if (number <= 0) {
            return sequence;
        }
        int n1 = 0;
        int n2 = 1;
        sequence.add(n1);
        if (number == 1) {
            return sequence;
        }
        sequence.add(n2);
        for (int i = 2; i < number; i++) {
            int next = n1 + n2;
            sequence.add(next);
            n1 = n2;
            n2 = next;
        }
        return sequence;
    }
}
