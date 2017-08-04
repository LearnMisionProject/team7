package com.web.manage.dao;

import com.web.base.dao.BaseDao;
import com.web.manage.entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface ProductDao extends BaseDao<Product,String> {

    List<Product> getProductListByPage(Integer pageNumber,Integer Pagesize,String name,Double suggestedPrice);
}
