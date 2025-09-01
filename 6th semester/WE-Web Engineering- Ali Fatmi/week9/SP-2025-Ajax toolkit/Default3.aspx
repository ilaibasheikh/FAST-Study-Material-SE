<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default3.aspx.cs" Inherits="Default3" %>


<!DOCTYPE html>
<html>
<head>
    <title>Category, Model & Product Selection</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="container mt-4">
        <h2>Select Category, Model & Product</h2>
        
        <div class="mb-3">
            <label class="form-label">Category</label>
            <select id="ddlCategory" class="form-select">
                <option value="0">-- Select Category --</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Model</label>
            <select id="ddlModel" class="form-select">
                <option value="0">-- Select Model --</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Product Name</label>
            <input type="text" id="txtProductName" class="form-control" readonly>
        </div>

        <div class="mb-3">
            <label class="form-label">Product Code</label>
            <input type="text" id="txtProductCode" class="form-control" readonly>
        </div>

        <div class="mb-3">
            <label class="form-label">Price ($)</label>
            <input type="text" id="txtPrice" class="form-control" readonly>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            loadCategories();

            $("#ddlCategory").change(function () {
                var categoryId = $(this).val();
                loadModels(categoryId);
                resetProductFields();
            });

            $("#ddlModel").change(function () {
                var modelId = $(this).val();
                loadProductDetails(modelId);
            });
        });

        function loadCategories() {
            $.ajax({
                type: "POST",
                url: "Default3.aspx/GetCategories",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (response) {
                    var categories = response.d;
                    $("#ddlCategory").empty().append('<option value="0">-- Select Category --</option>');
                    $.each(categories, function (i, category) {
                        $("#ddlCategory").append('<option value="' + category.CategoryID + '">' + category.CategoryName + '</option>');
                    });
                }
            });
        }

        function loadModels(categoryId) {
            if (categoryId == "0") {
                $("#ddlModel").html('<option value="0">-- Select Model --</option>');
                return;
            }
            $.ajax({
                type: "POST",
                url: "Default3.aspx/GetModels",
                data: JSON.stringify({ categoryId: categoryId }),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (response) {
                    var models = response.d;
                    $("#ddlModel").empty().append('<option value="0">-- Select Model --</option>');
                    $.each(models, function (i, model) {
                        $("#ddlModel").append('<option value="' + model.ModelID + '">' + model.ModelName + '</option>');
                    });
                }
            });
        }

        function loadProductDetails(modelId) {
            if (modelId == "0") {
                resetProductFields();
                return;
            }
            $.ajax({
                type: "POST",
                url: "Default3.aspx/GetProductDetails",
                data: JSON.stringify({ modelId: modelId }),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (response) {
                    var product = response.d;
                    if (product) {
                        $("#txtProductName").val(product.ProductName);
                        $("#txtProductCode").val(product.ProductCode);
                        $("#txtPrice").val(product.Price);
                    }
                }
            });
        }

        function resetProductFields() {
            $("#txtProductName, #txtProductCode, #txtPrice").val('');
        }
    </script>
</body>
</html>