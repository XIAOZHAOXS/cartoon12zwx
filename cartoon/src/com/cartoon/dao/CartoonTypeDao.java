package com.cartoon.dao;

import com.cartoon.pojo.CartoonType;

import java.util.List;

public interface CartoonTypeDao {
    public int insert(CartoonType cartoonType);
    //根据类型名进行精确查询
    public CartoonType select(String typename);
    public List<CartoonType> select();
    public int delete(String typeName);
    public List<CartoonType> select(int pageNo,int pageSize);
    //查询表里面总的行数
    public int selectRowCount();
}
