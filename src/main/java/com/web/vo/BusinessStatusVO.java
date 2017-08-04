package com.web.vo;


import com.web.manage.entity.BusinessStatus;

/**
 * Created by Administrator on 2017/8/3.
 */
public class BusinessStatusVO {

    private String statusid;
    private String name;
    private Integer orderid;
    private Boolean isend;
    private String description;

    public static BusinessStatusVO fromBusinessStatus(BusinessStatus businessStatus){
        if (businessStatus != null){
            BusinessStatusVO businessStatusVO = new BusinessStatusVO();
            businessStatusVO.setStatusid(businessStatus.getStatusid());
            businessStatusVO.setName(businessStatus.getName());
            businessStatusVO.setOrderid(businessStatus.getOrderid());
            businessStatusVO.setIsend(businessStatus.getIsend());
            businessStatusVO.setDescription(businessStatus.getDescription());
            return businessStatusVO;
        }
        return null;
    }


    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Boolean getIsend() {
        return isend;
    }

    public void setIsend(Boolean isend) {
        this.isend = isend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
