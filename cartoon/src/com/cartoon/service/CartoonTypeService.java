package com.cartoon.service;

import com.cartoon.pojo.CartoonType;

import java.util.List;

public interface CartoonTypeService {
    public boolean insert(CartoonType cartoonType);
    public List<CartoonType> select();
    public boolean delete(String typeName);
    public List<CartoonType> getCartoonTypes(int pageNo,int pageSize);
    //获取最后的页码数
    public int getpageCount(int pageSize);
}
