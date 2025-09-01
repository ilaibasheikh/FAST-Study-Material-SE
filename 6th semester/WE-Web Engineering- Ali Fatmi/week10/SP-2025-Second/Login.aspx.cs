using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Configuration;

public partial class Login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Session["Username"] != null) // If already logged in, redirect
        {
            Response.Redirect(Session["Role"].ToString() == "Admin" ? "~/Pages/Admin/home.aspx" : "~/Pages/User/home.aspx");
        }
    }
    protected void btnLogin_Click(object sender, EventArgs e)
    {
        string username = txtUsername.Text.Trim();
        string password = txtPassword.Text.Trim();

        using (SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString))
        {
            string query = "SELECT UserID, Role,username FROM Users WHERE email=@email AND Passwordhash=@Passwordhash";
            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@email", username);
            cmd.Parameters.AddWithValue("@Passwordhash", password);
            
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            
            if (reader.Read()) // If user exists
            {
                Session["UserID"] = reader["UserID"].ToString();
                Session["Username"] = username;
                Session["Role"] = reader["Role"].ToString();

                // Redirect based on role
                Response.Redirect(Session["Role"].ToString() == "Admin" ? "~/Pages/Admin/home.aspx" : "~/Pages/User/home.aspx");
            }
            else
            {
                lblMessage.Text = "Invalid username or password!";
            }
        }
    }
}