package com.web.manage.dao;

import com.web.base.dao.BaseDao;
import com.web.manage.entity.Department;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface DepartmentDao extends BaseDao<Department,String> {
    /**
     * 通过pageNumber和pageSize分页查询
     */
    List<Department> getDepartmentListByPage(Integer pageNumber, Integer pageSize);

    Department getFromName(String name);
}
