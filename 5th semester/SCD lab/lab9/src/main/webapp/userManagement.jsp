<%@ page import="java.sql.ResultSet" %>
<html>
<head><title>User Management</title></head>
<body>
<h1>User Management</h1>
<table border="1">
  <tr><th>ID</th><th>Email</th><th>DOB</th><th>Actions</th></tr>
  <%
    ResultSet users = (ResultSet) request.getAttribute("users");
    while (users != null && users.next()) {
  %>
  <tr>
    <td><%= users.getInt("u_id") %></td>
    <td><%= users.getString("email") %></td>
    <td><%= users.getString("dob") %></td>
    <td><a href="editUser.jsp?id=<%= users.getInt("u_id") %>">Edit</a></td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
