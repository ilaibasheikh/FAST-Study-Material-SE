<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ajax_update_controls.aspx.cs" Inherits="SqlConnections.ajax_update_controls" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>AJAX Example</title>
</head>
<body>
    <form id="form1" runat="server">  
        <!--  ScriptManager must be inside the form -->
        <asp:ScriptManager ID="ScriptManager1" runat="server" /> 

        <div class="container">
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

            <!-- ✅ UpdatePanel should be separate from ScriptManager -->
            <asp:UpdatePanel runat="server">
                <ContentTemplate>
                    <asp:Label ID="messageLabel" runat="server" CssClass="mt-3"></asp:Label>
                    <br />
                    <asp:Button ID="Delete" runat="server" Text="Delete Account" CssClass="btn btn-danger"  />
                    <asp:Button ID="Update" runat="server" Text="Update" CssClass="btn btn-primary"  />
                </ContentTemplate>
            </asp:UpdatePanel>
        </div>
    </form>
</body>
</html>
