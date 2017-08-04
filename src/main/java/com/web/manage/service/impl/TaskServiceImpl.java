package com.web.manage.service.impl;

import com.web.base.dao.BaseDao;
import com.web.base.service.impl.BaseServiceImpl;
import com.web.manage.dao.TaskDao;

import com.web.manage.entity.Task;
import com.web.manage.service.TaskService;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/7/26.
 */

@Service
public class TaskServiceImpl extends BaseServiceImpl<Task,String> implements TaskService {

    @Autowired
    private TaskDao taskDao;




    @Override
    public Pager getTaskListByPage(Integer pageNumber, Integer pageSize ) {
        List<Task> list =taskDao.getTask(pageNumber,pageSize);
        List<TaskVo> taskVoList = new ArrayList<TaskVo>();
        if (list != null && !list.isEmpty()) {
            for (Task  task: list) {
               TaskVo taskVo = TaskVo.fromTask(task);
                taskVoList.add(taskVo);
            }
        }
        Integer totalRows = taskDao.count();
        Pager pager = new Pager();
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        pager.setList(taskVoList);
        return pager;
    }

    public void save(Task task) {
        taskDao.save(task);
    }

    public  void  update(Task task){
        taskDao.update(task);

    }

    public TaskVo getId(String id) {
        Task task = taskDao.get(id);
        return TaskVo.fromTask(task);
    }

    @Override
    public void delete(String... ids) {
        if (ids!=null&&ids.length>0){
            for(String id : ids){
            taskDao.delete(id);
            }

        }

    }


}
