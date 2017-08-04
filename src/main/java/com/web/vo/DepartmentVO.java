package com.web.vo;

;import com.web.manage.entity.Department;

/**
 * Created by Administrator on 2017/7/27.
 */
public class DepartmentVO {
    private String departmentid;
    private Department department;
    private String name;
    private String description;

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public static DepartmentVO fromDepartment(Department department){
        if (department != null ){
            DepartmentVO departmentVO = new DepartmentVO();
            departmentVO.setDepartmentid(department.getDepartmentid());
            departmentVO.setDepartment(department.getDepartment());
            departmentVO.setName(department.getName());
            departmentVO.setDescription(department.getDescription());
            return departmentVO;
        }

        return null;
    }
}
