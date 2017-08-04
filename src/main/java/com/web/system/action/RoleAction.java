package com.web.system.action;

import com.web.base.action.BaseAction;
import com.web.system.entity.Role;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.RoleVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;
import java.util.List;

@ParentPackage("struts-default")
@Namespace("/system/role")
public class RoleAction extends BaseAction {

    private RoleVO roleVO;


    @Action(value = "RoleAction_list", results = {
            @Result(location = "/WEB-INF/content/system/list_role.jsp")
    })
    public String RoleList() {
        return SUCCESS;
    }

    /**
     * 获取角色列表
     * @throws IOException
     */
    @Action(value = "RoleAction_findByPage")
    public void FindByPage() throws IOException {
        Pager pager = roleService.getRoleList(page, rows);
        resultData = ResultData.buildSuccessResult("列表获取成功", pager);
        printJSONObject(resultData);
    }

    /**
     * 跳转到角色添加页面
     * @return
     */
    @Action(value = "RoleAction_edit", results = {
            @Result(location = "/WEB-INF/content/system/edit_role.jsp")
    })
    public String toEdit() throws IOException {
        //查询是否有ID，有ID说明是修改进行查询
        if (!roleId.isEmpty() && roleId != null) {
            roleVO = roleService.checkFromId(roleId);
        }
        return SUCCESS;
    }

    /**
     * 添加or修改角色
     * @return
     */
    @Action(value = "addRoEdit")
    public void add() throws IOException {
        User user = (User) getSession().getAttribute("user");
        //做修改操作,判断是否ID为空
        if (!roleVO.getId().isEmpty() && roleVO.getId() != null) {
            roleService.edit(roleVO, user);
            printJSONObject(ResultData.buildSuccessResult(),"functions", "users");
        } else {
            roleService.save(roleVO, user);
            printJSONObject(ResultData.buildSuccessResult(),"functions", "users");
        }
    }

    /**
     * 删除
     */
    @Action(value = "RoleAction_remove")
    public void del() throws IOException {
        boolean status = roleService.deleteByIds(roleId);
        if (status) {
            resultData = ResultData.buildSuccessResult("删除成功");
        } else {
            resultData = ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }


    /**
     * 查询所有角色
     */
    @Action("RoleAction_findAll")
    public void findAll() throws IOException {
        List<Role> roleList = roleService.getAll();
        resultData = ResultData.buildSuccessResult("请求数据成功",roleList);
        printJSONObject(resultData, new String[]{"userByUpdateby", "userByCreateby", "functions", "users"});
    }


    /**
     * 根据用户id查询其角色
     */
    @Action("RoleAction_findByUserId")
    public void findRolesByUserId() throws IOException {
        List<Role> roleList = roleService.getRolesByUserId(userId);
        resultData = ResultData.buildSuccessResult("请求数据成功", roleList);
        printJSONObject(resultData, new String[]{"userByUpdateby", "userByCreateby", "functions", "users"});
    }

    public RoleVO getRoleVO() {
        return roleVO;
    }

    public void setRoleVO(RoleVO roleVO) {
        this.roleVO = roleVO;
    }
}
