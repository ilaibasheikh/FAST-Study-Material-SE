package scd.assignment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DashboardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        int roleId = (Integer) session.getAttribute("role_id");

        String roleName=(String) session.getAttribute("role_name");

        System.out.println("Role ID: " + roleId);
        System.out.println("Role Name: " + roleName);


        ArrayList<String> menuItems =  new ArrayList<>();
        try  {


            Connection connection = Database.getConnection();
            String query = "SELECT m.menu_name FROM menu_items m JOIN role_menu_mapping rm ON m.menu_id = rm.menu_id WHERE rm.role_id = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, roleId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                menuItems.add(rs.getString("menu_name"));
                System.out.println("Menu Item: " + rs.getString("menu_name"));
            }


            rs.close();
            st.close();

        } catch (Exception e) {
            System.err.println("Error fetching menu items: " + e);
        }



        request.setAttribute("roleName",roleName);
        request.setAttribute("menuItems", menuItems);

        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


}