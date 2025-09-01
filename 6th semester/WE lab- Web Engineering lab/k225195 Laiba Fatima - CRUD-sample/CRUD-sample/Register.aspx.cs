using System;
using System.Configuration;
using System.Data.SqlClient;
using System.Web.UI;

namespace SqlConnections
{
    public partial class Register : Page
    {
        protected void RegisterButton_Click(object sender, EventArgs e)
        {
            // Get input values
            string username = txtUsername.Text.Trim();
            string email = txtEmail.Text.Trim();
            string password = txtPassword.Text.Trim(); // Direct password storage (not recommended)

            // Get the connection string from Web.config
            string connectionString = ConfigurationManager.ConnectionStrings["MyDatabaseConnection"].ConnectionString;

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();

                    // SQL query to insert data
                    string sql = "INSERT INTO Users (username, email, passwordHash) OUTPUT INSERTED.UserID VALUES (@username, @email, @password)";

                    using (SqlCommand command = new SqlCommand(sql, connection))
                    {
                        command.Parameters.AddWithValue("@username", username);
                        command.Parameters.AddWithValue("@email", email);
                        command.Parameters.AddWithValue("@password", password); // Storing plain text password (not secure)

                        object result = command.ExecuteScalar(); // Get inserted ID

                        if (result != null)
                        {
                            Response.Redirect("login.aspx");
                        }
                        else
                        {
                            Response.Write("Registration failed. Please try again.");
                        }
                    }
                }
                catch (Exception ex)
                {
                    Response.Write("An error occurred: " + ex.Message);
                }
            }
        }
    }
}
