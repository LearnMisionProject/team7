package com.web.system.action;


import com.web.base.action.BaseAction;
import com.web.system.entity.Function;
import com.web.system.entity.User;
import com.web.system.service.FunctionVOService;
import com.web.util.ResultData;
import com.web.vo.FunctionVO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@ParentPackage("struts-default")
@Namespace("/system/function")
public class FunctionAction extends BaseAction{

    @Resource
    private FunctionVOService functionVOService;

    private List<Function> list;
    private String funcIds;

    private FunctionVO functionVO;

    /**
     * 跳转到角色分配权限页面
     * @return
     */
    @Action(value = "RoleAction_assign", results = {
            @Result(location = "/WEB-INF/content/system/assign_role.jsp")
    })
    public String assign() {
            return SUCCESS;
            }

    /**
     * 点击权限页面时获取权限列表
     */
    @Action(value = "FunctionActionFindByRoleIds", results = {
            @Result(location = "/WEB-INF/content/system/assign_role.jsp")
    })
    public String findByRole() {
            return  SUCCESS;
    }

    /**
     * 加载分配权限
     */
    @Action(value = "FunctionAction_findAll")
    public void findAll() throws IOException {
            List<FunctionVO> functionVOList = functionService.getAssignlistAll();
            resultData = ResultData.buildSuccessResult("获取列表", functionVOList);
            printJSONObject(resultData);
    }

    /**
     *分配权限页面选中,所选择的角色对应的权限
     */
    @Action(value = "FunctionAction_findByRoleIds")
    public void findByRoleIds() throws IOException {
            List<Function> functionList = functionService.getAssignList(roleId);
            resultData = ResultData.buildSuccessResult("获取列表", functionList);
            printJSONObject(resultData, "userByUpdateby", "userByCreateby", "roles", "functions", "function");
            }

    /**
     * 修改分配权限
     * @return
     */
    @Action(value = "editRoleAssign")
    public void editRoleAssign() throws IOException {
        String[] ids = null;
        if (funcIds != null && funcIds.length() > 0) {
            ids = funcIds.split(",");
        }

        boolean status = roleService.updateFunction(roleId, ids);

        if (status) {
            resultData = ResultData.buildSuccessResult("分配权限成功");
        } else {
            resultData = ResultData.buildFailureResult("分配权限失败");
        }
        printJSONObject(resultData);
    }

    @Action( value = "functionList" , results = {
            @Result(location = "list_function.jsp")
    })
    public String functionList(){
        return SUCCESS;
    }

    @Action( value = "list")
    public void getlist() throws IOException {
        User user = (User)getSession().getAttribute("user");
        List<FunctionVO> functionVos = functionVOService.getFunctionListVO(user);
        resultData = ResultData.buildSuccessResult("获取菜单成功", functionVos);
        printJSONObject(resultData,"iconclass","iconurl");
    }

    @Action(value = "toAddFunction" , results = {
            @Result(location = "edit_function.jsp")
    })
    public String toAddFunction(){
        if (funcIds != null && !funcIds.isEmpty()){
        functionVO = functionService.getOne(funcIds);
        }
        list = functionService.getAllFunction();
        return SUCCESS;
    }


    @Action("operateFunction")
    public void addFunction() throws IOException {
        Function function = functionService.saveFunction(functionVO);
        if (function.getId() != null && !function.getId().isEmpty()){
            functionService.updateFunction(function);
        }else{
            functionService.saveFunction(function);
        }
        resultData = ResultData.buildSuccessResult("操作成功");
        printJSONObject(resultData);
    }

    @Action("deleteFunction")
    public void deleteFuction() throws IOException {
        String[] idList = funcIds.split(",");
        for (String id : idList){
            functionService.deleteFunction(id);
        }
        resultData = ResultData.buildSuccessResult("操作成功");
        printJSONObject(resultData);
    }

    public String getFuncIds() {
        return funcIds;
    }

    public void setFuncIds(String funcIds) {
        this.funcIds = funcIds;
    }

    public FunctionVO getFunctionVO() {
        return functionVO;
    }

    public void setFunctionVO(FunctionVO functionVO) {
        this.functionVO = functionVO;
    }

    public List<Function> getList() {
        return list;
    }

    public void setList(List<Function> list) {
        this.list = list;
    }
}
