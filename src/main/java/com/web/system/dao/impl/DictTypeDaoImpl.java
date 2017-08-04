package com.web.system.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.system.dao.DictTypeDao;
import com.web.system.entity.DictType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Repository
public class DictTypeDaoImpl extends BaseDaoImpl<DictType, String> implements DictTypeDao {

    /**
     * 获取下拉菜单,status为1(可用)
     */
    @Override
    public List<DictType> getListMenu() {
        String hql = "from DictType dt where dt.status=1";
        return getSession().createQuery(hql).list();
    }
}
