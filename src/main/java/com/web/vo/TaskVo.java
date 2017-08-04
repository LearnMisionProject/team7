package com.web.vo;


import com.web.manage.entity.Task;
import com.web.system.entity.User;
import com.web.util.DateUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/27.
 */
public class TaskVo {
    private String taskid;//选择
    private String subject;//主题
    private String aboutUserId;
    private String abouUserName;//相关内容
    private String userByCreatoruserid;
    private String userByCreatoruserName;//创建者
    private String userByOwneruserid;
    private String userByOwneruserName;//负责人
    private String userByDeleteuserid;
    private String userByDeleteuserName;//删除用户
    private String ownerUsername;//
    private String status;//状态
    private String priority;//优先级
    private String duedate;//截止日期
    private String createdate;//创建时间
    private String updtadate;//更新时间
    private String sendemail; //邮箱
    private String description;//描述信息
    private String isclose;
    private String isdeleted;
    private String deletetime;




    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAboutUserId() {
        return aboutUserId;
    }

    public void setAboutUserId(String aboutUserId) {
        this.aboutUserId = aboutUserId;
    }

    public String getAbouUserName() {
        return abouUserName;
    }

    public void setAbouUserName(String abouUserName) {
        this.abouUserName = abouUserName;
    }

    public String getUserByOwneruserid() {
        return userByOwneruserid;
    }

    public String getUserByCreatoruserid() {
        return userByCreatoruserid;
    }

    public void setUserByCreatoruserid(String userByCreatoruserid) {
        this.userByCreatoruserid = userByCreatoruserid;
    }

    public String getUserByCreatoruserName() {
        return userByCreatoruserName;
    }

    public void setUserByCreatoruserName(String userByCreatoruserName) {
        this.userByCreatoruserName = userByCreatoruserName;
    }

    public void setUserByOwneruserid(String userByOwneruserid) {
        this.userByOwneruserid = userByOwneruserid;
    }

    public String getUserByOwneruserName() {
        return userByOwneruserName;
    }

    public void setUserByOwneruserName(String userByOwneruserName) {
        this.userByOwneruserName = userByOwneruserName;
    }


    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUpdtadate() {
        return updtadate;
    }

    public void setUpdtadate(String updtadate) {
        this.updtadate = updtadate;
    }

    public String getUserByDeleteuserid() {
        return userByDeleteuserid;
    }

    public void setUserByDeleteuserid(String userByDeleteuserid) {
        this.userByDeleteuserid = userByDeleteuserid;
    }

    public String getUserByDeleteuserName() {
        return userByDeleteuserName;
    }

    public void setUserByDeleteuserName(String userByDeleteuserName) {
        this.userByDeleteuserName = userByDeleteuserName;
    }

    public String getSendemail() {
        return sendemail;
    }

    public void setSendemail(String sendemail) {
        this.sendemail = sendemail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsclose() {
        return isclose;
    }

    public void setIsclose(String isclose) {
        this.isclose = isclose;
    }

    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(String deletetime) {
        this.deletetime = deletetime;
    }

    /**
     * 把Task对象封装到VO中
     */
    public  static TaskVo fromTask(Task task){
        if (task!=null){
            TaskVo taskVo = new TaskVo();
            taskVo.setTaskid(task.getTaskid());
            taskVo.setSubject(task.getSubject());

            if (task.getAboutUser()!=null){
                taskVo.setAboutUserId(task.getAboutUser());
                taskVo.setAbouUserName(task.getAboutUser());
            }

            taskVo.setUserByOwneruserName(task.getUserByOwneruserid().getUsername());
            taskVo.setOwnerUsername(task.getUserByOwneruserid().getUsername());
            taskVo.setStatus(task.getStatus());

            if(task.getUserByCreatoruserid()!= null){
                taskVo.setUserByCreatoruserid(task.getUserByCreatoruserid().getId());
                taskVo.setUserByCreatoruserName(task.getUserByCreatoruserid().getUsername());
            }
            if (task.getUserByDeleteuserid()!=null){
                taskVo.setUserByDeleteuserid(task.getUserByDeleteuserid().getId());
                taskVo.setUserByDeleteuserName(task.getUserByDeleteuserid().getUsername());
            }
            taskVo.setPriority(task.getPriority());
            taskVo.setDuedate(DateUtil.formatDate(task.getDuedate(),"yyyy-MM-dd HH:mm:ss"));
            taskVo.setCreatedate(DateUtil.formatDate(task.getCreatedate(),"yyyy-MM-dd HH:mm:ss"));
            taskVo.setUpdtadate(DateUtil.formatDate(task.getUpdtadate(),"yyyy-MM-dd HH:mm:ss"));
            return taskVo;
        }
        return null;
    }

    public static Task fromTaskVO(TaskVo taskVo, User user) {
        if(taskVo==null){
            return null;
        }
        Task  task =new Task();
        task.setTaskid(taskVo.getTaskid());

        if (user!=null){
        task.setUserByCreatoruserid(user);
        task.setUserByDeleteuserid(user);
        task.setUserByOwneruserid(user);
        task.setUserByDeleteuserid(user);
        }
        task.setDuedate(new Date());
        task.setCreatedate(new Date());
        task.setUpdtadate(new Date());
        task.setSubject(taskVo.getSubject());
        task.setAboutUser(taskVo.getAbouUserName());
        task.setStatus(taskVo.getStatus());
        task.setPriority(taskVo.getPriority());
        return task;

    }
}
