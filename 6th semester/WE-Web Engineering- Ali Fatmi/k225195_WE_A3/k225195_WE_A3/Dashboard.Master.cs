using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace k225195_WE_A3
{
	public partial class Dashboard : System.Web.UI.MasterPage
	{
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["Username"] == null || Session["Role"] == null)
            {
                Response.Redirect("Login.aspx");
                return;
            }



            string role = Session["Role"].ToString();
            WelcomeMessage.Text = $"Hello, {Session["Username"].ToString()}! You are logged in as {role}.";


            EmployeeLink.Visible = (role == "Admin" || role == "HR Manager");
            ReportLink.Visible = (role == "Admin");
            ProfileLink.Visible = (role == "Employee");

        }

        protected void LogoutButton_Click(object sender, EventArgs e)
        {
            Session.Clear();
            Session.Abandon();
            Response.Redirect("Login.aspx");
        }
    }
}