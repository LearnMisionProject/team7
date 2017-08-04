package com.web.manage.service;

import com.web.base.service.BaseService;
import com.web.manage.entity.Department;
import com.web.util.Pager;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface DepartmentSerivce extends BaseService<Department, String> {
    Pager getDepartmentListByPage(Integer pageNumber,Integer pageSize);

    List<Department> getAllList();

    Department getFromId(String id);

    Department getDById(String id);
}
