<%@ Page Language="C#" AutoEventWireup="true" CodeFile="SelectUsers.aspx.cs" Inherits="SelectUsers" %>

<!DOCTYPE html>
<html lang="en">
<head runat="server">
    <title>Manage Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <form id="form1" runat="server">
        <div class="container mt-5">
            <h2 class="text-center">User Management</h2>
            <asp:GridView ID="gvUsers" runat="server" AutoGenerateColumns="False" CssClass="table table-bordered"
                OnRowCommand="gvUsers_RowCommand" DataKeyNames="userid">
                <Columns>
                    <asp:BoundField DataField="userid" HeaderText="ID" ReadOnly="True"/>
                    <asp:BoundField DataField="Username" HeaderText="Username"/>
                    <asp:BoundField DataField="Email" HeaderText="Email"/>
                    <asp:BoundField DataField="Status" HeaderText="Status"/>

                    <asp:TemplateField HeaderText="Actions">
                        <ItemTemplate>
                            <asp:LinkButton ID="btnUpdate" runat="server" CssClass="btn btn-primary btn-sm"
                                CommandName="UpdateUser" CommandArgument='<%# Eval("userId") %>'>Update</asp:LinkButton>
                            
                            <asp:LinkButton ID="btnDelete" runat="server" CssClass="btn btn-danger btn-sm ms-2"
                                CommandName="DeleteUser" CommandArgument='<%# Eval("userId") %>'
                                OnClientClick="return confirm('Are you sure you want to delete this user?');">Delete</asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </form>
</body>
</html>