package com.cartoon.dao.impl;

import com.cartoon.dao.UserDao;
import com.cartoon.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User select(String username) {
        User queryUser = null;
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = BaseDao.getConnection();
            pstmt = con.prepareStatement("select * from user where username=?");
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            if (rs!=null && rs.next()){
                //当结果集中有数据的时候，说明查询的会员对象应该是存在的
                queryUser = new User();
                queryUser.setId(rs.getInt("id"));
                queryUser.setUserName(rs.getString("username"));
                queryUser.setUserPwd(rs.getString("userpwd"));
                queryUser.setTrueName(rs.getString("truename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.close(rs,pstmt,con);
        }
        return queryUser;
    }
}
