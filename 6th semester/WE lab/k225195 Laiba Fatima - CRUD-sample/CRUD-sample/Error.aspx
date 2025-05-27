<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Error.aspx.cs" Inherits="SqlConnections.Error" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login Error</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Login Failed</h1>
            <p>Incorrect username or password. Please try again.</p>
            <a href="login.aspx">Back to Login</a>
        </div>
    </form>
</body>
</html>