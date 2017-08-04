package com.web.vo;

import com.web.manage.entity.Announcement;
import com.web.manage.entity.Department;
import com.web.system.entity.User;
import com.web.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/2.
 */
public class AnnouncementVO {

    private String announcementid;
    private String  departmentId;
    private String  departmentName;
    private String userId;
    private String userName;
    private Integer orderid;
    private String title;
    private String content;
    private String createtime;
    private String updatetime;
    private String color;
    private boolean status;
    private boolean isshow;

    /**
     * 实体类转vo
     * @param announcement
     * @return
     */
    public static AnnouncementVO fromAnnouncement(Announcement announcement) {
        AnnouncementVO announcementVO = null;
        if (announcement != null) {
            announcementVO =  new AnnouncementVO();
            announcementVO.setAnnouncementid(announcement.getAnnouncementid());
            announcementVO.setColor(announcement.getColor());
            announcementVO.setContent(announcement.getContent());
            announcementVO.setCreatetime(DateUtil.formatDate(announcement.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            if (announcement.getDepartment() != null) {
                announcementVO.setDepartmentId(announcement.getDepartment().getDepartmentid());
                announcementVO.setDepartmentName(announcement.getDepartment().getName());
            }
            announcementVO.setIsshow(announcement.getIsshow());
            announcementVO.setOrderid(announcement.getOrderid());
            announcementVO.setStatus(announcement.getStatus());
            announcementVO.setTitle(announcement.getTitle());
            announcementVO.setUpdatetime(DateUtil.formatDate(announcement.getUpdatetime(), "yyyy-MM-dd HH:mm:ss"));
            if (announcement.getUser() != null) {
                announcementVO.setUserId(announcement.getUser().getId());
                announcementVO.setUserName(announcement.getUser().getUsername());
            }
        }
        return announcementVO;
    }


    /**
     * vo转实体类
     * @param announcementVO
     * @param user
     * @param department
     * @return
     * @throws ParseException
     */
    public static Announcement fromAnnouncementVO(AnnouncementVO announcementVO, User user, Department department) throws ParseException {
        Announcement announcement = null;
        if (announcementVO != null) {
            announcement = new Announcement();
            announcement.setAnnouncementid(announcementVO.getAnnouncementid());
            announcement.setColor(announcementVO.getColor());
            announcement.setContent(announcementVO.getContent());
            if (!"".equals(announcementVO.getCreatetime()) && announcementVO.getCreatetime() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = sdf.parse(announcementVO.getCreatetime());
                announcement.setCreatetime(date);
            } else{
                announcement.setCreatetime(new Date());
            }
            announcement.setUpdatetime(new Date());
            announcement.setDepartment(department);
            announcement.setIsshow(announcementVO.isshow);
            announcement.setOrderid(announcementVO.getOrderid());
            announcement.setStatus(announcementVO.status);
            announcement.setTitle(announcementVO.getTitle());
            announcement.setUser(user);
        }
        return announcement;
    }

    public String getAnnouncementid() {
        return announcementid;
    }

    public void setAnnouncementid(String announcementid) {
        this.announcementid = announcementid;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isIsshow() {
        return isshow;
    }

    public void setIsshow(boolean isshow) {
        this.isshow = isshow;
    }
}
