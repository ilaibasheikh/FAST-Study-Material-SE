<%@ Page Title="" Language="C#" MasterPageFile="~/Dashboard.Master" AutoEventWireup="true" CodeBehind="Profile.aspx.cs" Inherits="k225195_WE_A3.Profile" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <h2>My Profile</h2>

    <asp:FormView ID="fvProfile" runat="server" DefaultMode="Edit"
        OnItemUpdating="fvProfile_ItemUpdating"
        DataKeyNames="EmployeeID">
        <EditItemTemplate>
            <table>
                <tr><td>Name:</td><td><asp:TextBox ID="txtName" runat="server" Text='<%# Bind("Name") %>' /></td></tr>
                <tr><td>Email:</td><td><asp:Label ID="lblEmail" runat="server" Text='<%# Bind("Email") %>' /></td></tr>
                <tr><td>Department:</td><td><asp:TextBox ID="txtDept" runat="server" Text='<%# Bind("Department") %>' /></td></tr>
                <tr><td>Designation:</td><td><asp:TextBox ID="txtDesig" runat="server" Text='<%# Bind("Designation") %>' /></td></tr>
                <tr><td>Salary:</td><td><asp:Label ID="lblSalary" runat="server" Text='<%# Bind("Salary", "{0:C}") %>' /></td></tr>
                <tr><td>Joining Date:</td><td><asp:Label ID="lblJoinDate" runat="server" Text='<%# Bind("JoiningDate", "{0:yyyy-MM-dd}") %>' /></td></tr>
                <tr><td colspan="2"><asp:Button ID="btnUpdate" runat="server" CommandName="Update" Text="Update" /></td></tr>
            </table>
        </EditItemTemplate>
    </asp:FormView>

    <asp:Label ID="lblMsg" runat="server" ForeColor="Green" />
</asp:Content>
