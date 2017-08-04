package com.web.manage.entity;
// default package


import com.web.system.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Contract entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="TB_CRM_CONTRACT"
    ,schema="teamproject"
, uniqueConstraints = @UniqueConstraint(columnNames="CONTRACTNUMBER")
)

public class Contract  implements java.io.Serializable {


    // Fields    

     private String contractid;//编号（主键）
     private Business business;//商机
     private String contractnumber;//合同编号(not null)
     private Double price;  //总价
     private Date duetime;  //签约日期
     private User ownerUser;    // 负责人
     private User createUser;   //创建人
     private byte[] contractcontent;  //合同内容
     private String description;    //描述
     private Date createtime;   //创建时间(not null)
     private Date updatetime;   //更新时间(not null)
     private Date startdate;    //起始时间
     private Date enddate;      //结束时间
     private String status;     //状态
     private Boolean isdeleted; //是否被删除
     private User deleteUser;   //删除人

     private Date  deletetime;//删除时间

     private Set<Business> businesses = new HashSet<Business>(0);


    // Constructors

    /** default constructor */
    public Contract() {
    }

    
    /** full constructor */


   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="CONTRACTID", unique=true, nullable=false, length=32)

    public String getContractid() {
        return this.contractid;
    }
    
    public void setContractid(String contractid) {
        this.contractid = contractid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="BUSINESSID")

    public Business getBusiness() {
        return this.business;
    }
    
    public void setBusiness(Business business) {
        this.business = business;
    }
    
    @Column(name="CONTRACTNUMBER", unique=true, length=50)

    public String getContractnumber() {
        return this.contractnumber;
    }
    
    public void setContractnumber(String contractnumber) {
        this.contractnumber = contractnumber;
    }
    
    @Column(name="PRICE", precision=10)

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    @Column(name="DUETIME")

    public Date getDuetime() {
        return this.duetime;
    }
    
    public void setDuetime(Date duetime) {
        this.duetime = duetime;
    }
    
    
    @Lob
    @Column(name="CONTRACTCONTENT")

    public byte[] getContractcontent() {
        return this.contractcontent;
    }
    
    public void setContractcontent(byte[] contractcontent) {
        this.contractcontent = contractcontent;
    }
    
    @Column(name="DESCRIPTION", length=500)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="CREATETIME")

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    @Column(name="UPDATETIME")

    public Date getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    
    @Column(name="STARTDATE")

    public Date getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
    
    @Column(name="ENDDATE")

    public Date getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    
    @Column(name="STATUS", length=20)

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="ISDELETED", precision=1, scale=0)

    public Boolean getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
    
    @Column(name="DELETETIME")

    public Date getDeletetime() {
        return this.deletetime;
    }
    
    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }
@ManyToMany()
    @JoinTable(name="TB_CRM_R_BUSINESS_CONTRACT", schema="teamproject", joinColumns = {
        @JoinColumn(name="CONTRACTID", updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="BUSINESSID", updatable=false) })

    public Set<Business> getBusinesses() {
        return this.businesses;
    }
    
    public void setBusinesses(Set<Business> businesses) {
        this.businesses = businesses;
    }
	
	
    @ManyToOne(fetch=FetchType.LAZY)
 	@JoinColumn(name="OWNERUSERID")
	public User getOwnerUser() {
		return ownerUser;
	}
	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}
    @ManyToOne(fetch=FetchType.LAZY)
 	@JoinColumn(name="CREATORUSERID")
	public User getCreateUser() {
		return createUser;
	}
    public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
    @ManyToOne(fetch=FetchType.LAZY)
 	@JoinColumn(name="DELETEUSERID")
	public User getDeleteUser() {
		return deleteUser;
	}
	public void setDeleteUser(User deleteUser) {
		this.deleteUser = deleteUser;
	}
    
    

    







}