package com.priyank;

import com.all.DbCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

        Statement stmt;
        ResultSet resultSet;
        PrintWriter out  = response.getWriter();

        try {
            Connection connection= DbCon.getCon();
            PreparedStatement a = connection.prepareStatement("SELECT * FROM users where username=? and password=?");

            a.setString(1,username);
            a.setString(2,password);


            ResultSet b= a.executeQuery();

            if(b.next()){
                Cookie cookie = new Cookie("username",username);
//                cookie.setMaxAge();
//                cookie.setDomain("");
                response.addCookie(cookie);
//                HttpSession session = request.getSession();
//                session.setAttribute("username",username);
                response.sendRedirect("profile");
            } else {
                out.println("Go ahead");
            }
        } catch(Exception e) {
            out.print(e);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
