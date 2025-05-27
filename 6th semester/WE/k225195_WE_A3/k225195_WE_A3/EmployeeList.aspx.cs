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
    public partial class EmployeeList : System.Web.UI.Page
	{
    string connStr = ConfigurationManager.ConnectionStrings["dbcs"].ConnectionString;
		protected void Page_Load(object sender, EventArgs e)
		{
            if (!IsPostBack)
            {
                if (Session["Role"] == null ||
                   !(Session["Role"].ToString() == "Admin" || Session["Role"].ToString() == "HR Manager"))
                {
                    Response.Redirect("Login.aspx");
                }

                LoadEmployees();
            }
        }
        private void LoadEmployees()
        {
            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlDataAdapter da = new SqlDataAdapter("SELECT * FROM Employees", conn);
                DataTable dt = new DataTable();
                da.Fill(dt);
                gvEmployees.DataSource = dt;
                gvEmployees.DataBind();
            }
        }
        protected void gvEmployees_RowEditing(object sender, GridViewEditEventArgs e)
        {
            gvEmployees.EditIndex = e.NewEditIndex;
            LoadEmployees();
        }

        protected void gvEmployees_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
        {
            gvEmployees.EditIndex = -1;
            LoadEmployees();
        }
        protected void gvEmployees_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            GridViewRow row = gvEmployees.Rows[e.RowIndex];

            int id = Convert.ToInt32(gvEmployees.DataKeys[e.RowIndex].Value);
            string name = ((TextBox)row.Cells[0].Controls[0]).Text;
            string email = ((TextBox)row.Cells[1].Controls[0]).Text;
            string department = ((TextBox)row.Cells[2].Controls[0]).Text;
            string designation = ((TextBox)row.Cells[3].Controls[0]).Text;
            string salary = ((TextBox)row.Cells[4].Controls[0]).Text;
            string joiningDate = ((TextBox)row.Cells[5].Controls[0]).Text;

            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlCommand cmd = new SqlCommand(@"UPDATE Employees 
                SET Name=@Name, Email=@Email, Department=@Dept, Designation=@Desig, Salary=@Salary, JoiningDate=@Date 
                WHERE EmployeeId=@ID", conn);

                cmd.Parameters.AddWithValue("@Name", name);
                cmd.Parameters.AddWithValue("@Email", email);
                cmd.Parameters.AddWithValue("@Dept", department);
                cmd.Parameters.AddWithValue("@Desig", designation);
                cmd.Parameters.AddWithValue("@Salary", Convert.ToDecimal(salary));
                cmd.Parameters.AddWithValue("@Date", Convert.ToDateTime(joiningDate));
                cmd.Parameters.AddWithValue("@ID", id);

                conn.Open();
                cmd.ExecuteNonQuery();
            }

            gvEmployees.EditIndex = -1;
            LoadEmployees();
        }
        protected void gvEmployees_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            int id = Convert.ToInt32(gvEmployees.DataKeys[e.RowIndex].Value);

            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlCommand cmd = new SqlCommand("DELETE FROM Employees WHERE EmployeeId=@ID", conn);
                cmd.Parameters.AddWithValue("@ID", id);

                conn.Open();
                cmd.ExecuteNonQuery();
            }

            LoadEmployees();
        }
        protected void btnAddEmployee_Click(object sender, EventArgs e)
        {
            string name = txtName.Text.Trim();
            string email = txtEmail.Text.Trim();
            string department = txtDept.Text.Trim();
            string designation = txtDesig.Text.Trim();
            string salaryText = txtSalary.Text.Trim();
            string joiningDateText = txtJoinDate.Text.Trim();

            if (string.IsNullOrWhiteSpace(name) || string.IsNullOrWhiteSpace(email))
            {
                lblMessage.Text = "Name and Email are required.";
                lblMessage.ForeColor = System.Drawing.Color.Red;
                return;
            }

            decimal salary;
            DateTime joiningDate;

            if (!decimal.TryParse(salaryText, out salary))
            {
                lblMessage.Text = "Invalid salary.";
                lblMessage.ForeColor = System.Drawing.Color.Red;
                return;
            }

            if (!DateTime.TryParse(joiningDateText, out joiningDate))
            {
                lblMessage.Text = "Invalid joining date.";
                lblMessage.ForeColor = System.Drawing.Color.Red;
                return;
            }

            using (SqlConnection conn = new SqlConnection(connStr))
            {
                SqlCommand cmd = new SqlCommand(@"INSERT INTO Employees 
            (Name, Email, Department, Designation, Salary, JoiningDate) 
            VALUES (@Name, @Email, @Dept, @Desig, @Salary, @JoinDate)", conn);

                cmd.Parameters.AddWithValue("@Name", name);
                cmd.Parameters.AddWithValue("@Email", email);
                cmd.Parameters.AddWithValue("@Dept", department);
                cmd.Parameters.AddWithValue("@Desig", designation);
                cmd.Parameters.AddWithValue("@Salary", salary);
                cmd.Parameters.AddWithValue("@JoinDate", joiningDate);

                conn.Open();
                cmd.ExecuteNonQuery();
            }

            lblMessage.Text = "Employee added successfully!";
            lblMessage.ForeColor = System.Drawing.Color.Green;

            txtName.Text = txtEmail.Text = txtDept.Text = txtDesig.Text = txtSalary.Text = txtJoinDate.Text = "";

            LoadEmployees();
        }
    }
}