package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USER = "system";
    private static final String PASSWORD = "fast";

    public static Connection getConnection() throws SQLException {
        try {
// Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Oracle JDBC Driver Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load Oracle JDBC Driver");
            e.printStackTrace();
        }
// Establish and return the connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
