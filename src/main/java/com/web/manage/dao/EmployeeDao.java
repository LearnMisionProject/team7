package com.web.manage.dao;

import com.web.base.dao.BaseDao;
import com.web.manage.entity.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface EmployeeDao extends BaseDao<Employee,String> {



    /**
     * 通过pageNumber和pageSize分页查询
     */
    List<Employee> getEmployeeListByPage(Integer pageNumber, Integer pageSize ,String name);
}
