using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class admin : System.Web.UI.MasterPage
{
    protected void Page_Load(object sender, EventArgs e)
    {
        
        if (Session["Username"] == null && Session["Role"] !="Admin")
        {
            // Redirect to login page if session is not set
            Response.Redirect("~/Login.aspx");
        }
        else
        {
            // Display the username in the top-right corner
            //   lblUsername.Text = "Welcome, " + Session["Username"].ToString() + "!";
        }
    }
    protected void btnLogout_Click(object sender, EventArgs e)
    {
        Session.Clear();  // Remove all session variables
        Session.Abandon(); // Destroy the session
        Response.Redirect("~/Login.aspx"); // Redirect to login page
    }
}
