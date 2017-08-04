package com.web.base.action;

import com.opensymphony.xwork2.ActionSupport;
import com.web.manage.service.BusinessService;
import com.web.system.service.*;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.DictTypeVO;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lx on 2017/7/24.
 */
public class BaseAction extends ActionSupport {

    protected Pager pager;
    protected ResultData resultData;

    @Resource
    protected UserService userService;
    @Resource
    protected RoleService roleService;
    @Resource
    protected FunctionService functionService;
    @Resource
    protected DictService dictService;
    @Resource
    protected DictTypeService dictTypeService;
    @Resource
    protected BusinessService businessService;


    protected String roleId = "";
    protected String userId = "";
    protected String[] ids;
    protected DictTypeVO dictTypeVO;
    protected Integer page;
    protected Integer rows;


    public DictTypeVO getDictTypeVO() {
        return dictTypeVO;
    }

    public void setDictTypeVO(DictTypeVO dictTypeVO) {
        this.dictTypeVO = dictTypeVO;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * 获取session
     * @return
     */
    public HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }

    /**
     * 把对象转换为json格式并且输出至客户端
     * @param obj
     * @throws IOException
     */
    protected void printJSONObject(Object obj) throws IOException{
        printJSONObject(obj, new String[]{});
    }

    /**
     * 将对象转换为json格式并且输出至客户端
     * @param obj
     * @param excludeProperties -将会被配置属性
     * @throws IOException
     */
    protected void printJSONObject(Object obj, String... excludeProperties) throws IOException{
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();

        JsonConfig config = new JsonConfig();
        config.setExcludes(excludeProperties);

        JSONObject json = JSONObject.fromObject(obj, config);

        out.print(json.toString());
        out.flush();
    }
}
