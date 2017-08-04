package com.web.system.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.system.dao.FunctionDao;
import com.web.system.entity.Function;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function, String> implements FunctionDao {

    @Override
    public List<Function> getFunc(Integer functype, String... id) {
        String hql = "from Function f inner join fetch f.roles r " +
                "where f.status=1 and f.functype=:funcType and r.id in (:ids) order by f.sortnum";
        Query query = getSession().createQuery(hql);
        query.setParameter("funcType", functype);
        query.setParameterList("ids", id);
        return query.list();
    }

    @Override
    public List<Function> getFunctionByRoleId(String... roleIds) {
        String hql = "from Function f inner join fetch f.roles r " +
                "where r.id in (:ids) order by f.sortnum";
        Query query = getSession().createQuery(hql);
        query.setParameterList("ids", roleIds);
        return query.list();
    }

    /**
     * 获取权限列表
     * @return
     */
    public List<Function> getAssignList(String id) {
        String hql = "from Function f left join fetch f.roles r where r.id=:id";
        Query query = getSession().createQuery(hql);
        query.setParameter("id", id);
        return query.list();
    }

    @Override
    public Function getOne(String id){
        String hql = "from Function f where f.id=:id";
        Query query = getSession().createQuery(hql);
        query.setParameter("id",id);
        Function function =(Function) query.uniqueResult();
        return function;
    }

    @Override
    public List<Function> getAllFunction() {
        return super.getAll();
    }

    @Override
    public void saveFunction(Function function) {
        super.save(function);
    }

    @Override
    public void updateFunction(Function function) {
        super.update(function);
    }

    @Override
    public void deleteFunction(String id) {
        super.delete(id);
    }
}
