package com.web.manage.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.manage.dao.EmployeeDao;
import com.web.manage.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee,String> implements EmployeeDao{


    @Override
    public List<Employee> getEmployeeListByPage(Integer pageNumber, Integer pageSize ,String name) {
        String hql = "from Employee e where e.name like'%"+name+"%'";
        return this.getListByPage(pageNumber,pageSize,hql,new String[] {});
    }
}
