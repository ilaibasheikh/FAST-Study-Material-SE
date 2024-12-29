<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.utils.DatabaseConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Manage Items</title>
</head>
<body>
<h2>Manage Items</h2>
<form action="manageItems?action=add" method="post">
  Item Name: <input type="text" name="itemName" required /><br>
  Category: <input type="text" name="category" required /><br>
  Price: <input type="text" name="price" required /><br>
  Stock: <input type="text" name="stock" required /><br>
  <input type="submit" value="Add Item" />
</form>

<h3>Existing Items:</h3>
<ul>
  <%
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT ItemName FROM Items")) {
      while (rs.next()) {
  %>
  <li><%= rs.getString("ItemName") %></li>
  <%
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  %>
</ul>
</body>
</html>
