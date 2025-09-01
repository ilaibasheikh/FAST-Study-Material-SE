<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Product Selection</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <form id="form1" runat="server">
        <asp:ScriptManager runat="server" />

        <div class="container mt-5">
            <div class="card shadow p-4">
                <h2 class="mb-4 text-center">Select Product</h2>

                <asp:UpdatePanel runat="server">
                    <ContentTemplate>
                        <!-- Category Selection -->
                        <div class="mb-3">
                            <label class="form-label">Category:</label>
                            <asp:DropDownList ID="ddlCategory" CssClass="form-select" runat="server" AutoPostBack="true" 
                                OnSelectedIndexChanged="ddlCategory_SelectedIndexChanged">
                            </asp:DropDownList>
                        </div>

                        <!-- Model Selection -->
                        <div class="mb-3">
                            <label class="form-label">Model:</label>
                            <asp:DropDownList ID="ddlModel" CssClass="form-select" runat="server" AutoPostBack="true" 
                                OnSelectedIndexChanged="ddlModel_SelectedIndexChanged">
                            </asp:DropDownList>
                        </div>

                        <!-- Product Details -->
                        <div class="mb-3">
                            <label class="form-label">Product Name:</label>
                     <asp:Label ID="lblProductName" CssClass="form-control" runat="server" ></asp:Label>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Product Code:</label>
                        <asp:Label ID="lblProductCode" CssClass="form-control" runat="server" ></asp:Label>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Price:</label>
                          <asp:Label ID="lblProductPrice" CssClass="form-control" runat="server"></asp:Label>
                        </div>
                    </ContentTemplate>
                </asp:UpdatePanel>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </form>
</body>
</html>