using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class SelectUsers : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            LoadUsers();
        }
    }

    private void LoadUsers()
    {
        User user = new User();
        gvUsers.DataSource = user.GetUsers();
        gvUsers.DataBind();
    }

    protected void gvUsers_RowCommand(object sender, GridViewCommandEventArgs e)
    {
        if (e.CommandName == "UpdateUser")
        {
            int userId = Convert.ToInt32(e.CommandArgument);
            Response.Redirect("UpdateUser.aspx?id=" + userId);
        }
        else if (e.CommandName == "DeleteUser")
        {
            User user = new User();
            int userId = Convert.ToInt32(e.CommandArgument);
            if (user.DeleteUser(userId))
            {
                LoadUsers(); // Refresh GridView
            }
        }
    }
}