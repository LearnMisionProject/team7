package com.web.manage.action;

import com.web.base.action.BaseAction;
import com.web.manage.entity.Department;
import com.web.manage.service.AnnouncementService;
import com.web.manage.service.DepartmentSerivce;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.AnnouncementVO;
import org.apache.struts2.convention.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@ParentPackage("struts-default")
@Namespace("/manage/announcement")
public class AnnouncementAction extends BaseAction {

    @Resource
    private AnnouncementService announcementService;
    @Resource
    private DepartmentSerivce departmentSerivce;

    private List<Department> departmentList;
    private AnnouncementVO announcementVO;
    private String announcementid;
    private String departmentid;
    private String title;

    /**
     * 跳转到公告页面
     * @return
     */
    @Action(value = "AnnouncementAction_list", results = {
            @Result(location = "list_announcement.jsp")
    })
    public String toIndex() {
        return SUCCESS;
    }

    /**
     * 分页查询
     * @throws IOException
     */
    @Action("AnnouncementAction_findByPage")
    public void annoList() throws IOException {
        if (departmentid == null) {
            departmentid = "";
        }
        if (title == null) {
            title = "";
        }
        Pager pager = announcementService.listByPage(page, rows, departmentid, title);
        resultData = ResultData.buildSuccessResult("获取列表", pager);
        printJSONObject(resultData);
    }

    /**
     * 转到新增or修改
     * @return
     */
    @Action(value = "AnnouncementAction_edit", results = {
            @Result(location = "edit_announcement.jsp")
    })
    public String toAddOrEdit() {
        departmentList = departmentSerivce.getAllList();
        if (announcementid != null && !"".equals(announcementid)) {
            announcementVO = announcementService.getIdToAnnouncementVO(announcementid);
        }
        return SUCCESS;
    }

    /**
     * 新增or修改
     */
    @Action("addOrEdit")
    public void addOrEdit() throws IOException, ParseException {
        User user = (User) getSession().getAttribute("user");
        Department department = departmentSerivce.getFromId(announcementVO.getDepartmentId());
        if (announcementVO.getAnnouncementid() != null && !"".equals(announcementVO.getAnnouncementid())) {
            announcementService.toEdit(announcementVO, user, department);
        } else {
            announcementService.toSave(announcementVO, user, department);
        }
        printJSONObject(ResultData.buildSuccessResult());
    }

    /**
     * 删除
     */
    @Action("AnnouncementAction_remove")
    public void del() throws IOException {
        boolean status = announcementService.deleteByIds(announcementid);
        if (status) {
            resultData = ResultData.buildSuccessResult("删除成功");
        } else {
            resultData = ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

    public AnnouncementService getAnnouncementService() {
        return announcementService;
    }

    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    public AnnouncementVO getAnnouncementVO() {
        return announcementVO;
    }

    public void setAnnouncementVO(AnnouncementVO announcementVO) {
        this.announcementVO = announcementVO;
    }

    public String getAnnouncementid() {
        return announcementid;
    }

    public void setAnnouncementid(String announcementid) {
        this.announcementid = announcementid;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
