package com.web.manage.service;

import com.web.base.service.BaseService;
import com.web.manage.entity.Task;
import com.web.util.Pager;
import com.web.vo.TaskVo;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface TaskService extends BaseService<Task, String> {
    /**
     * 获取角色的列表
     *
     * @return
     */
    Pager getTaskListByPage(Integer pageNumber, Integer pageSize);

    /**
     * 修改
     *
     * @return
     */
    public TaskVo getId(String id);


    /**
     * 删除
     *
     * @return
     */
    public void delete(String... ids);


    /**
     * 通过ID查询
     */

}
