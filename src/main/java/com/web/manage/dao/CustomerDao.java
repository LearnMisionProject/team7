package com.web.manage.dao;

import com.web.base.dao.BaseDao;
import com.web.manage.entity.Customer;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface CustomerDao extends BaseDao<Customer,String> {

    List<Customer> getCustomerListByPage(Integer pageNumber,Integer pageSize);

}
