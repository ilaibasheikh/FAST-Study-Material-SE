<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="update and delete.aspx.cs" Inherits="SqlConnections.update_and_delete" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Update/Delete User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form id="updateDeleteForm" runat="server">
                    <div class="form-group">
                        <label for="usernameTextBox">Username:</label>
                        <asp:TextBox ID="usernameTextBox" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>

                    <div class="form-group">
                        <label for="passwordTextBox">Password:</label>
                        <asp:TextBox ID="passwordTextBox" runat="server" TextMode="Password" CssClass="form-control"></asp:TextBox>
                    </div>

                    <div class="form-group">
                        <label for="newPasswordTextBox">New Password (for Update only):</label>
                        <asp:TextBox ID="newPasswordTextBox" runat="server" TextMode="Password" CssClass="form-control"></asp:TextBox>
                    </div>

                    <asp:Button ID="deleteButton" runat="server" Text="Delete Account" CssClass="btn btn-danger" OnClick="deleteButton_Click" />
                    <asp:Button ID="updateButton" runat="server" Text="Update Password" CssClass="btn btn-primary" OnClick="updateButton_Click" />

                    <asp:Label ID="messageLabel" runat="server" CssClass="mt-3"></asp:Label>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
