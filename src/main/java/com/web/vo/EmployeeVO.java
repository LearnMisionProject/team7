package com.web.vo;

import com.web.manage.entity.Employee;

/**
 * Created by Administrator on 2017/7/26.
 */
public class EmployeeVO {

    private String empid;
    private String  name;
    private String telephone;
    private String email;
    private String address;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 把Employee对象封装到VO中
     */
    public static EmployeeVO fromEmployee(Employee employee) {
        if(employee!=null) {
            EmployeeVO employeeVO = new EmployeeVO();
            employeeVO.setEmpid(employee.getEmpid());
            employeeVO.setName(employee.getName());
            employeeVO.setAddress(employee.getAddress());
            employeeVO.setTelephone(employee.getTelephone());
            employeeVO.setEmail(employee.getEmail());
            return  employeeVO;
        }
        return null;
    }


}
