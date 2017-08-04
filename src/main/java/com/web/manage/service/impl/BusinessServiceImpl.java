package com.web.manage.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.manage.dao.BusinessDao;
import com.web.manage.dao.BusinessStatusDao;
import com.web.manage.dao.ContactsDao;
import com.web.manage.dao.CustomerDao;
import com.web.manage.entity.Business;
import com.web.manage.entity.BusinessStatus;
import com.web.manage.entity.Contacts;
import com.web.manage.entity.Customer;
import com.web.manage.service.BusinessService;
import com.web.system.dao.DictDao;
import com.web.system.dao.UserDao;
import com.web.system.entity.Dict;
import com.web.system.entity.User;
import com.web.util.DateUtil;
import com.web.util.Pager;
import com.web.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Service
public class BusinessServiceImpl extends BaseServiceImpl<Business , String>  implements BusinessService{

    @Resource
    private BusinessDao businessDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ContactsDao contactsDao;
    @Autowired
    private DictDao dictDao;
    @Autowired
    private BusinessStatusDao businessStatusDao;

    @Autowired
    public void setBusinessDao(BusinessDao businessDao) {
        super.setBaseDao(businessDao);
    }

    @Override
    public Pager getBusinessLIst(Integer pageNumber , Integer pageSize , String searchBy , String searchText) {
        List<Business> businesses = businessDao.getRoleListByPage(pageNumber , pageSize , searchBy , searchText);
        List<BusinessVO> businessVOS = new ArrayList<BusinessVO>();
        for (Business business : businesses) {
            BusinessVO businessVO = BusinessVO.fromBusiness(business);
            businessVOS.add(businessVO);
        }
        Integer count = businessDao.getSize(searchBy,searchText);
        Pager pager = new Pager();
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(count);
        pager.setTotalPage(pager.getTotalPage());
        pager.setList(businessVOS);
        return pager;
    }

    @Override
    public List<CustomerVO> findCustomerAll() {
        List<Customer> customers = customerDao.getAll();
        List<CustomerVO> customerVOS = new ArrayList<CustomerVO>();
        for (Customer customer : customers){
            CustomerVO customerVO = CustomerVO.fromCustomer(customer);
            customerVOS.add(customerVO);
        }
        return customerVOS;
    }

    @Override
    public List<UserVO> findUserAll() {
        List<User> users = userDao.getAll();
        List<UserVO> userVOS = new ArrayList<UserVO>();
        for (User user : users){
            UserVO userVO = UserVO.fromUser(user);
            userVOS.add(userVO);
        }
        return userVOS;
    }

    @Override
    public List<ContactsVO> findContactsAll() {
        List<Contacts> contactss = contactsDao.getAll();
        List<ContactsVO> contactsVOS = new ArrayList<ContactsVO>();
        for (Contacts contacts : contactss){
            ContactsVO contactsVO = ContactsVO.fromContacts(contacts);
            contactsVOS.add(contactsVO);
        }
        return contactsVOS;
    }

    @Override
    public List<BusinessStatusVO> findBusinessStatusAll() {
        List<BusinessStatus> businessStatuses = businessStatusDao.getAll();
        List<BusinessStatusVO> businessStatusVOS = new ArrayList<BusinessStatusVO>();
        for (BusinessStatus businessStatus : businessStatuses){
            BusinessStatusVO businessStatusVO = BusinessStatusVO.fromBusinessStatus(businessStatus);
            businessStatusVOS.add(businessStatusVO);
        }
            return businessStatusVOS;
    }

    @Override
    public List<DictVO> findBusinessTypeAll() {
        List<Dict> dicts = dictDao.getBusinessType();
        List<DictVO> dictVOS = new ArrayList<DictVO>();
        for (Dict dict : dicts){
            DictVO dictVO = DictVO.fromDict(dict);
            dictVOS.add(dictVO);
        }
        return dictVOS;
    }

