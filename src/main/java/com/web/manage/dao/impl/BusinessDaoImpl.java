package com.web.manage.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.manage.dao.BusinessDao;
import com.web.manage.entity.Business;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Repository
public class BusinessDaoImpl extends BaseDaoImpl<Business,String> implements BusinessDao {


    @Override
    public List<Business> getRoleListByPage(Integer pageNumber, Integer pageSize , String searchBy , String searchText) {
        StringBuffer hql = new StringBuffer("from Business b left join fetch b.customer c");
        if ("couname".equals(searchBy) && searchText != null && searchText.length() > 0){
            hql.append(" where c.name like '%" + searchText + "%'");
        }else if ("busname".equals(searchBy) && searchText != null && searchText.length() > 0){
            hql.append(" where b.name like '%" + searchText + "%'" );
        }else if ("busorigin".equals(searchBy) && searchText != null && searchText.length() > 0){
            hql.append(" where b.origin like '%" + searchText + "%'" );
        }else if ("busnextstep".equals(searchBy) && searchText != null && searchText.length() > 0){
            hql.append(" where b.nextstep like '%" + searchText + "%'" );
        }

        return this.getListByPage(pageNumber,pageSize,hql.toString(),new String[]{});
    }

    @Override
    public Business getBusiness(String id) {
        return super.get(id);
    }

    @Override
    public Integer getSize(String searchBy, String searchText) {
        StringBuffer hql = new StringBuffer("from Business b left join fetch b.customer c");
        if ("couname".equals(searchBy) && searchText != null && searchText.length() > 0){
            hql.append(" where c.name like '%" + searchText + "%'");
        }else if ("busname".equals(searchBy) && searchText != null && searchText.length() > 0){
            hql.append(" where b.name like '%" + searchText + "%'" );
        }else if ("busorigin".equals(searchBy) && searchText != null && searchText.length() > 0){
            hql.append(" where b.origin like '%" + searchText + "%'" );
        }else if ("busnextstep".equals(searchBy) && searchText != null && searchText.length() > 0){
            hql.append(" where b.nextstep like '%" + searchText + "%'" );
        }
        return this.getSize(hql.toString());
    }
}
