package com.web.manage.service.impl;

import com.web.base.service.BaseService;
import com.web.base.service.impl.BaseServiceImpl;
import com.web.manage.dao.EmployeeDao;
import com.web.manage.entity.Employee;
import com.web.manage.service.EmployeeService;
import com.web.util.Pager;
import com.web.vo.EmployeeVO;
import org.apache.struts2.components.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee,String> implements EmployeeService {


    /**
     * 注入EmployeeDao接口
     */
    @Autowired
    private  EmployeeDao employeeDao;

    /**
     * 通过多态注入baseDao接口（接口在注入时找不到相应的javaBean,会找到它对应的实现类进行注入）
     * @param employeeDao
     */
    @Autowired
    private void setEmployeeDao(EmployeeDao employeeDao) {

        super.setBaseDao(employeeDao);
    }

    @Override
    public Pager getEmployeeListByPage(Integer pageNumber, Integer pageSize ,String name) {
       List<Employee> list = employeeDao.getEmployeeListByPage(pageNumber,pageSize,name);
       List<EmployeeVO> employeeVOList = new ArrayList<EmployeeVO>();
        if (list != null && !list.isEmpty()) {
            for (Employee employee : list) {
                EmployeeVO employeeVO = EmployeeVO.fromEmployee(employee);
                        employeeVOList.add(employeeVO);
            }
        }
        Integer totalRows = employeeDao.count();
            Pager pager = new Pager();
            pager.setPageNumber(pageNumber);
            pager.setPageSize(pageSize);
            pager.setTotalRows(totalRows);
            pager.setTotalPage(pager.getTotalPage());
            pager.setList(employeeVOList);
        return pager;
    }

}
