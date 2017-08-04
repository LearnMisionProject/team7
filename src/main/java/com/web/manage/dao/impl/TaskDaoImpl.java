package com.web.manage.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.manage.dao.TaskDao;
import com.web.manage.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Repository
public class TaskDaoImpl extends BaseDaoImpl<Task ,String>implements TaskDao{



    /**
     * 通过页数查询
     * @param pageNumber 当前页数
     * @param pageSize 当前显示条数
     * @return
     */
    @Override
    public List<Task> getTask(Integer pageNumber, Integer pageSize) {
        String hql = "from Task ";
        return this.getListByPage(pageNumber,pageSize,hql,new String[]{});
    }

}
