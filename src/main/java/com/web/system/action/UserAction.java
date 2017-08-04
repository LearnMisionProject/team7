package com.web.system.action;

import com.web.base.action.BaseAction;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.UserVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;


@ParentPackage("struts-default")
@Namespace("/system/user")
public class UserAction extends BaseAction{


    private User user;
    private UserVO userVO;
    private String roleIds;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    /**
     * 登陆
     * @throws IOException
     */
    @Action(value = "login")
    public void login() throws IOException {
        if (user == null) {
            printJSONObject(ResultData.buildFailureResult("用户名和密码为空"));
            return;
        }
        //用户名是否为空
        if (user.getUsername() == null) {
            printJSONObject(ResultData.buildFailureResult("用户名为空"));
            return;
        }
        //密码是否为空
        if (user.getPassword() == null) {
            printJSONObject(ResultData.buildFailureResult("密码为空"));
            return;
        }
        //通过用户名查询
        User userResult = userService.userNameCheck(user.getUsername());

        //用户名是否存在
        if (userResult.getUsername() == null) {
            printJSONObject(ResultData.buildFailureResult("用户名不存在"));
            return;
        }

        //密码是否正确
        if (!userResult.getPassword().equals(user.getPassword())) {
            printJSONObject(ResultData.buildFailureResult("密码不正确"));
            return;
        }

        //把用户信息存入到sesion中
        getSession().setAttribute("user", userResult);

        //通过流传到页面
        printJSONObject(ResultData.buildSuccessResult("登录成功"));

    }


    /**
     * 用户管理页面
     * @return
     */
    @Action(value = "UserAction_list", results = {
            @Result(location = "/WEB-INF/content/system/list_user.jsp")
    })
    public String getUserList() {
        return SUCCESS;
    }

    /**
     * 获取用户列表
     * @throws IOException
     */
    @Action(value = "UserAction_findByPage")
    public void getFindByPage() throws IOException {
        Pager pager = userService.getUserListByPage(page, rows);
        printJSONObject(ResultData.buildSuccessResult("列表获取成功", pager));
    }

    /**
     * 跳转到editOrAdd页面
     * @return
     */
    @Action(value = "UserAction_edit", results = {
            @Result(location = "/WEB-INF/content/system/edit_user.jsp")
    })
    public String edit() {
        //查询是否有ID，有ID说明是修改进行查询
        if (!userId.isEmpty() && userId != null) {
            userVO = userService.checkFromId(userId);
        }
        return SUCCESS;
    }

    /**
     * 新增or修改
     */
    @Action(value = "addRoEdit")
    public void addOrEdit() throws IOException {
        User user = (User) getSession().getAttribute("user");
        //做修改操作,判断是否ID为空
        if (!userVO.getId().isEmpty() && userVO.getId() != null) {
            userService.edit(userVO, user);
            printJSONObject(ResultData.buildSuccessResult());
        } else {
            userService.save(userVO, user);
            printJSONObject(ResultData.buildSuccessResult());
        }
    }

    /**
     * 删除
     */
    @Action(value = "UserAction_remove")
    public void del() throws IOException {
        boolean status = userService.deleteByIds(userId);
        if (status) {
            resultData = ResultData.buildSuccessResult("删除成功");
        } else {
            resultData = ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

    /**
     * 跳转到用户分配权限页面
     * @return
     */
    @Action(value = "toAssign", results = {
            @Result(location = "/WEB-INF/content/system/assign_user.jsp")
    })
    public String toAssign() {
        return SUCCESS;
    }


    //更新用户的角色的action
    @Action(value = "UserAction_updateRoles")
    public void assign() throws IOException {
        String[] ids = null;
        if (roleIds != null && roleIds.length() > 0) {
            ids = roleIds.split(",");
        }
        //更新用户的角色信息
        boolean state = userService.updateUserRole(user.getId(), ids);
        if (state) {
            resultData = ResultData.buildSuccessResult("分配角色成功");
        } else {
            resultData = ResultData.buildFailureResult("分配角色失败");
        }
        printJSONObject(resultData);
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }
}
