package com.web.vo;

import com.web.manage.entity.*;
import com.web.util.DateUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/2.
 */
public class BusinessVO {

    private String businessid;
    private String userByCreatoruserId;
    private String userByCreatoruserName;
    private String businessStatusId;
    private String businessStatusName;
    private String userByUpdateuserId;
    private String userByUpdateuserName;
    private String businessContactsId;
    private String businessContactsName;
    private String userByOwneruserId;
    private String userByOwneruserName;
    private String customerId;
    private String customerName;
    private String userByDeleteuserId;
    private String userByDeleteuserName;
    private String name;
    private String origin;//信息来源
    private String type;//商机类型
    private Integer estimateprice;//预计成交价
    private Short gainrate;//赢单率
    private Integer totalamount;
    private Double subtotalval;
    private Double discountprice;
    private Double salesprice;//商机金额，售价
    private String duedate;
    private String createtime;
    private String updatetime;
    private Double totalprice;
    private String nextstep;//下次联系内容
    private String nextsteptime;//下次联系时间
    private Byte isdeleted;
    private String deletetime;
    private String contractaddress;
    private String description;
    private Set<Contract> contracts = new HashSet<Contract>(0);
    private Set<Leads> leadses = new HashSet<Leads>(0);
    private Set<Customer> customers = new HashSet<Customer>(0);
    private Set<BusinessProduct> businessProducts = new HashSet<BusinessProduct>(0);
    private Set<Contract> contracts_1 = new HashSet<Contract>(0);

