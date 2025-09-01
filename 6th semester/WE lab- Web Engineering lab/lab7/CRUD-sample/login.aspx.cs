using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SqlConnections
{
    public partial class login : System.Web.UI.Page
    {
        protected void loginButton_Click(object sender, EventArgs e)

        {
            //string storing the username and passwords corresponding to them
            string username = usernameTextBox.Text;
            string password = passwordTextBox.Text;
            //in web.config
            //1. connection obect
            string connectionString = ConfigurationManager.ConnectionStrings["MyDatabaseConnection"].ConnectionString;

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                //command object (query, and connection string)
                string sql = "SELECT * FROM Users WHERE Username = @Username AND PasswordHash = @Password";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("@Username", username);
                    command.Parameters.AddWithValue("@Password", password); // Directly matching the password

                    try
                    { 
                        //DataReader:reads data from db in forward order alwaysused to read and display record
                        connection.Open();
                        using (SqlDataReader reader = command.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                // Login successful
                                // Redirect to a success page
                                FormsAuthentication.RedirectFromLoginPage(username, false);
                                Response.Redirect("update and delete.aspx");
                            }
                            else
                            {
                                // Incorrect username or password
                                messageLabel.Text = "Incorrect username or password.";
                                Response.Redirect("Error.aspx");
                            }
                        }
                    }
                    catch (Exception ex)
                    {
                        // Handle exceptions
                        messageLabel.Text = "Error: " + ex.Message;
                    }
                }
            }
        }
    }
}