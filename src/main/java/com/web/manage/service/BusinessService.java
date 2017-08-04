package com.web.manage.service;

import com.web.base.service.BaseService;
import com.web.manage.entity.Business;
import com.web.util.Pager;
import com.web.vo.*;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface BusinessService extends BaseService<Business, String>{

    public Pager getBusinessLIst(Integer pageNumber , Integer pageSize , String searchBy , String searchText);

    BusinessVO getFromBusiness(String id);

    List<CustomerVO> findCustomerAll();
    List<UserVO> findUserAll();
    List<ContactsVO> findContactsAll();
    List<BusinessStatusVO> findBusinessStatusAll();
    List<DictVO> findBusinessTypeAll();
    List<DictVO> findBusinessOriginAll();
    Business fromBusinessVO(BusinessVO businessVO);
    public void saveBusiness(Business business);
    public void updateBusiness(Business business);
}
