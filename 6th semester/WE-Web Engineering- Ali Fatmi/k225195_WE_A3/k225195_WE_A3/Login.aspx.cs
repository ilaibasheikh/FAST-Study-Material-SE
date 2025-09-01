using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace k225195_WE_A3
{
	public partial class Login : System.Web.UI.Page
	{
        string cs = ConfigurationManager.ConnectionStrings["dbcs"].ConnectionString;
        protected void Page_Load(object sender, EventArgs e)
		{

		}

        protected void LoginButton_Click(object sender, EventArgs e)
        {
            string username = UserTextBox.Text;
            string password = PasswordTextBox.Text;

            SqlConnection con = new SqlConnection(cs);
            string query = "SELECT * FROM Users WHERE Username=@username AND Password=@password";
            SqlCommand cmd = new SqlCommand(query, con);
            cmd.Parameters.AddWithValue("@username", username);
            cmd.Parameters.AddWithValue("@password", password);
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            if (reader.Read())
            {
                Session["Username"] = username;
                Session["Role"] = reader["Role"].ToString();
                Session["UserId"] = reader["UserId"].ToString();

                Page.ClientScript.RegisterStartupScript(this.GetType(), "Scripts", "<script> alert('Login Successfull')</script>");

                Response.Redirect("Home.aspx");

            }
            else
            {
                Page.ClientScript.RegisterStartupScript(this.GetType(), "Scripts", "<script> alert('Login Failed')</script>");


            }
            con.Close();
        }

       
    }
}