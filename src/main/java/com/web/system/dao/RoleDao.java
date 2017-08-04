package com.web.system.dao;

import com.web.base.dao.BaseDao;
import com.web.system.entity.Role;
import com.web.system.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
public interface RoleDao extends BaseDao<Role, String> {

    /**
     * 通过用户查询角色
     * @param user
     * @return
     */
    public List<Role> getRole(User user);

    /**
     * 通过页数查询
     * @param pageNumber 当前页数
     * @param pageSize 当前显示条数
     * @return
     */
    public List<Role> getRoleListByPage(Integer pageNumber, Integer pageSize);
}
