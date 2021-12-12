package com.cartoon.service.impl;

import com.cartoon.dao.CartoonTypeDao;
import com.cartoon.dao.impl.CartoonTypeDaoImpl;
import com.cartoon.pojo.CartoonType;
import com.cartoon.service.CartoonTypeService;

import java.util.List;

public class CartoonTypeServiceImpl implements CartoonTypeService {
    private CartoonTypeDao dao = new CartoonTypeDaoImpl();
    @Override
    public boolean insert(CartoonType cartoonType) {
        boolean isSuccess = false;
        CartoonType queryCartoonType = dao.select(cartoonType.getTypeName());
        if (queryCartoonType == null) {
            int row = dao.insert(cartoonType);
            if (row > 0) {
                isSuccess = true;
            }
        }
        return isSuccess;
    }

    @Override
    public List<CartoonType> select() {
        List<CartoonType> list = dao.select();
        return list;
    }

    @Override
    public boolean delete(String typeName) {
        boolean isSuccess = false;
        int row = dao.delete(typeName);
        if(row > 0){
            isSuccess = true;
        }
        return isSuccess;
    }

    @Override
    public List<CartoonType> getCartoonTypes(int pageNo, int pageSize) {
        List<CartoonType> list = null;
        list = dao.select(pageNo,pageSize);
        return list;
    }

    @Override
    public int getpageCount(int pageSize) {
        int pageCount = 0;
        int rowCount = dao.selectRowCount();
//        if(rowCount % pageSize == 0){
//            pageCount = rowCount / pageSize;
//        }else {
//            pageCount = (rowCount / pageSize) + 1;
//        }
        pageCount = rowCount / pageSize;
        if (rowCount % pageSize != 0){
            pageCount++;
        }
        return pageCount;
    }
}
