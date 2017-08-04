package com.web.system.service;

import com.web.base.service.BaseService;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.vo.UserVO;

/**
 * Created by Administrator on 2017/7/24.
 */
public interface UserService extends BaseService<User, String>{

    /**
     * 查询用户名
     * @param username
     * @return
     */
    public User userNameCheck(String username);

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public Pager getUserListByPage(Integer pageNumber, Integer pageSize);

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    public UserVO checkFromId(String id);

    /**
     * 保存
     * @param userVO
     * @param user
     */
    public void save(UserVO userVO, User user);

    /**
     * 修改
     * @param userVO
     * @param user
     */
    public void edit(UserVO userVO, User user);

    /**
     * 分配角色
     * @param userId
     * @param roleIds
     * @return
     */
    public Boolean updateUserRole(String userId, String... roleIds);
}
