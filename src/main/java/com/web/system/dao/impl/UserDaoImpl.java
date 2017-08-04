package com.web.system.dao.impl;

import com.web.base.dao.BaseDao;
import com.web.base.dao.impl.BaseDaoImpl;
import com.web.system.dao.UserDao;
import com.web.system.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

    /**
     * 查询用户名
     * @param username
     * @return
     */
    @Override
    public User userNameCheck(String username) {
        Query query = getSession().createQuery("from User where username=:user");
        query.setParameter("user", username);
        return (User) query.uniqueResult();
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public List<User> getUserListByPage(Integer pageNumber, Integer pageSize) {
        String hql = "from User u left join fetch u.roles left join fetch u.userByUpdateby left join fetch u.userByCreateby order by u.sortnum";
        return this.getListByPage(pageNumber, pageSize, hql, new String[] {});
    }


}
