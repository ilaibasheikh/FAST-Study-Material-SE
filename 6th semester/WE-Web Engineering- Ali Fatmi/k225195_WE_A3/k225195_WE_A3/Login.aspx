<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="k225195_WE_A3.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login</title>
    <style type="text/css">
        body {
            background-color: #f0f4f8;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 350px;
        }

        .header {
            background-color: #004080;
            color: white;
            text-align: center;
            padding: 20px;
            border-radius: 8px 8px 0 0;
            font-size: 20px;
            font-weight: bold;
            margin: -40px -40px 30px -40px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-label {
            display: block;
            margin-bottom: 6px;
            color: #333333;
        }

        .form-input {
            width: 100%;
            padding: 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        .form-button {
            width: 100%;
            padding: 10px;
            background-color:#004080;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
        }

        .form-button:hover {
            background-color: #0b5ed7;
        }

        .form-subtitle {
            text-align: center;
            margin-bottom: 20px;
            font-size: 16px;
            color: #555;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="login-container">
            <div class="header">WELCOME TO EMPLOYEE MANAGEMENT SYSTEM</div>
            <div class="form-subtitle">LOGIN</div>

            <div class="form-group">
                <label class="form-label">Username:</label>
                <asp:TextBox ID="UserTextBox" runat="server" CssClass="form-input"></asp:TextBox>
            </div>

            <div class="form-group">
                <label class="form-label">Password:</label>
                <asp:TextBox ID="PasswordTextBox" runat="server" TextMode="Password" CssClass="form-input"></asp:TextBox>
            </div>

            <asp:Button ID="LoginButton" runat="server" Text="Login" CssClass="form-button" OnClick="LoginButton_Click" />
        </div>
    </form>
</body>
</html>
