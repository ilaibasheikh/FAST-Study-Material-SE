using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;
using System.Configuration;

/// <summary>
/// Summary description for DatabaseConnection
/// </summary>
public class DatabaseConnection
{
    private SqlConnection con;

    // Constructor to initialize connection
    public DatabaseConnection()
    {
        string connStr = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        con = new SqlConnection(connStr);
    }

    // Open Connection
    public void OpenConnection()
    {
        if (con.State == System.Data.ConnectionState.Closed)
        {
            con.Open();
        }
    }

    // Close Connection
    public void CloseConnection()
    {
        if (con.State == System.Data.ConnectionState.Open)
        {
            con.Close();
        }
    }

    // Get Connection
    public SqlConnection GetConnection()
    {
        return con;
    }
}