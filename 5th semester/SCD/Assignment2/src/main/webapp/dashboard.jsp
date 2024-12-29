<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
</head>
<body>

<h2>Welcome, <%= request.getAttribute("roleName") %></h2>

<h3>Menu:</h3>
<ul>
  <%
    ArrayList<String> menuItems = (ArrayList<String>) request.getAttribute("menuItems");
    for (String menuItem : menuItems) {
  %>
  <li><%= menuItem %></li>
  <%
    }
  %>
</ul>

<form action="logout" method="POST">
  <button type="submit">Logout</button>
</form>

</body>
</html>
