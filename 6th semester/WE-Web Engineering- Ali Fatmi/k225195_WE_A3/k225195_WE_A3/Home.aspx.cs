using System;
using System.Configuration;
using System.Data.SqlClient;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

namespace k225195_WE_A3
{
    public partial class Home : Page
    {
        string connStr = ConfigurationManager.ConnectionStrings["dbcs"].ConnectionString;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["Username"] == null) Response.Redirect("Login.aspx");

                string role = Session["Role"].ToString();
                string username = Session["Username"].ToString();

                if (role == "Employee")
                {
                    pnlEmployeeProfile.Visible = true;
                    LoadEmployeeProfile(username);
                }
                else if (role == "Admin" || role == "HR Manager")
                {
                    pnlAdminStats.Visible = true;
                    LoadDashboardStats();
                }

               
            }
        }
        private void LoadEmployeeProfile(string name)
        {
            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlCommand cmd = new SqlCommand("SELECT Name, Email, Department, Designation, Salary, JoiningDate FROM Employees WHERE Name = @Name", conn);
                cmd.Parameters.AddWithValue("@Name", name);
                conn.Open();

                SqlDataReader reader = cmd.ExecuteReader();
                DataTable dt = new DataTable();
                dt.Load(reader);

                dvProfile.DataSource = dt;
                dvProfile.DataBind();
            }
        }


        private void LoadDashboardStats()
        {
            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlCommand cmd1 = new SqlCommand("SELECT COUNT(*) FROM Employees", conn);
                SqlCommand cmd2 = new SqlCommand("SELECT COUNT(DISTINCT Department) FROM Employees", conn);

                conn.Open();
                lblTotalEmployees.Text = cmd1.ExecuteScalar().ToString();
                lblTotalDepartments.Text = cmd2.ExecuteScalar().ToString();
            }
        }


    }

}
