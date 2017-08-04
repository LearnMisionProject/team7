package com.web.manage.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.manage.dao.CustomerDao;
import com.web.manage.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer,String> implements CustomerDao {
    @Override
    public List<Customer> getCustomerListByPage(Integer pageNumber, Integer pageSize) {
        String hql = "from Customer";
        return  this.getListByPage(pageNumber,pageSize,hql,new String[] {});
    }
}
