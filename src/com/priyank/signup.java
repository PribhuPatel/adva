package com.priyank;

import com.all.DbCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "signup")
public class signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username").toString().trim();
        String password = request.getParameter("password").toString().trim();

        Statement stmt;
        ResultSet resultSet;
//         String query;
        PrintWriter out  = response.getWriter();

        try {
            Connection connection =DbCon.getCon();
            PreparedStatement a = connection.prepareStatement("SELECT * FROM users where username=?");
            a.setString(1,username);

            ResultSet b= a.executeQuery();
            if(b.next()){
                out.print("User is already enrolled");
            } else {
                PreparedStatement ins = connection.prepareStatement("INSERT INTO users values(?,?)");

                ins.setString(1,username);
                ins.setString(2,password);


                ins.execute();

                Cookie cookie = new Cookie("username",username);
                response.addCookie(cookie);
//                HttpSession session = request.getSession();
//                session.setAttribute("username",username);
                response.sendRedirect("profile");
//                out.println("Saved");
            }
        } catch(Exception e) {
            out.print(e);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }
}
