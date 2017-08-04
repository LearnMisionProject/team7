package com.web.manage.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.manage.dao.ProductDao;
import com.web.manage.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product,String> implements ProductDao {
    @Override
    public List<Product> getProductListByPage(Integer pageNumber, Integer pageSize,String name,Double suggestedPrice) {
        String hql =null;
        if(name!=null&&suggestedPrice==null) {
         hql ="from Product p where p.name like '%"+name+"%'";
        }
        if( "".equals(name) && suggestedPrice!=null) {
          hql ="from Product p where p.suggestedprice="+suggestedPrice;
        }

        if(name==null&&suggestedPrice==null) {
         hql = "from Product";
        }
        return  this.getListByPage(pageNumber,pageSize,hql);
    }
}
