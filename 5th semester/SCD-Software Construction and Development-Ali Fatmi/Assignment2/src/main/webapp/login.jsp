<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>

<h2>Login</h2>

<form action="login" method="POST">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Login</button>
</form>

<%
    String errorMessage = (String) request.getAttribute("ErrorMessage");
    if (errorMessage != null) {
%>
<div style="color: red; margin-top: 10px;">
    <p><%= errorMessage %></p>
</div>
<%
    }
%>

</body>
</html>
