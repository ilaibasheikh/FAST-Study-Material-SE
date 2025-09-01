using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Web.Services;


public partial class Default3 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e) { }

    [WebMethod]
    public static List<Category> GetCategories()
    {
        List<Category> categories = new List<Category>();
        string connStr = ConfigurationManager.ConnectionStrings["MyDbConnection"].ConnectionString;

        using (SqlConnection conn = new SqlConnection(connStr))
        {
            SqlCommand cmd = new SqlCommand("SELECT CategoryID, CategoryName FROM Category", conn);
            conn.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                categories.Add(new Category
                {
                    CategoryID = Convert.ToInt32(reader["CategoryID"]),
                    CategoryName = reader["CategoryName"].ToString()
                });
            }
        }
        return categories;
    }

    [WebMethod]
    public static List<Model> GetModels(int categoryId)
    {
        List<Model> models = new List<Model>();
        string connStr = ConfigurationManager.ConnectionStrings["MyDbConnection"].ConnectionString;

        using (SqlConnection conn = new SqlConnection(connStr))
        {
            SqlCommand cmd = new SqlCommand("SELECT ModelID, ModelName FROM Model WHERE CategoryID = @CategoryID", conn);
            cmd.Parameters.AddWithValue("@CategoryID", categoryId);
            conn.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                models.Add(new Model
                {
                    ModelID = Convert.ToInt32(reader["ModelID"]),
                    ModelName = reader["ModelName"].ToString()
                });
            }
        }
        return models;
    }
    [WebMethod]
    public static Product GetProductDetails(int modelId)
    {
        Product product = null;
        string connStr = ConfigurationManager.ConnectionStrings["MyDbConnection"].ConnectionString;

        using (SqlConnection conn = new SqlConnection(connStr))
        {
            SqlCommand cmd = new SqlCommand("SELECT TOP 1 ProductName, ProductCode, Price FROM Product WHERE ModelID = @ModelID", conn);
            cmd.Parameters.AddWithValue("@ModelID", modelId);
            conn.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            if (reader.Read())
            {
                product = new Product
                {
                    ProductName = reader["ProductName"].ToString(),
                    ProductCode = reader["ProductCode"].ToString(),
                    Price = Convert.ToDecimal(reader["Price"])
                };
            }
        }
        return product;
    }
}
public class Product { public string ProductName; public string ProductCode; public decimal Price; }
public class Category
{
    public int CategoryID { get; set; }
    public string CategoryName { get; set; }
}

public class Model
{
    public int ModelID { get; set; }
    public string ModelName { get; set; }
}