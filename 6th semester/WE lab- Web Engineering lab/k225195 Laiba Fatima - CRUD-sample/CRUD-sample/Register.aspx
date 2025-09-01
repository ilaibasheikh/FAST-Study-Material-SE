<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="SqlConnections.Register" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

    <form id="form1" runat="server">
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card border p-4">
                        <h2 class="text-center mb-4">Register</h2>
                        <div class="form-group">
                            <label for="txtUsername">Username:</label>
                            <asp:TextBox ID="txtUsername" runat="server" CssClass="form-control" required></asp:TextBox>
                        </div>
                        <div class="form-group">
                            <label for="txtEmail">Email:</label>
                            <asp:TextBox ID="txtEmail" runat="server" TextMode="Email" CssClass="form-control" required></asp:TextBox>
                        </div>
                        <div class="form-group">
                            <label for="txtPassword">Password:</label>
                            <asp:TextBox ID="txtPassword" runat="server" TextMode="Password" CssClass="form-control" required></asp:TextBox>
                        </div>
                        <asp:Button ID="RegisterButton" runat="server" Text="Register" CssClass="btn btn-primary btn-block" OnClick="RegisterButton_Click" />
                    </div>
                </div>
            </div>
        </div>
      
    </form>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
