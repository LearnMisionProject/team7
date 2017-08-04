package com.web.manage.action;

import com.web.base.action.BaseAction;
import com.web.manage.entity.Task;
import com.web.manage.service.TaskService;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.TaskVo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@ParentPackage("json-default")
@Namespace("/manage/task")
public class TaskAction  extends BaseAction{
    @Autowired
    private TaskService taskService;


    private List<Task> list;
    private String taskid;
    private  Task task;
    private Pager pager;
    private  TaskVo taskVo;

    @Action(value = "TaskAction_list",results = {
            @Result(location = "list_task.jsp")
    })
    public String task(){
        return SUCCESS;
    }

    @Action(value = "TaskAction_findByPage")
    public void findByPage() throws IOException {
        Pager pager = taskService.getTaskListByPage(page,rows);
        resultData = ResultData.buildSuccessResult("获取列表成功",pager);
        printJSONObject(resultData,"userByCreatoruserid", "userByOwneruserid", "userByDeleteuserid");
    }
    /**
     * 跳转到添加页面
     * @return
     */
    @Action(value = "TaskAction_edit", results = {
            @Result(name = "success",location = "edit_task.jsp")
    })
    public String toAdd() {
        return SUCCESS;
    }

    /**
     *添加任务
     * @return
     */
    @Action(value = "TaskAction_saveOrUpdate")
    public  void  add() throws IOException {
        User user = (User) getSession().getAttribute("user");
        Task task = taskVo.fromTaskVO(taskVo, user);
        taskService.save(task);
        printJSONObject(ResultData.buildSuccessResult());

    }

    /**
     * 页面查看
     */
    @Action(value = "TaskAction_see",results = {
            @Result(location = "see_task.jsp")
    })
    public String see(){
        taskVo =  taskService.getId(taskid);
        return SUCCESS;
    }

    /**
     * 修改页面
     * @return
     */
    @Action(value = "TaskAction_toUpdate" ,results = {
            @Result(location = "modify_task.jsp")
    })
    public  String toupdate(){
        taskVo = taskService.getId(taskid);
        return SUCCESS;
    }

    /**
     * 修改任务
     * @throws IOException
     */
    @Action(value = "TaskAction_Update")
    public void update() throws IOException {
        User user=(User)getSession().getAttribute("user");
        Task task = taskVo.fromTaskVO(taskVo, user);
        taskService.update(task);
        printJSONObject(ResultData.buildSuccessResult("成功"));
    }

    /**
     * 删除页面
     * @return
     */
    @Action(value = "TaskAction_del")
    public  void  del() throws IOException {

       String[] ids = null;

        if (!taskid.isEmpty() && taskid != null){
            ids = taskid.split(",");
        }

         taskService.delete(ids);

        resultData = ResultData.buildSuccessResult("删除成功");

        printJSONObject(resultData);
    }

    /**
     * 查询
     * @return
     */



    public List<Task> getList() {

        return list;
    }

    public void setList(List<Task> list) {
        this.list = list;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public TaskVo getTaskVo() {
        return taskVo;
    }

    public void setTaskVo(TaskVo taskVo) {
        this.taskVo = taskVo;
    }
}
