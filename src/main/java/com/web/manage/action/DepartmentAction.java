package com.web.manage.action;

import com.web.base.action.BaseAction;
import com.web.manage.service.DepartmentSerivce;
import com.web.util.Pager;
import com.web.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/26.
 */
@ParentPackage("struts-default")
@Namespace("/manage/position")
public class DepartmentAction extends BaseAction{
    @Autowired
    private DepartmentSerivce departmentSerivce;



    @Action(value = "DepartmentAction_list",results = {
            @Result(location = "list_dept.jsp")
    })
    public String departmentManage(){
        return SUCCESS;
    }
    @Action(value = "DepartmentAction_findByPage")
    public void findByPage() throws IOException {
        Pager pager = departmentSerivce.getDepartmentListByPage(page,rows);
        resultData = ResultData.buildSuccessResult("获取列表成功",pager);
        printJSONObject(resultData, "positions", "announcements", "departments");
    }

}
