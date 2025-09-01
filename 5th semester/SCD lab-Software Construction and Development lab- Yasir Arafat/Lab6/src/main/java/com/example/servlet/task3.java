package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class task3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String word = (String) request.getParameter("word");

        boolean isPalindrome = isPalindrome(word);

        String message="";

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Your Answer:</h2>");

        if(isPalindrome){
            message =  (word + " is a palindrome.");
        }else{
            message=(word + "is not a palindrome.");
        }
        out.println("<p>" + message + "</p>");
        out.println("<a href='task3.html'>Go back</a>");
        out.println("</body></html>");


    }
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();

        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
