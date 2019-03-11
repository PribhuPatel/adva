package com.priyank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

@WebServlet(name = "mydefault")
public class mydefault extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getRequestURI();
      try {
            response.setHeader("Content-Length", String.valueOf(new File("/WEB-INF"+a).length()));
            request.getRequestDispatcher("/WEB-INF"+a).forward(request, response);
        } catch (Exception e){
            System.out.println(e);
        }
        }
}
