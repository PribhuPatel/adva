package com.priyank;

import com.all.DbCon;
import com.all.Profile2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "profile")
public class profile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Statement stmt;
        ResultSet resultSet;
//         String query;
        PrintWriter out = response.getWriter();

        try {
            String username ="";
            Cookie []cookies = request.getCookies();
            for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("username")){
                    username= cookies[i].getValue();
//                    System.out.println(username);
                    break;
                }
//                System.out.println(cookies[i].getName());
            }

//            System.out.println(cookie[0].getValue());
            Connection connection= DbCon.getCon();
//            HttpSession session = request.getSession();
//            String username = (String) session.getAttribute("username");
          PreparedStatement a = connection.prepareStatement("SELECT * FROM users where username=?");

            a.setString(1, username);
             ResultSet b = a.executeQuery();
            if(b.next()) {
                Profile2 p = new Profile2(b.getString(4), b.getString(5), b.getString(8), b.getString(6), b.getString(9), b.getString(12), b.getString(13), b.getString(2), b.getString(7), b.getString(11));

                //            b.getString();
                request.setAttribute("data", p);
            }
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        } catch (Exception e){
            out.println(e);
        }
    }
}

