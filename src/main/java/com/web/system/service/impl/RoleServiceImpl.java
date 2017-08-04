package com.web.system.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.system.dao.RoleDao;
import com.web.system.entity.Function;
import com.web.system.entity.Role;
import com.web.system.entity.User;
import com.web.system.service.RoleService;
import com.web.util.Pager;
import com.web.vo.RoleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements RoleService{

    @Resource
    private RoleDao roleDao;

    @Resource
    private void setRoleDao(RoleDao roleDao) {
        super.setBaseDao(roleDao);
    }

    @Override
    public Pager getRoleList(Integer pageNumber, Integer pageSize) {
        List<Role> roleList = roleDao.getRoleListByPage(pageNumber, pageSize);
        List<RoleVO> roleVOList = new ArrayList<RoleVO>();
        if (roleList != null && !roleList.isEmpty()) {
            for (Role role : roleList) {
                RoleVO roleVO = RoleVO.formRole(role);
                roleVOList.add(roleVO);
            }
        }
        Integer totalRows = roleDao.count();
        Pager pager = new Pager();
        pager.setList(roleVOList);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public void save(RoleVO roleVO, User user) {
        Role role = RoleVO.formRoleVO(roleVO, user);
        roleDao.save(role);
    }

    @Override
    public void edit(RoleVO roleVO, User user) {
        Role role = RoleVO.formRoleVO(roleVO, user);
        roleDao.update(role);
    }

    @Override
    public RoleVO checkFromId(String id) {
        Role role = roleDao.get(id);
        return RoleVO.formRole(role);
    }

    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }


    @Override
    public List<Role> getRolesByUserId(String userId) {
        User user = new User();
        user.setId(userId);
        return  roleDao.getRole(user);
    }

    /**
     * 对应角色ID更新对应权限
     * @param roleId
     * @param funcIds
     * @return
     */
    public boolean updateFunction(String roleId, String... funcIds) {
        Role role = roleDao.get(roleId);
        role.getFunctions().clear();
        if (funcIds != null && funcIds.length > 0) {
            for (String id : funcIds) {
                Function function = new Function();
                function.setId(id);
                role.getFunctions().add(function);
            }
        }
        return true;
    }
}
