package com.web.vo;

import com.web.manage.entity.Contacts;
import com.web.manage.entity.Customer;
import com.web.manage.entity.Department;
import com.web.manage.entity.Position;

/**
 * Created by Administrator on 2017/7/31.
 */
public class CustomerVO {
    private String customerid;
    private String name;
    private String industry;
    private String rating;
    private String address;
    private String oneruserid;
    private String oneruserName;
    private String createByUser;
    private String createTime;
    private String  updateTime;
    private String origin;
    private String zipcode;
    private String annualrevenue;
    private String ownership;
    private String contactsName;
    private boolean contactsSex;
    private String contactsSaltname;
    private String contactsTelephone;
    private String contactsQQno;
    private String contactsEmail;
    private String contactsAddress;
    private String contactsZipcode;
    private String contactsDescription;
    private String departmentName;
    private String positionName;

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public boolean isContactsSex() {
        return contactsSex;
    }

    public void setContactsSex(boolean contactsSex) {
        this.contactsSex = contactsSex;
    }

    public String getContactsSaltname() {
        return contactsSaltname;
    }

    public void setContactsSaltname(String contactsSaltname) {
        this.contactsSaltname = contactsSaltname;
    }

    public String getContactsTelephone() {
        return contactsTelephone;
    }

    public void setContactsTelephone(String contactsTelephone) {
        this.contactsTelephone = contactsTelephone;
    }

    public String getContactsQQno() {
        return contactsQQno;
    }

    public void setContactsQQno(String contactsQQno) {
        this.contactsQQno = contactsQQno;
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail;
    }

    public String getContactsAddress() {
        return contactsAddress;
    }

    public void setContactsAddress(String contactsAddress) {
        this.contactsAddress = contactsAddress;
    }

    public String getContactsZipcode() {
        return contactsZipcode;
    }

    public void setContactsZipcode(String contactsZipcode) {
        this.contactsZipcode = contactsZipcode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getContactsDescription() {
        return contactsDescription;
    }

    public void setContactsDescription(String contactsDescription) {
        this.contactsDescription = contactsDescription;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getAnnualrevenue() {
        return annualrevenue;
    }

    public void setAnnualrevenue(String annualrevenue) {
        this.annualrevenue = annualrevenue;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOneruserid() {
        return oneruserid;
    }

    public void setOneruserid(String oneruserid) {
        this.oneruserid = oneruserid;
    }

    public String getOneruserName() {
        return oneruserName;
    }

    public void setOneruserName(String oneruserName) {
        this.oneruserName = oneruserName;
    }

    public String getCreateByUser() {
        return createByUser;
    }

    public void setCreateByUser(String createByUser) {
        this.createByUser = createByUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


    public static CustomerVO fromCustomer(Customer customer){
        if(customer!=null) {
            CustomerVO customerVO = new CustomerVO();
            customerVO.setCustomerid(customer.getCustomerid());
            customerVO.setName(customer.getName());
            customerVO.setIndustry(customer.getIndustry());
            customerVO.setRating(customer.getRating());
            customerVO.setAddress(customer.getAddress());
            customerVO.setOrigin(customer.getOrigin());
            customerVO.setZipcode(customer.getZipcode());
            customerVO.setAnnualrevenue(customer.getAnnualrevenue());
            customerVO.setOwnership(customer.getOwnership());
            if(customer.getCreatetime()!=null) {
                customerVO.setCreateTime(customer.getCreatetime().toString());
            }
            if(customer.getUpdatetime()!=null) {
                customerVO.setUpdateTime(customer.getUpdatetime().toString());
            }
            if(customer.getUserByCreatoruserid()!=null) {
                customerVO.setCreateByUser(customer.getUserByCreatoruserid().getUsername());
            }
            if(customer.getUserByOwneruserid()!=null) {
                customerVO.setOneruserName(customer.getUserByOwneruserid().getUsername());
                customerVO.setOneruserid(customer.getUserByOwneruserid().getId());
            }
            return customerVO;
        }
        return null;
    }

    /**
     * 客户需要字段
     * @param customer
     * @param contacts
     * @param department
     * @param position
     * @return
     */
    public static CustomerVO fromCustomer(Customer customer, Contacts contacts, Department department, Position position){
        if(customer!=null) {
            CustomerVO customerVO = new CustomerVO();
            customerVO.setCustomerid(customer.getCustomerid());
            customerVO.setName(customer.getName());
            customerVO.setIndustry(customer.getIndustry());
            customerVO.setRating(customer.getRating());
            customerVO.setAddress(customer.getAddress());
            customerVO.setOrigin(customer.getOrigin());
            customerVO.setZipcode(customer.getZipcode());
            customerVO.setAnnualrevenue(customer.getAnnualrevenue());
            customerVO.setOwnership(customer.getOwnership());
            if(customer.getCreatetime()!=null) {
                customerVO.setCreateTime(customer.getCreatetime().toString());
            }
            if(customer.getUpdatetime()!=null) {
                customerVO.setUpdateTime(customer.getUpdatetime().toString());
            }
            if(customer.getUserByCreatoruserid()!=null) {
                customerVO.setCreateByUser(customer.getUserByCreatoruserid().getUsername());
            }
            if(customer.getUserByOwneruserid()!=null) {
                customerVO.setOneruserName(customer.getUserByOwneruserid().getUsername());
                customerVO.setOneruserid(customer.getUserByOwneruserid().getId());
            }
            if (contacts != null) {
                customerVO.setContactsName(contacts.getName());
                customerVO.setContactsSex(contacts.getSex());
                customerVO.setContactsSaltname(contacts.getSaltname());
                customerVO.setContactsTelephone(contacts.getTelephone());
                customerVO.setContactsQQno(contacts.getQqno());
                customerVO.setContactsEmail(contacts.getEmail());
                customerVO.setContactsAddress(contacts.getAddress());
                customerVO.setContactsZipcode(contacts.getZipcode());
                customerVO.setContactsDescription(contacts.getDescription());
            }
            if (department != null) {
                customerVO.setDepartmentName(department.getName());
            }
            if (position != null) {
                customerVO.setPositionName(position.getName());
            }
            return customerVO;
        }
        return null;
    }
}
