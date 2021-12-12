package com.cartoon.dao.impl;

import com.cartoon.dao.AdminDao;
import com.cartoon.pojo.Admin;

import java.sql.*;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    @Override
    public int insert(Admin admin) {
        int row = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = BaseDao.getConnection();
            pstmt = con.prepareStatement("insert into admin(username,userpwd,truename) values(?,?,?);");
            pstmt.setString(1, admin.getUserName());
            pstmt.setString(2, admin.getUserPwd());
            pstmt.setString(3, admin.getTrueName());
            row = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.close(pstmt,con);
            }
        return row;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public int delete(Admin admin) {
        return 0;
    }

    @Override
    public Admin select(String username) {
        Admin queryAdmin = null;
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = BaseDao.getConnection();
            pstmt = con.prepareStatement("select * from admin where username=?");
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            if (rs!=null && rs.next()){
                //当结果集中有数据的时候，说明查询的管理员对象应该是存在的
                queryAdmin = new Admin();
                queryAdmin.setId(rs.getInt("id"));
                queryAdmin.setUserName(rs.getString("username"));
                queryAdmin.setUserPwd(rs.getString("userpwd"));
                queryAdmin.setTrueName(rs.getString("truename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.close(rs,pstmt,con);
        }
        return queryAdmin;
    }

    @Override
    public List<Admin> select() {
        return null;
    }

    public static void main(String[] args) {
        AdminDao dao = new AdminDaoImpl();
        Admin admin = new Admin();
        admin.setUserName("test");
        admin.setUserPwd("test");
        admin.setTrueName("Test");

    }
}
