package com.web.system.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.system.dao.UserDao;
import com.web.system.entity.Role;
import com.web.system.entity.User;
import com.web.system.service.UserService;
import com.web.util.Pager;
import com.web.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService{

    @Resource
    private UserDao userDao;

    @Resource
    private void setUserDao(UserDao userDao) {
        super.setBaseDao(userDao);
    }

    @Override
    public User userNameCheck(String username) {
        return userDao.userNameCheck(username);
    }

    @Override
    public UserVO checkFromId(String id) {
        return UserVO.fromUser(userDao.get(id));
    }

    @Override
    public void save(UserVO userVO, User user) {
        User usr = userVO.fromUserVO(userVO, user);
        userDao.save(usr);
    }

    @Override
    public void edit(UserVO userVO, User user) {
        User usr = userVO.fromUserVO(userVO, user);
        userDao.update(usr);
    }

    @Override
    public Pager getUserListByPage(Integer pageNumber, Integer pageSize) {
        //查询用户列表
        List<User> list = userDao.getUserListByPage(pageNumber,pageSize);
        List<UserVO> userVOList = new ArrayList<UserVO>();
        if(list!=null && !list.isEmpty()) {
            for(User user:list) {
                UserVO userVO = UserVO.fromUser(user);
                userVOList.add(userVO);
            }
        }
        //查询数据总条数
        Integer totalRows = userDao.count();
        Pager pager = new Pager();
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        pager.setList(userVOList);
        return pager;
    }

    @Override
    public Boolean updateUserRole(String userId, String... roleIds) {
        //查询用户
        User user = userDao.get(userId);
        //先给用户解除所有角色关系
        user.getRoles().clear();
        //添加关联关系
        if (roleIds != null && roleIds.length > 0) {
            for (String id : roleIds) {
                Role role = new Role();
                role.setId(id);
                user.getRoles().add(role);
            }
        }
        return true;
    }

}
