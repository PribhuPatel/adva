package com.priyank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();

        Connection connection;
        Statement stmt;
        ResultSet resultSet;
//         String query;
        PrintWriter out  = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "");
//            String query = "SELECT * FROM login where username=?";
            PreparedStatement a = connection.prepareStatement("SELECT * FROM login where username=? and password=?");
//
            a.setString(1,username);
            a.setString(2,password);
//

            ResultSet b= a.executeQuery();
//            String pass="";
//            System.out.println(b.next());
//            while ( b.next() ) {
//                pass = b.getString("password");
//                System.out.println(pass);

//            }
//            System.out.println(b.next());
            if(b.next()){
                out.print("Done");
//                out.print(resultSet);
//            out.print("Welcome "+username);
            } else {
                out.print("Sorry");
            }
        } catch(Exception e) {
            out.print(e);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
