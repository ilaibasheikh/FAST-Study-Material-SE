using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Signup : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void btnSignup_Click(object sender, EventArgs e)
    {
        string username = txtUsername.Text.Trim();
        string email = txtEmail.Text.Trim();
        string password = txtPassword.Text.Trim();

        User newUser = new User(username, email, password);
        bool isAdded = newUser.AddUser();

        if (isAdded)
        {
            lblMessage.Text = "Signup successful! Awaiting approval.";
            lblMessage.CssClass = "text-success";
        }
        else
        {
            lblMessage.Text = "Signup failed. Try again.";
        }
    }
}