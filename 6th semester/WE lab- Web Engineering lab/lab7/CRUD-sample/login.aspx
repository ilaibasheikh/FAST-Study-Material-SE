<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="SqlConnections.login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form id="loginForm" runat="server">
                    <div class="form-group">
                        <label for="usernameTextBox">Username:</label>
                        <asp:TextBox ID="usernameTextBox" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>

                    <div class="form-group">
                        <label for="passwordTextBox">Password:</label>
                        <asp:TextBox ID="passwordTextBox" runat="server" TextMode="Password" CssClass="form-control"></asp:TextBox>
                    </div>

                    <asp:Button ID="loginButton" runat="server" Text="Login" CssClass="btn btn-primary" OnClick="loginButton_Click" />

                    <asp:Label ID="messageLabel" runat="server" CssClass="mt-3"></asp:Label>
                </form>
            </div>
        </div>
    </div>
</body>
</html>