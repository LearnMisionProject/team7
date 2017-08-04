package com.web.system.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.system.dao.RoleDao;
import com.web.system.entity.Role;
import com.web.system.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, String> implements RoleDao {

    /**
     * 通过用户查询角色
     * @param user
     * @return
     */
    @Override
    public List<Role> getRole(User user) {
        String hql = "from Role r inner join fetch r.users u where u.id=:userId";
        Query query = getSession().createQuery(hql);
        query.setParameter("userId", user.getId());
        return query.list();
    }

    /**
     * 通过页数查询
     * @param pageNumber 当前页数
     * @param pageSize 当前显示条数
     * @return
     */
    @Override
    public List<Role> getRoleListByPage(Integer pageNumber, Integer pageSize) {
        String hql = "from Role";
        return this.getListByPage(pageNumber, pageSize, hql, new String[]{});
    }


}
