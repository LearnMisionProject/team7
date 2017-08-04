package com.web.manage.dao;

import com.web.base.dao.BaseDao;
import com.web.manage.entity.Task;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface TaskDao extends BaseDao<Task ,String> {

    /**
     * 通过pageNumber和pageSize分页查询
     */
    List<Task> getTask(Integer  pageNumber,Integer pageSize );
}
