package com.web.manage.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.manage.dao.DepartmentDao;
import com.web.manage.entity.Department;
import com.web.manage.service.DepartmentSerivce;
import com.web.util.Pager;
import com.web.vo.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class DepartmentSerivceImpl extends BaseServiceImpl<Department,String> implements DepartmentSerivce{
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        super.setBaseDao(departmentDao);
    }

    @Override
    public Department getDById(String id) {
        return departmentDao.get(id);
    }

    @Override
    public Pager getDepartmentListByPage(Integer pageNumber, Integer pageSize) {
        List<Department> list = departmentDao.getDepartmentListByPage(pageNumber,pageSize);
        List<DepartmentVO> departmentVOList = new ArrayList<DepartmentVO>();
        if (list != null && !list.isEmpty()) {
            for (Department department : list) {
                DepartmentVO departmentVO = DepartmentVO.fromDepartment(department);
                departmentVOList.add(departmentVO);
            }
        }
        Integer totalRows = departmentDao.count();
        Pager pager = new Pager();
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        pager.setList(departmentVOList);
        return pager;
    }

    public List<Department> getAllList() {
        return departmentDao.getAll();
    }

    @Override
    public Department getFromId(String id) {
        return departmentDao.get(id);
    }
}
