using System;
using System.Web.UI;

public partial class UpdateUser : Page
{
    private int userId;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            if (Request.QueryString["id"] != null && int.TryParse(Request.QueryString["id"], out userId))
            {
                LoadUserDetails(userId);
            }
            else
            {
                lblMessage.Text = "Invalid User ID.";
            }
        }
    }

    private void LoadUserDetails(int id)
    {
        User user = new User(id);
        if (user.Id > 0)
        {
            txtUsername.Text = user.Username;
            txtEmail.Text = user.Email;
            txtPassword.Attributes["value"] = user.Password; // To preserve password
            ddlStatus.SelectedValue = user.Status;
        }
        else
        {
            lblMessage.Text = "User not found.";
        }
    }

    protected void btnUpdate_Click(object sender, EventArgs e)
    {
        if (int.TryParse(Request.QueryString["id"], out userId))
        {
            User user = new User(userId)
            {
                Username = txtUsername.Text,
                Email = txtEmail.Text,
                Password = txtPassword.Text,
                Status = ddlStatus.SelectedValue
            };

            if (user.UpdateUser())
            {
                lblMessage.Text = "User updated successfully!";
                lblMessage.CssClass = "text-success";
            }
            else
            {
                lblMessage.Text = "Error updating user.";
            }
        }
        else
        {
            lblMessage.Text = "Invalid user ID.";
        }
    }
}
