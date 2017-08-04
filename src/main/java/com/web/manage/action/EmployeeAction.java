package com.web.manage.action;

import com.web.base.action.BaseAction;
import com.web.manage.entity.Employee;
import com.web.manage.service.EmployeeService;
import com.web.util.Pager;
import com.web.util.ResultData;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/26.
 */
@ParentPackage("json-default")
@Namespace("/manage/employee")
public class EmployeeAction extends BaseAction {
    @Autowired
    private EmployeeService employeeService;

    private String name;

    private String empid;

    private Employee employee;

@Action(value = "EmployeeAction_list",results ={
            @Result(location = "list_employee.jsp")
})
    public String employeeManage() {
        return SUCCESS;
    }

    /**
     * 分页和查询
     * @throws IOException
     */
    @Action(value = "EmployeeAction_findByPage")
    public  void findByPage() throws IOException {
        if(name==null){
            name="";
        }
        Pager pager =employeeService.getEmployeeListByPage(page,rows,name);
        resultData = ResultData.buildSuccessResult("获取列表成功",pager);
        printJSONObject(resultData);
    }

    @Action(value = "EmployeeAction_add",results = {
            @Result(name = "success",
                  location = "add_employee.jsp"
           )
    })
        public String add() {
            return SUCCESS;
        }


        @Action(value = "Employee_save")
        public void save() throws IOException {
        employeeService.save(employee);
            resultData = ResultData.buildSuccessResult("保存成功");
            printJSONObject(resultData);
        }


        @Action(value = "EmployeeAction_edit",results = {
                @Result(name = "success",location = "edit_employee.jsp")
        })
        public  String edit() {
            HttpServletRequest request = ServletActionContext.getRequest();
            String id =request.getParameter("id");
            employee = employeeService.get(id);
            return  SUCCESS;
        }

        @Action(value = "Employee_yiedit")
        public void yiedit() throws IOException {
            employeeService.update(employee);
            resultData = ResultData.buildSuccessResult("修改成功");
            printJSONObject(resultData);
        }


    /**
     * 删除的action
     * @throws IOException
     */

    @Action(value = "EmployeeAction_remove",results = {
            @Result(name = "success",type = "json",params = {
                    "root","ResultData"
            })
    })
    public  void deleteEmployee() throws IOException {
            employeeService.delete(empid);
            resultData = ResultData.buildSuccessResult("删除成功");
            printJSONObject(resultData);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
