package com.web.vo;

import com.web.manage.entity.Contacts;
import com.web.manage.entity.Customer;
import com.web.system.entity.User;
import com.web.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/3.
 */
public class ContactsVO {

    private String contactsid;
    private String customerid; //客户id
    private String customerName; //客户名字
    private Boolean isFirst;
    private String creatoruserId; //创建的用户ID
    private String creatoruserName;
    private String deleteuserId; // 删除的用户ID
    private String deleteuserName;
    private String name;
    private String post;
    private String department;
    private Boolean sex;
    private String saltname;
    private String telephone;
    private String email;
    private String qqno;
    private String address;
    private String zipcode;
    private String description;
    private String createtime;
    private String updatdtime;
    private Boolean isdeleted;
    private String deletetime;

    /**
     * 实体类转vo
     * @param contacts
     * @return
     */
    public static ContactsVO fromContacts(Contacts contacts) {
        ContactsVO contactsVO = null;
        if (contacts != null) {
            contactsVO = new ContactsVO();
            contactsVO.setAddress(contacts.getAddress());
            contactsVO.setContactsid(contacts.getContactsid());
            if (contacts.getCreatetime() != null) {
                contactsVO.setCreatetime(DateUtil.formatDate(contacts.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (contacts.getDeletetime() != null) {
                contactsVO.setDeletetime(DateUtil.formatDate(contacts.getDeletetime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (contacts.getUpdatdtime() != null) {
                contactsVO.setUpdatdtime(DateUtil.formatDate(contacts.getUpdatdtime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (contacts.getUserByCreatoruserid() != null) {
                contactsVO.setCreatoruserId(contacts.getUserByCreatoruserid().getId());
                contactsVO.setCreatoruserName(contacts.getUserByCreatoruserid().getUsername());
            }
            if (contacts.getUserByDeleteuserid() != null) {
                contactsVO.setDeleteuserId(contacts.getUserByDeleteuserid().getId());
                contactsVO.setDeleteuserName(contacts.getUserByDeleteuserid().getUsername());
            }
            if (contacts.getCustomer().getCustomerid() != null) {
                contactsVO.setCustomerid(contacts.getCustomer().getCustomerid());
                contactsVO.setCustomerName(contacts.getCustomer().getName());
            }
            contactsVO.setDepartment(contacts.getDepartment());
            contactsVO.setDescription(contacts.getDescription());
            contactsVO.setEmail(contacts.getEmail());
            contactsVO.setFirst(contacts.getIsFirst());
            contactsVO.setIsdeleted(contacts.getIsdeleted());
            contactsVO.setName(contacts.getName());
            contactsVO.setPost(contacts.getPost());
            contactsVO.setQqno(contacts.getQqno());
            contactsVO.setSaltname(contacts.getSaltname());
            contactsVO.setSex(contacts.getSex());
            contactsVO.setTelephone(contacts.getTelephone());
            contactsVO.setZipcode(contacts.getZipcode());
        }
        return contactsVO;
    }

    /**
     * vo转实体类
     * @param contactsVO
     * @param user
     * @param customer
     * @return
     */
    public static Contacts fromContactsVO(ContactsVO contactsVO, User user, Customer customer) {
        Contacts contacts = null;
        if (contactsVO != null) {
            contacts = new Contacts();
            contacts.setAddress(contactsVO.getAddress());
            contacts.setContactsid(contactsVO.getContactsid());
            if (customer != null) {
                contacts.setCustomer(customer);
            }
            if (contactsVO.getCreatetime() != null && !"".equals(contactsVO.getCreatetime())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = sdf.parse(contactsVO.getCreatetime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                contacts.setCreatetime(date);
            } else {
                contacts.setCreatetime(new Date());
            }
            contacts.setUpdatdtime(new Date());
            if (contactsVO.getDeletetime() != null && !"".equals(contactsVO.getDeletetime())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = sdf.parse(contactsVO.getDeletetime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                contacts.setDeletetime(date);
            } else {
                contacts.setDeletetime(new Date());
            }
            if (user != null) {
                contacts.setUserByDeleteuserid(user);
                contacts.setUserByCreatoruserid(user);
            }
            contacts.setDescription(contactsVO.getDescription());
            contacts.setDepartment(contactsVO.getDepartment());
            contacts.setEmail(contactsVO.getEmail());
            contacts.setIsdeleted(contactsVO.getIsdeleted());
            contacts.setIsFirst(contactsVO.getFirst());
            contacts.setName(contactsVO.getName());
            contacts.setPost(contactsVO.getPost());
            contacts.setQqno(contactsVO.getQqno());
            contacts.setSaltname(contactsVO.getSaltname());
            contacts.setSex(contactsVO.getSex());
            contacts.setTelephone(contactsVO.getTelephone());
            contacts.setZipcode(contactsVO.getZipcode());
        }
        return contacts;
    }

    public String getContactsid() {
        return contactsid;
    }

    public void setContactsid(String contactsid) {
        this.contactsid = contactsid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    public String getCreatoruserId() {
        return creatoruserId;
    }

    public void setCreatoruserId(String creatoruserId) {
        this.creatoruserId = creatoruserId;
    }

    public String getCreatoruserName() {
        return creatoruserName;
    }

    public void setCreatoruserName(String creatoruserName) {
        this.creatoruserName = creatoruserName;
    }

    public String getDeleteuserId() {
        return deleteuserId;
    }

    public void setDeleteuserId(String deleteuserId) {
        this.deleteuserId = deleteuserId;
    }

    public String getDeleteuserName() {
        return deleteuserName;
    }

    public void setDeleteuserName(String deleteuserName) {
        this.deleteuserName = deleteuserName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getSaltname() {
        return saltname;
    }

    public void setSaltname(String saltname) {
        this.saltname = saltname;
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

    public String getQqno() {
        return qqno;
    }

    public void setQqno(String qqno) {
        this.qqno = qqno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatdtime() {
        return updatdtime;
    }

    public void setUpdatdtime(String updatdtime) {
        this.updatdtime = updatdtime;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(String deletetime) {
        this.deletetime = deletetime;
    }
}
