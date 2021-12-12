package com.cartoon.dao.impl;

import com.cartoon.dao.CartoonTypeDao;
import com.cartoon.pojo.CartoonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartoonTypeDaoImpl implements CartoonTypeDao {
    public int insert(CartoonType cartoonType) {
        int row = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = BaseDao.getConnection();
            pstmt = con.prepareStatement("insert into cartoontype(typename) values(?);");
            pstmt.setString(1, cartoonType.getTypeName());
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
    public CartoonType select(String typename) {
        CartoonType queryCartoonType = null;
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = BaseDao.getConnection();
            pstmt = con.prepareStatement("select * from cartoontype where typename=?");
            pstmt.setString(1,typename);
            rs = pstmt.executeQuery();
            if (rs!=null && rs.next()){
                //当结果集中有数据的时候，说明查询的管理员对象应该是存在的
                queryCartoonType = new CartoonType();
                queryCartoonType.setTypeName(rs.getString("typename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.close(rs,pstmt,con);
        }
        return queryCartoonType;
    }

    @Override
    public List<CartoonType> select() {
        List<CartoonType> list = null;
        CartoonType cartoonTypes = null;
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = BaseDao.getConnection();
            pstmt = con.prepareStatement("select * from cartoontype");
            rs = pstmt.executeQuery();
            if (rs != null){
                list = new ArrayList<CartoonType>();
                while(rs.next()) {
                    cartoonTypes = new CartoonType();
                    cartoonTypes.setTypeId(rs.getInt("typeid"));
                    cartoonTypes.setTypeName(rs.getString("typename"));
                    list.add(cartoonTypes);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delete(String typeName) {
        int row = 0;
        Connection con=null;
        PreparedStatement pstmt=null;
        try {
            con = BaseDao.getConnection();
            pstmt = con.prepareStatement("delete from cartoontype where typename=?");
            pstmt.setString(1,typeName);
            row = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.close(pstmt,con);
        }
        return row;
    }

    @Override
    public List<CartoonType> select(int pageNo, int pageSize) {
        List<CartoonType> list = null;
        CartoonType cartoonTypes = null;
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = BaseDao.getConnection();
            pstmt = con.prepareStatement("select * from cartoontype limit ?, ?");
            pstmt.setInt(1,(pageNo - 1) * pageSize);
            pstmt.setInt(2,pageSize);
            rs = pstmt.executeQuery();
            if (rs != null){
                list = new ArrayList<CartoonType>();
                while(rs.next()) {
                    cartoonTypes = new CartoonType();
                    cartoonTypes.setTypeId(rs.getInt("typeid"));
                    cartoonTypes.setTypeName(rs.getString("typename"));
                    list.add(cartoonTypes);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int selectRowCount() {
        int rowCount = 0;
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = BaseDao.getConnection();
            pstmt = con.prepareStatement("select count(*) from cartoontype");
            rs = pstmt.executeQuery();
            if (rs!=null && rs.next()){
                rowCount = rs.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.close(rs,pstmt,con);
        }
        return rowCount;
    }
}
