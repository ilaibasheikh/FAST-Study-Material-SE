using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace k225195_WE_A3
{
	public partial class Profile : System.Web.UI.Page
	{
        string connStr = ConfigurationManager.ConnectionStrings["dbcs"].ConnectionString;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["Username"] == null || Session["Role"].ToString() != "Employee")
            {
                Response.Redirect("~/Login.aspx");
                return;
            }

            if (!IsPostBack)
            {
                LoadProfile();
            }
        }
        private void LoadProfile()
        {
            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlCommand cmd = new SqlCommand("SELECT * FROM Employees WHERE Name = @Name", conn);
                cmd.Parameters.AddWithValue("@Name", Session["Username"].ToString());

                SqlDataAdapter da = new SqlDataAdapter(cmd);
                DataTable dt = new DataTable();
                da.Fill(dt);

                fvProfile.DataSource = dt;
                fvProfile.DataBind();
            }
        }

        protected void fvProfile_ItemUpdating(object sender, FormViewUpdateEventArgs e)
        {
            int empId = Convert.ToInt32(e.Keys["EmployeeID"]);
            string name = e.NewValues["Name"].ToString();
            string dept = e.NewValues["Department"].ToString();
            string desig = e.NewValues["Designation"].ToString();

            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlCommand cmd = new SqlCommand("UPDATE Employees SET Name=@Name, Department=@Dept, Designation=@Desig WHERE EmployeeID=@ID", conn);
                cmd.Parameters.AddWithValue("@Name", name);
                cmd.Parameters.AddWithValue("@Dept", dept);
                cmd.Parameters.AddWithValue("@Desig", desig);
                cmd.Parameters.AddWithValue("@ID", empId);

                conn.Open();
                cmd.ExecuteNonQuery();
            }

            lblMsg.Text = "Profile updated successfully!";
            LoadProfile();
        }
    }
}