    @Override
    public List<DictVO> findBusinessOriginAll() {
        List<Dict> dicts = dictDao.getBusinessOrigan();
        List<DictVO> dictVOS = new ArrayList<DictVO>();
        for (Dict dict : dicts){
            DictVO dictVO = DictVO.fromDict(dict);
            dictVOS.add(dictVO);
        }
        return dictVOS;
    }

    @Override
    public BusinessVO getFromBusiness(String id) {
        Business business = businessDao.getBusiness(id);
        return BusinessVO.fromBusiness(business);
    }

    @Override
    public Business fromBusinessVO(BusinessVO businessVO) {
        if (businessVO != null){
            Business business = new Business();
            business.setBusinessid(businessVO.getBusinessid());
            if (businessVO.getUserByCreatoruserId() != null){
                business.setUserByCreatoruserid(userDao.get(businessVO.getUserByCreatoruserId()));
            }else{
                business.setUserByCreatoruserid(null);
            }
            if (businessVO.getBusinessStatusId() != null){
                business.setBusinessStatus(businessStatusDao.get(businessVO.getBusinessStatusId()));
            }else{
                business.setBusinessStatus(null);
            }
            if (businessVO.getUserByUpdateuserId() != null){
                business.setUserByUpdateuserid(userDao.get(businessVO.getUserByUpdateuserId()));
            }else{
                business.setUserByUpdateuserid(null);
            }
            if (businessVO.getBusinessContactsId() != null){
                business.setBusinessContacts(contactsDao.get(businessVO.getBusinessContactsId()));
            }else{
                business.setBusinessContacts(null);
            }
            if (businessVO.getUserByOwneruserId() != null){
                business.setUserByOwneruserid(userDao.get(businessVO.getUserByOwneruserId()));
            }else{
                business.setUserByOwneruserid(null);
            }
            if (businessVO.getCustomerId() != null){
                business.setCustomer(customerDao.get(businessVO.getCustomerId()));
            }else{
                business.setCustomer(null);
            }
            if (businessVO.getUserByDeleteuserId() != null){
                business.setUserByDeleteuserid(userDao.get(businessVO.getUserByDeleteuserId()));
            }else{
                business.setUserByDeleteuserid(null);
            }
            business.setName(businessVO.getName());
            business.setOrigin(businessVO.getOrigin());
            business.setType(businessVO.getType());
            business.setEstimateprice(businessVO.getEstimateprice());
            business.setGainrate(businessVO.getGainrate());
            business.setTotalamount(businessVO.getTotalamount());
            business.setSubtotalval(businessVO.getSubtotalval());
            business.setDiscountprice(businessVO.getDiscountprice());
            business.setSalesprice(businessVO.getSalesprice());
            business.setDuedate(businessVO.getDuedate());
            business.setCreatetime(DateUtil.parseDate(businessVO.getCreatetime(),"yyyy-MM-dd HH-mm-ss"));
            business.setUpdatetime(DateUtil.parseDate(businessVO.getUpdatetime(),"yyyy-MM-dd HH-mm-ss"));
            business.setTotalprice(businessVO.getTotalprice());
            business.setNextstep(businessVO.getNextstep());
            business.setNextsteptime(DateUtil.parseDate(businessVO.getNextsteptime(),"yyyy-MM-ss HH:mm"));
            business.setIsdeleted(businessVO.getIsdeleted());
            business.setContractaddress(businessVO.getContractaddress());
            business.setDescription(businessVO.getDescription());
            business.setContracts(businessVO.getContracts());
            business.setLeadses(businessVO.getLeadses());
            business.setCustomers(businessVO.getCustomers());
            business.setBusinessProducts(businessVO.getBusinessProducts());
            business.setContracts_1(businessVO.getContracts_1());
            return business;
        }
        return null;
    }

    @Override
    public void saveBusiness(Business business) {
        businessDao.save(business);
    }

    @Override
    public void updateBusiness(Business business) {
        businessDao.update(business);
    }
}
