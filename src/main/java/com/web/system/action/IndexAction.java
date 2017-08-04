package com.web.system.action;

import com.web.base.action.BaseAction;
import com.web.system.entity.User;
import com.web.system.service.IndexService;
import com.web.util.ResultData;
import com.web.vo.IndexVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
@ParentPackage("struts-default")
@Namespace("/system/index")
public class IndexAction extends BaseAction{

    @Resource
    private IndexService indexService;

    /**
     * 转向登录后的主页面
     * @return
     */
    @Action(value = "index", results = {
            @Result(location = "/WEB-INF/content/index.jsp")
    })
    public String index() {
        return SUCCESS;
    }

    @Action(value = "indexList")
    public void IndexList() throws IOException {
        User user = (User) getSession().getAttribute("user");
        List<IndexVO> indexVOList = indexService.getIndex(user);
        resultData = ResultData.buildSuccessResult("权限集合", indexVOList);
        printJSONObject(resultData);
    }

    /**
     * 注销
     * @return
     */
    @Action(value = "logout", results = {
            @Result(location = "/login.jsp")
    })
    public String logout() {
        getSession().invalidate();
        return SUCCESS;
    }




}
