package com.cartoon.dao.impl;

import java.sql.*;

public class BaseDao {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/cartoondb";
        String user = "root";
        String password = "123456";
        con = DriverManager.getConnection(url,user,password);
        return con;
    }
    public static void close(ResultSet rs, PreparedStatement pstmt,Connection con){
        try {
            if (rs!=null){
                rs.close();
            }
            if (pstmt!=null){
                pstmt.close();
            }
            if (con!=null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement pstmt,Connection con){
        close(null,pstmt,con);
    }
}
