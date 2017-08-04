package com.web.system.dao;

import com.web.base.dao.BaseDao;
import com.web.system.entity.User;
import com.web.vo.IndexVO;

import java.util.List;

public interface UserDao extends BaseDao<User, String>{

    public User userNameCheck(String username);

    /**
     * 通过pageNumber和pageSize分页查询
     */

    List<User> getUserListByPage(Integer pageNumber, Integer pageSize);

}
