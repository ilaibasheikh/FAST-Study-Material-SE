<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.DatabaseConnection" %>
<html>
<head><title>Edit User</title></head>
<body>
<h1>Edit User</h1>

<%
  // Get the user ID from the request
  String userId = request.getParameter("id");

  if (userId != null) {
    try {
      // Database connection
      Connection connection = DatabaseConnection.getConnection();
      String query = "SELECT * FROM adminusers WHERE u_id = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setInt(1, Integer.parseInt(userId));
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) {
        String email = resultSet.getString("email");
        String name = resultSet.getString("u_name");
        String dob = resultSet.getString("dob");
%>

<form action="UpdateUserServlet" method="post">
  <input type="hidden" name="id" value="<%= userId %>"><br>
  Email: <input type="email" name="email" value="<%= email %>" required><br>
  Name: <input type="text" name="name" value="<%= name %>" required><br>
  DOB: <input type="text" name="dob" value="<%= dob %>" required><br>
  <button type="submit">Update User</button>
</form>

<%
      } else {
        out.println("<p>User not found.</p>");
      }
    } catch (SQLException e) {
      e.printStackTrace();
      out.println("<p>Error retrieving user details.</p>");
    }
  } else {
    out.println("<p>User ID is missing.</p>");
  }
%>

</body>
</html>
