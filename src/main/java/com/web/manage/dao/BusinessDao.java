package com.web.manage.dao;

import com.web.base.dao.BaseDao;
import com.web.manage.entity.Business;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface BusinessDao extends BaseDao<Business , String> {

    public List<Business> getRoleListByPage(Integer pageNumber, Integer pageSize , String searchBy  , String searchText);
    Business getBusiness(String id);
    Integer getSize(String searchBy  , String searchText);
}
