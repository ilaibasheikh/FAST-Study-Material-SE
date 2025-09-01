<%@ Page Title="" Language="C#" MasterPageFile="~/Dashboard.Master" AutoEventWireup="true" CodeBehind="EmployeeList.aspx.cs" Inherits="k225195_WE_A3.EmployeeList" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
     <h2>Employee List</h2>

 <asp:GridView ID="gvEmployees" runat="server" AutoGenerateColumns="False"
     DataKeyNames="EmployeeID"
     OnRowEditing="gvEmployees_RowEditing"
     OnRowCancelingEdit="gvEmployees_RowCancelingEdit"
     OnRowUpdating="gvEmployees_RowUpdating"
     OnRowDeleting="gvEmployees_RowDeleting">
     <Columns>
         <asp:BoundField DataField="Name" HeaderText="Name" />
         <asp:BoundField DataField="Email" HeaderText="Email" />
         <asp:BoundField DataField="Department" HeaderText="Department" />
         <asp:BoundField DataField="Designation" HeaderText="Designation" />
         <asp:BoundField DataField="Salary" HeaderText="Salary" />
         <asp:BoundField DataField="JoiningDate" HeaderText="Joining Date" DataFormatString="{0:yyyy-MM-dd}" />
         <asp:CommandField ShowEditButton="True" ShowDeleteButton="True" />
     </Columns>
 </asp:GridView>
 <hr />
 <h3>Add New Employee</h3>

 <table>
     <tr>
         <td>Name:</td>
         <td>
             <asp:TextBox ID="txtName" runat="server" /></td>
     </tr>
     <tr>
         <td>Email:</td>
         <td>
             <asp:TextBox ID="txtEmail" runat="server" /></td>
     </tr>
     <tr>
         <td>Department:</td>
         <td>
             <asp:TextBox ID="txtDept" runat="server" /></td>
     </tr>
     <tr>
         <td>Designation:</td>
         <td>
             <asp:TextBox ID="txtDesig" runat="server" /></td>
     </tr>
     <tr>
         <td>Salary:</td>
         <td>
             <asp:TextBox ID="txtSalary" runat="server" /></td>
     </tr>
     <tr>
         <td>Joining Date:</td>
         <td>
             <asp:TextBox ID="txtJoinDate" runat="server" Placeholder="yyyy-mm-dd" /></td>
     </tr>
     <tr>
         <td colspan="2">
             <asp:Button ID="btnAddEmployee" runat="server" Text="Add Employee" OnClick="btnAddEmployee_Click" />
         </td>
     </tr>
 </table>

 <asp:Label ID="lblMessage" runat="server" ForeColor="Green" />
</asp:Content>
