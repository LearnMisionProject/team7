package com.web.system.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.system.dao.DictDao;
import com.web.system.entity.Dict;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Repository
public class DictDaoImpl extends BaseDaoImpl<Dict, String> implements DictDao {

    @Override
    public List<Dict> getBusinessType() {
        String hql = "from Dict where typeid = 'E69500CC34154087A619CD89CE50B429'";
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Dict> getBusinessOrigan() {
        String hql = "from Dict where typeid = '40288a7c5d39cf22015d39d35ea60000'";
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Dict> getfromDictTypeId(Integer pageNumber, Integer pageSize, String id) {
        String hql = null;
        if ("".equals(id)) {
            hql = "from Dict";
        } else {
            hql = "from Dict d left join fetch d.dictType dt where dt.id ='" + id + "'";
        }
        return this.getListByPage(pageNumber, pageSize, hql);
    }
}
