package com.web.manage.service;

import com.web.base.service.BaseService;
import com.web.manage.entity.Employee;
import com.web.util.Pager;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface EmployeeService extends BaseService<Employee,String>{

    Pager getEmployeeListByPage(Integer pageNumber,Integer PageSize,String name);
}
