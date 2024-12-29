<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.utils.DatabaseConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Manage Categories</title>
</head>
<body>
<h2>Manage Categories</h2>
<form action="manageCategories?action=add" method="post">
  Category Name: <input type="text" name="categoryName" required /><br>
  <input type="submit" value="Add Category" />
</form>

<h3>Existing Categories:</h3>
<ul>
  <%
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT CategoryName FROM Categories")) {
      while (rs.next()) {
  %>
  <li><%= rs.getString("CategoryName") %></li>
  <%
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  %>
</ul>
</body>
</html>
