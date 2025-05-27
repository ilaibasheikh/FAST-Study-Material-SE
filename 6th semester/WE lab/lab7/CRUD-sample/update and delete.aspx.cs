using System;
using System.Configuration;
using System.Data.SqlClient;
using System.Web.UI;

namespace SqlConnections
{
    public partial class update_and_delete : System.Web.UI.Page
    {
        // DELETE FUNCTION
        protected void deleteButton_Click(object sender, EventArgs e)
        {
            string username = usernameTextBox.Text.Trim();
            string password = passwordTextBox.Text.Trim();

            string connectionString = ConfigurationManager.ConnectionStrings["MyDatabaseConnection"].ConnectionString;

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();

                    string chkUserQuery = "SELECT COUNT(*) FROM Users WHERE Username = @Username AND PasswordHash = @Password";
                    using (SqlCommand cmd = new SqlCommand(chkUserQuery, connection))
                    {
                        cmd.Parameters.AddWithValue("@Username", username);
                        cmd.Parameters.AddWithValue("@Password", password);

                        int userExists = Convert.ToInt32(cmd.ExecuteScalar());

                        if (userExists > 0)
                        {
                            string delQuery = "DELETE FROM Users WHERE Username = @Username AND PasswordHash = @Password";
                            using (SqlCommand delCmd = new SqlCommand(delQuery, connection))
                            {
                                delCmd.Parameters.AddWithValue("@Username", username);
                                delCmd.Parameters.AddWithValue("@Password", password);

                                int rowsChanged = delCmd.ExecuteNonQuery();

                                if (rowsChanged > 0)
                                {
                                    messageLabel.Text = "User deleted successfully!";
                                    
                                }
                                else
                                {
                                    messageLabel.Text = "Failed to delete user.";
                                }
                            }
                        }
                        else
                        {
                            messageLabel.Text = "User not found or incorrect password.";
                        }
                    }
                }
                catch (Exception ex)
                {
                    messageLabel.Text = "Error: " + ex.Message;
                }
            }
        }

        // UPDATE FUNCTION
        protected void updateButton_Click(object sender, EventArgs e)
        {
            string username = usernameTextBox.Text.Trim();
            string password = passwordTextBox.Text.Trim();
            string newPassword = newPasswordTextBox.Text.Trim();

            if (string.IsNullOrEmpty(newPassword))
            {
                messageLabel.Text = "New password cannot be empty.";
                return;
            }

            string connectionString = ConfigurationManager.ConnectionStrings["MyDatabaseConnection"].ConnectionString;

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();

                    string chkUserQuery = "SELECT COUNT(*) FROM Users WHERE Username = @Username AND PasswordHash = @Password";
                    using (SqlCommand cmd = new SqlCommand(chkUserQuery, connection))
                    {
                        cmd.Parameters.AddWithValue("@Username", username);
                        cmd.Parameters.AddWithValue("@Password", password);

                        int userExists = Convert.ToInt32(cmd.ExecuteScalar());

                        if (userExists > 0)
                        {
                            string updateQuery = "UPDATE Users SET PasswordHash = @NewPassword WHERE Username = @Username";
                            using (SqlCommand updateCmd = new SqlCommand(updateQuery, connection))
                            {
                                updateCmd.Parameters.AddWithValue("@Username", username);
                                updateCmd.Parameters.AddWithValue("@NewPassword", newPassword);

                                int rowsUpdated = updateCmd.ExecuteNonQuery();

                                if (rowsUpdated > 0)
                                {
                                    messageLabel.Text = "Password updated successfully!";
                                    Response.Redirect("update and delete.aspx", false);
                                }
                                else
                                {
                                    messageLabel.Text = "Failed to update password.";
                                }
                            }
                        }
                        else
                        {
                            messageLabel.Text = "User not found or incorrect password.";
                        }
                    }
                }
                catch (Exception ex)
                {
                    messageLabel.Text = "Error: " + ex.Message;
                }
            }
        }
    }
}
