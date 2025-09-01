using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Configuration;
using System.Data;

public partial class _Default : System.Web.UI.Page
{
    string connStr = ConfigurationManager.ConnectionStrings["MyDbConnection"].ConnectionString;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            LoadCategories();
        }
    }

    // Load Categories into DropDownList
    private void LoadCategories()
    {
        using (SqlConnection conn = new SqlConnection(connStr))
        {
            string query = "SELECT CategoryID, CategoryName FROM Category";
            SqlDataAdapter da = new SqlDataAdapter(query, conn);
            DataTable dt = new DataTable();
            da.Fill(dt);

            ddlCategory.DataSource = dt;
            ddlCategory.DataTextField = "CategoryName";
            ddlCategory.DataValueField = "CategoryID";
            ddlCategory.DataBind();

            ddlCategory.Items.Insert(0, new ListItem("-- Select Category --", "0"));
        }
    }

    // Load Models based on selected Category
    protected void ddlCategory_SelectedIndexChanged(object sender, EventArgs e)
    {
        int categoryId = Convert.ToInt32(ddlCategory.SelectedValue);
        if (categoryId > 0)
        {
            using (SqlConnection conn = new SqlConnection(connStr))
            {
                string query = "SELECT ModelID, ModelName FROM Model WHERE CategoryID = @CategoryID";
                SqlDataAdapter da = new SqlDataAdapter(query, conn);
                da.SelectCommand.Parameters.AddWithValue("@CategoryID", categoryId);
                DataTable dt = new DataTable();
                da.Fill(dt);

                ddlModel.DataSource = dt;
                ddlModel.DataTextField = "ModelName";
                ddlModel.DataValueField = "ModelID";
                ddlModel.DataBind();

                ddlModel.Items.Insert(0, new ListItem("-- Select Model --", "0"));
            }
        }
        else
        {
            ddlModel.Items.Clear();
        }

        // Clear product details
        lblProductName.Text = "";
        lblProductCode.Text = "";
        lblProductPrice.Text = "";
    }

    // Load Product Details based on selected Model
    protected void ddlModel_SelectedIndexChanged(object sender, EventArgs e)
    {
        int modelId = Convert.ToInt32(ddlModel.SelectedValue);
        if (modelId > 0)
        {
            using (SqlConnection conn = new SqlConnection(connStr))
            {
                string query = "SELECT ProductName, ProductCode, Price FROM Product WHERE ModelID = @ModelID";
                SqlCommand cmd = new SqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@ModelID", modelId);
                conn.Open();
                SqlDataReader reader = cmd.ExecuteReader();

                if (reader.Read())
                {
                    lblProductName.Text = reader["ProductName"].ToString();
                    lblProductCode.Text = reader["ProductCode"].ToString();
                    lblProductPrice.Text = "$" + Convert.ToDecimal(reader["Price"]).ToString("0.00");
                }
                else
                {
                    lblProductName.Text = "No product found.";
                    lblProductCode.Text = "";
                    lblProductPrice.Text = "";
                }
            }
        }
    }
}