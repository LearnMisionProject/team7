package com.web.manage.action;

import com.web.base.action.BaseAction;
import com.web.manage.entity.Business;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */

@ParentPackage("struts-default")
@Namespace("/manage/business")
public class BusinessAction extends BaseAction{

    private BusinessVO businessVO;
    private List<CustomerVO> customers;
    private List<UserVO> ownerUsers;
    private List<ContactsVO> businessContactsNames;
    private List<BusinessStatusVO> status;
    private List<DictVO> type;
    private List<DictVO> origins;
    private String searchBy;
    private String searchText;

    @Action(value = "BusinessAction_index" , results = {
            @Result(location = "list_business.jsp")})
    public String list_business(){
        return SUCCESS;
    }

    @Action("BusinessAction_findByPage")
    public  void  findByPage() throws IOException {
        Pager pager = businessService.getBusinessLIst(page,rows,searchBy,searchText);
        resultData = ResultData.buildSuccessResult("列表获取成功", pager);
        printJSONObject(resultData,"contracts","leadses","customers","businessProducts","contracts_1");
    }

    @Action(value = "findBusiness" , results = {
            @Result(location = "see_business.jsp")})
    public String findBusniess(){
        String id = businessVO.getBusinessid();
        businessVO = businessService.getFromBusiness(id);
        return SUCCESS;
    }

    @Action(value = "BusinessAction_edit",results = {
            @Result(location = "edit_business.jsp")
    })
    public String getNewBussiness() {
        return SUCCESS;
    }

    @Action(value = "toModifyBusiness" , results = {
            @Result(location = "edit_business.jsp")
    })
    public String toModifyBusiness(){
        String id = businessVO.getBusinessid();
        businessVO = businessService.getFromBusiness(id);
        customers = businessService.findCustomerAll();
        ownerUsers = businessService.findUserAll();
        businessContactsNames = businessService.findContactsAll();
        status = businessService.findBusinessStatusAll();
        type = businessService.findBusinessTypeAll();
        origins = businessService.findBusinessOriginAll();
        return SUCCESS;
    }

    @Action(value = "toAddBusiness" , results = {
            @Result(location = "edit_business.jsp")
    })
    public String toAddBusiness(){
        customers = businessService.findCustomerAll();
        ownerUsers = businessService.findUserAll();
        businessContactsNames = businessService.findContactsAll();
        status = businessService.findBusinessStatusAll();
        type = businessService.findBusinessTypeAll();
        origins = businessService.findBusinessOriginAll();
        return SUCCESS;
    }

    @Action("BusinessAction_save")
    public void operateBusiness() throws IOException {
        Business business = businessService.fromBusinessVO(businessVO);
        if (business.getBusinessid() != null && business.getBusinessid().length() >0){
            businessService.updateBusiness(business);
        }else{
            businessService.saveBusiness(business);
        }
        resultData = ResultData.buildSuccessResult("操作成功");
        printJSONObject(resultData);
    }

    public BusinessVO getBusinessVO() {
        return businessVO;
    }

    public void setBusinessVO(BusinessVO businessVO) {
        this.businessVO = businessVO;
    }

    public List<CustomerVO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerVO> customers) {
        this.customers = customers;
    }

    public List<UserVO> getOwnerUsers() {
        return ownerUsers;
    }

    public void setOwnerUsers(List<UserVO> ownerUsers) {
        this.ownerUsers = ownerUsers;
    }

    public List<ContactsVO> getBusinessContactsNames() {
        return businessContactsNames;
    }

    public void setBusinessContactsNames(List<ContactsVO> businessContactsNames) {
        this.businessContactsNames = businessContactsNames;
    }

    public List<DictVO> getType() {
        return type;
    }

    public void setType(List<DictVO> type) {
        this.type = type;
    }

    public List<DictVO> getOrigins() {
        return origins;
    }

    public void setOrigins(List<DictVO> origins) {
        this.origins = origins;
    }

    public List<BusinessStatusVO> getStatus() {
        return status;
    }

    public void setStatus(List<BusinessStatusVO> status) {
        this.status = status;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
