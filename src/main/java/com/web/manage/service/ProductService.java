package com.web.manage.service;

import com.web.base.service.BaseService;
import com.web.manage.entity.Product;
import com.web.util.Pager;
import com.web.vo.ProductVO;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface ProductService extends BaseService<Product,String> {
    Pager getProductListByPage(Integer pageNumber,Integer pagesize,String name,Double suggestedPrice);


    ProductVO getProductVO(String productid);
}
