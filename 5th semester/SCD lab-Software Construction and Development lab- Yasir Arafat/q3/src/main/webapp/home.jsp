<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home Page</title>
</head>
<body>
<%
  String username = (String) session.getAttribute("username");
  String role = (String) session.getAttribute("role");
%>

<h2>Welcome, <%= username %>!</h2>
<h3>Role: <%= role %></h3>

<%
  if ("SuperAdmin".equals(role)) {
%>
<a href="manageItems.jsp">Manage Items</a><br>
<%
  }
%>
<a href="manageCategories.jsp">Manage Categories</a><br>
</body>
</html>
