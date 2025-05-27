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
	public partial class Report : System.Web.UI.Page
	{
        string connStr = ConfigurationManager.ConnectionStrings["dbcs"].ConnectionString;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["Username"] == null || Session["Role"].ToString() != "Admin")
            {
                Response.Redirect("~/Login.aspx");
                return;
            }

            if (!IsPostBack)
            {
                pnlReport.Visible = true;
                LoadSummary();
                LoadEmployeesByDepartment();
                LoadAverageSalaryByDepartment();
                LoadRecentJoins();
            }
        }
        private void LoadSummary()
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

        private void LoadEmployeesByDepartment()
        {
            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlDataAdapter da = new SqlDataAdapter(
                    "SELECT Department, COUNT(*) AS TotalEmployees FROM Employees GROUP BY Department", conn);
                DataTable dt = new DataTable();
                da.Fill(dt);
                gvByDepartment.DataSource = dt;
                gvByDepartment.DataBind();
            }
        }
        private void LoadAverageSalaryByDepartment()
        {
            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlDataAdapter da = new SqlDataAdapter(
                    "SELECT Department, AVG(Salary) AS AvgSalary FROM Employees GROUP BY Department", conn);
                DataTable dt = new DataTable();
                da.Fill(dt);
                gvAvgSalary.DataSource = dt;
                gvAvgSalary.DataBind();
            }
        }

        private void LoadRecentJoins()
        {
            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlDataAdapter da = new SqlDataAdapter(
                    "SELECT TOP 5 Name, Department, Designation, JoiningDate FROM Employees ORDER BY JoiningDate DESC", conn);
                DataTable dt = new DataTable();
                da.Fill(dt);
                gvRecentJoins.DataSource = dt;
                gvRecentJoins.DataBind();
            }
        }

    }
}