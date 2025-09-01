<%@ Page Title="" Language="C#" MasterPageFile="~/Dashboard.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="k225195_WE_A3.Home" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <h2>Dashboard</h2>

<asp:Panel ID="pnlEmployeeProfile" runat="server" Visible="false">
    <h3>My Profile</h3>
    <asp:DetailsView ID="dvProfile" runat="server" AutoGenerateRows="true" />
</asp:Panel>

<asp:Panel ID="pnlAdminStats" runat="server" Visible="false">
    <h3>System Overview</h3>
    <p>Total Employees:
        <asp:Label ID="lblTotalEmployees" runat="server" /></p>
    <p>Total Departments:
        <asp:Label ID="lblTotalDepartments" runat="server" /></p>
</asp:Panel>

<asp:Panel ID="pnlAnnouncements" runat="server">
    <h3>Company Announcements</h3>
    <ul>
        <li>
            Meeting at 4 pm
        </li>
        <li>
   Project due by thursday
</li>
    </ul>
</asp:Panel>
</asp:Content>
