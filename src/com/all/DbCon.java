package com.all;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbCon {
    static private Connection connection;
    static private String driver = "com.mysql.cj.jdbc.Driver";
    static private String host ="jdbc:mysql://localhost:3306/";
    static private String db= "jsp";
    static private String user= "root";
    static private String password ="";
    static public Connection getCon() {
        if(connection==null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(host + db, user, password);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return connection;
    }
}
