package com.web.manage.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.manage.dao.ProductDao;
import com.web.manage.entity.Product;
import com.web.manage.service.ProductService;
import com.web.util.Pager;
import com.web.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,String> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductService productService;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        super.setBaseDao(productDao);
    }


    @Override
    public Pager getProductListByPage(Integer pageNumber, Integer pagesize,String name,Double suggestedPrice) {
        List<Product> list = productDao.getProductListByPage(pageNumber,pagesize,name,suggestedPrice);
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        if(list!=null&&!list.isEmpty()){
        for(Product product:list) {
            ProductVO productVO = ProductVO.fromProduct(product);
            productVOList.add(productVO);
        }
        }
        Integer totalRows = productDao.count();
         Pager pager = new Pager();
         pager.setTotalRows(totalRows);
         pager.setPageNumber(pageNumber);
         pager.setPageSize(pagesize);
         pager.setTotalPage(pager.getTotalPage());
         pager.setList(productVOList);
         return pager;
    }

    @Override
    public ProductVO getProductVO(String productid) {
        Product product = productService.get(productid);
         return   ProductVO.fromProduct(product);
    }
}