    public static BusinessVO fromBusiness(Business business){
        if (business != null){
            BusinessVO businessVO = new BusinessVO();
            businessVO.setBusinessid(business.getBusinessid());
            if (business.getUserByCreatoruserid() != null){
            businessVO.setUserByCreatoruserId(business.getUserByCreatoruserid().getId());
            businessVO.setUserByCreatoruserName(business.getUserByCreatoruserid().getUsername());
            }else{
            businessVO.setUserByCreatoruserId(null);
            businessVO.setUserByCreatoruserName(null);
            }
            if (business.getBusinessStatus() != null){
                businessVO.setBusinessStatusId(business.getBusinessStatus().getStatusid());
                businessVO.setBusinessStatusName(business.getBusinessStatus().getName());
            }else{
                businessVO.setBusinessStatusId(null);
                businessVO.setBusinessStatusName(null);
            }
            if (business.getUserByUpdateuserid() != null){
                businessVO.setUserByUpdateuserId(business.getUserByUpdateuserid().getId());
                businessVO.setUserByUpdateuserName(business.getUserByUpdateuserid().getUsername());
            }else{
                businessVO.setUserByUpdateuserId(null);
                businessVO.setUserByUpdateuserName(null);
            }
            if (business.getBusinessContacts() != null){
                businessVO.setBusinessContactsId(business.getBusinessContacts().getContactsid());
                businessVO.setBusinessContactsName(business.getBusinessContacts().getName());
            }else{
                businessVO.setBusinessContactsId(null);
                businessVO.setBusinessContactsName(null);
            }
            if (business.getUserByOwneruserid() != null){
                businessVO.setUserByOwneruserId(business.getUserByOwneruserid().getId());
                businessVO.setUserByOwneruserName(business.getUserByOwneruserid().getUsername());
            }else{
                businessVO.setUserByOwneruserId(null);
                businessVO.setUserByOwneruserName(null);
            }
            if (business.getCustomer() !=null){
                businessVO.setCustomerId(business.getCustomer().getCustomerid());
                businessVO.setCustomerName(business.getCustomer().getName());
            }else{
                businessVO.setCustomerId(null);
                businessVO.setCustomerName(null);
            }
            if (business.getUserByDeleteuserid() != null){
                businessVO.setUserByDeleteuserId(business.getUserByDeleteuserid().getId());
                businessVO.setUserByDeleteuserName(business.getUserByDeleteuserid().getUsername());
            }else{
                businessVO.setUserByDeleteuserId(null);
                businessVO.setUserByDeleteuserName(null);
            }
            businessVO.setName(business.getName());
            businessVO.setOrigin(business.getOrigin());
            businessVO.setType(business.getType());
            businessVO.setEstimateprice(business.getEstimateprice());
            businessVO.setGainrate(business.getGainrate());
            businessVO.setTotalamount(business.getTotalamount());
            businessVO.setSubtotalval(business.getSubtotalval());
            businessVO.setDiscountprice(business.getDiscountprice());
            businessVO.setSalesprice(business.getSalesprice());
            businessVO.setDuedate(business.getDuedate());
            businessVO.setCreatetime(DateUtil.formatDate(business.getCreatetime(),"yyyy-MM-dd HH-mm-ss"));
            businessVO.setUpdatetime(DateUtil.formatDate(business.getUpdatetime(),"yyyy-MM-dd HH-mm-ss"));
            businessVO.setTotalprice(business.getTotalprice());
            businessVO.setNextstep(business.getNextstep());
            businessVO.setNextsteptime(DateUtil.formatDate(business.getNextsteptime(),"yyyy-MM-dd HH-mm-ss"));
            businessVO.setIsdeleted(business.getIsdeleted());
            businessVO.setDeletetime(DateUtil.formatDate(business.getDeletetime(),"yyyy-MM-dd HH-mm-ss"));
            businessVO.setContractaddress(business.getContractaddress());
            businessVO.setDescription(business.getDescription());
            businessVO.setContracts(business.getContracts());
            businessVO.setLeadses(business.getLeadses());
            businessVO.setCustomers(business.getCustomers());
            businessVO.setBusinessProducts(business.getBusinessProducts());
            businessVO.setContracts_1(business.getContracts_1());
            return businessVO;
        }
        return null;
    }

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid;
    }

    public String getUserByCreatoruserId() {
        return userByCreatoruserId;
    }

    public void setUserByCreatoruserId(String userByCreatoruserId) {
        this.userByCreatoruserId = userByCreatoruserId;
    }

    public String getUserByCreatoruserName() {
        return userByCreatoruserName;
    }

    public void setUserByCreatoruserName(String userByCreatoruserName) {
        this.userByCreatoruserName = userByCreatoruserName;
    }

    public String getBusinessStatusId() {
        return businessStatusId;
    }

    public void setBusinessStatusId(String businessStatusId) {
        this.businessStatusId = businessStatusId;
    }

    public String getBusinessStatusName() {
        return businessStatusName;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }

    public String getUserByUpdateuserId() {
        return userByUpdateuserId;
    }

    public void setUserByUpdateuserId(String userByUpdateuserId) {
        this.userByUpdateuserId = userByUpdateuserId;
    }

    public String getUserByUpdateuserName() {
        return userByUpdateuserName;
    }

    public void setUserByUpdateuserName(String userByUpdateuserName) {
        this.userByUpdateuserName = userByUpdateuserName;
    }

    public String getBusinessContactsId() {
        return businessContactsId;
    }

    public void setBusinessContactsId(String businessContactsId) {
        this.businessContactsId = businessContactsId;
    }

    public String getBusinessContactsName() {
        return businessContactsName;
    }

    public void setBusinessContactsName(String businessContactsName) {
        this.businessContactsName = businessContactsName;
    }

    public String getUserByOwneruserId() {
        return userByOwneruserId;
    }

    public void setUserByOwneruserId(String userByOwneruserId) {
        this.userByOwneruserId = userByOwneruserId;
    }

    public String getUserByOwneruserName() {
        return userByOwneruserName;
    }

    public void setUserByOwneruserName(String userByOwneruserName) {
        this.userByOwneruserName = userByOwneruserName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getUserByDeleteuserId() {
        return userByDeleteuserId;
    }

    public void setUserByDeleteuserId(String userByDeleteuserId) {
        this.userByDeleteuserId = userByDeleteuserId;
    }

    public String getUserByDeleteuserName() {
        return userByDeleteuserName;
    }

    public void setUserByDeleteuserName(String userByDeleteuserName) {
        this.userByDeleteuserName = userByDeleteuserName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEstimateprice() {
        return estimateprice;
    }

    public void setEstimateprice(Integer estimateprice) {
        this.estimateprice = estimateprice;
    }

    public Short getGainrate() {
        return gainrate;
    }

    public void setGainrate(Short gainrate) {
        this.gainrate = gainrate;
    }

    public Integer getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Integer totalamount) {
        this.totalamount = totalamount;
    }

    public Double getSubtotalval() {
        return subtotalval;
    }

    public void setSubtotalval(Double subtotalval) {
        this.subtotalval = subtotalval;
    }

    public Double getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(Double discountprice) {
        this.discountprice = discountprice;
    }

    public Double getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(Double salesprice) {
        this.salesprice = salesprice;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getNextstep() {
        return nextstep;
    }

    public void setNextstep(String nextstep) {
        this.nextstep = nextstep;
    }

    public String getNextsteptime() {
        return nextsteptime;
    }

    public void setNextsteptime(String nextsteptime) {
        this.nextsteptime = nextsteptime;
    }

    public Byte getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Byte isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(String deletetime) {
        this.deletetime = deletetime;
    }

    public String getContractaddress() {
        return contractaddress;
    }

    public void setContractaddress(String contractaddress) {
        this.contractaddress = contractaddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public Set<Leads> getLeadses() {
        return leadses;
    }

    public void setLeadses(Set<Leads> leadses) {
        this.leadses = leadses;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<BusinessProduct> getBusinessProducts() {
        return businessProducts;
    }

    public void setBusinessProducts(Set<BusinessProduct> businessProducts) {
        this.businessProducts = businessProducts;
    }

    public Set<Contract> getContracts_1() {
        return contracts_1;
    }

    public void setContracts_1(Set<Contract> contracts_1) {
        this.contracts_1 = contracts_1;
    }
}
