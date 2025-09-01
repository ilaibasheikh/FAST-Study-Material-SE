using System;
using System.Data.SqlClient;
using System.Configuration;
using System.Data;


public class User
{
    public string Username { get; set; }
    public string Email { get; set; }
    public string Password { get; set; }
    public string Status { get; set; }
    public int Id { get; set; }

    public User() {

    }

    public User(int id)
    {
        string connStr = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        using (SqlConnection con = new SqlConnection(connStr))
        {
            string query = "SELECT * FROM Users WHERE userid = @userid";
            using (SqlCommand cmd = new SqlCommand(query, con))
            {
                cmd.Parameters.AddWithValue("@userId", id);
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    Id = id;
                    Username = reader["Username"].ToString();
                    Email = reader["Email"].ToString();
                    Password = reader["Passwordhash"].ToString();
                    Status = reader["Status"].ToString();
                }
            }
        }
    }
    public User(string username, string email, string password)
    {
        Username = username;
        Email = email;
        Password = password;
        Status = "Pending";
    }

    public bool AddUser()
    {
        try
        {
            string connStr = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
            using (SqlConnection con = new SqlConnection(connStr))
            {
                string query = "INSERT INTO Users (Username, Email, PasswordHash, Status) VALUES (@Username, @Email, @PasswordHash, @Status)";
                using (SqlCommand cmd = new SqlCommand(query, con))
                {
                    cmd.Parameters.AddWithValue("@Username", Username);
                    cmd.Parameters.AddWithValue("@Email", Email);
                    cmd.Parameters.AddWithValue("@PasswordHash", Password);
                    cmd.Parameters.AddWithValue("@Status", Status);

                    con.Open();
                    int rowsAffected = cmd.ExecuteNonQuery();
                    return rowsAffected > 0;
                }
            }
        }
        catch (Exception)
        {
            return false;
        }
    }
    public bool UpdateUser()
    {
        try
        {
            string connStr = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
            using (SqlConnection con = new SqlConnection(connStr))
            {
                string query = "UPDATE Users SET Username = @Username, Email = @Email, Passwordhash = @Passwordhash, Status = @Status WHERE userId = @userId";
                using (SqlCommand cmd = new SqlCommand(query, con))
                {
                    cmd.Parameters.AddWithValue("@userId", Id);
                    cmd.Parameters.AddWithValue("@Username", Username);
                    cmd.Parameters.AddWithValue("@Email", Email);
                    cmd.Parameters.AddWithValue("@Passwordhash", Password);
                    cmd.Parameters.AddWithValue("@Status", Status);

                    con.Open();
                    int rowsAffected = cmd.ExecuteNonQuery();
                    return rowsAffected > 0;
                }
            }
        }
        catch (Exception)
        {
            return false;
        }
    }
    public DataTable GetUsers()
    {
        string connStr = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        using (SqlConnection con = new SqlConnection(connStr))
        {
            string query = "SELECT userId, Username, Email, Status FROM Users";
            using (SqlDataAdapter da = new SqlDataAdapter(query, con))
            {
                DataTable dt = new DataTable();
                da.Fill(dt);
                return dt;
            }
        }
    }

    public bool DeleteUser(int id)
    {
        string connStr = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        using (SqlConnection con = new SqlConnection(connStr))
        {
            string query = "DELETE FROM Users WHERE userId = @userId";
            using (SqlCommand cmd = new SqlCommand(query, con))
            {
                cmd.Parameters.AddWithValue("@userId", id);
                con.Open();
                return cmd.ExecuteNonQuery() > 0;
            }
        }
    }
}
