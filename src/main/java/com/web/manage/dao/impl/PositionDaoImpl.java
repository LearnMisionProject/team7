package com.web.manage.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.manage.dao.PositionDao;
import com.web.manage.entity.Position;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Repository
public class PositionDaoImpl extends BaseDaoImpl<Position,String> implements PositionDao {


    @Override
    public List<Position> getPositionListByPage(Integer pageNumber, Integer pageSize,String name) {
        String hql = null;
        if (name == null) {
            hql = "from Position";
        } else {
            hql = "from Position p where p.name like '%"+name+"%'";
        }
        return this.getListByPage(pageNumber,pageSize,hql,new String[] {});
    }

    @Override
    public Position getFormTopId(String id) {
        String hql = "from Position where id=:id";
        Query query = getSession().createQuery(hql);
        query.setParameter("id",id);
        List<Position> list = query.list();
        return list.get(0);
    }
}
