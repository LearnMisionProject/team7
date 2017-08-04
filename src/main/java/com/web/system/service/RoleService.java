package com.web.system.service;

import com.web.base.service.BaseService;
import com.web.system.entity.Role;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.vo.RoleVO;

import java.util.List;

public interface RoleService extends BaseService<Role, String> {

    /**
     * 获取角色的列表
     * @return
     */
    public Pager getRoleList(Integer pageNumber, Integer pageSize);

    /**
     * 新增
     * @param roleVO
     * @param user
     */
    public void save(RoleVO roleVO, User user);

    /**
     * 修改
     * @param roleVO
     * @param user
     */
    public void edit(RoleVO roleVO, User user);

    /**
     * 通过角色ID查询
     * @param id
     * @return
     */
    public RoleVO checkFromId(String id);

    public List<Role> getAll();

    public List<Role> getRolesByUserId(String userId);

    public boolean updateFunction(String roleId, String... funcIds);
}