<%@ Page Title="" Language="C#" MasterPageFile="~/Dashboard.Master" AutoEventWireup="true" CodeBehind="Report.aspx.cs" Inherits="k225195_WE_A3.Report" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
         <h2>Admin Reports</h2>

     <asp:Panel ID="pnlReport" runat="server" Visible="false">
         <p><strong>Total Employees:</strong> <asp:Label ID="lblTotalEmployees" runat="server" /></p>
         <p><strong>Total Departments:</strong> <asp:Label ID="lblTotalDepartments" runat="server" /></p>

         <h3>Employees by Department</h3>
         <asp:GridView ID="gvByDepartment" runat="server" AutoGenerateColumns="true" />

         <h3>Average Salary per Department</h3>
         <asp:GridView ID="gvAvgSalary" runat="server" AutoGenerateColumns="true" />

         <h3>Recently Joined Employees</h3>
         <asp:GridView ID="gvRecentJoins" runat="server" AutoGenerateColumns="true" />
     </asp:Panel>

     <asp:Label ID="lblError" runat="server" ForeColor="Red" />
</asp:Content>
