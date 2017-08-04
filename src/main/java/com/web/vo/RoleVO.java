package com.web.vo;

import com.web.system.entity.Role;
import com.web.system.entity.User;
import com.web.util.DateUtil;

import java.util.Date;

public class RoleVO {

    private String id;
    private String userByUpdatebyName;
    private String userByUpdatebyId;
    private String userByCreatebyName;
    private String userByCreatebyId;
    private String createTime;
    private String updateTime;
    private String roleName;
    private String roleNote;
    private Integer sortNum;
    private Integer status;
    private String funcIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserByUpdatebyName() {
        return userByUpdatebyName;
    }

    public void setUserByUpdatebyName(String userByUpdatebyName) {
        this.userByUpdatebyName = userByUpdatebyName;
    }

    public String getUserByUpdatebyId() {
        return userByUpdatebyId;
    }

    public void setUserByUpdatebyId(String userByUpdatebyId) {
        this.userByUpdatebyId = userByUpdatebyId;
    }

    public String getUserByCreatebyName() {
        return userByCreatebyName;
    }

    public void setUserByCreatebyName(String userByCreatebyName) {
        this.userByCreatebyName = userByCreatebyName;
    }

    public String getUserByCreatebyId() {
        return userByCreatebyId;
    }

    public void setUserByCreatebyId(String userByCreatebyId) {
        this.userByCreatebyId = userByCreatebyId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNote() {
        return roleNote;
    }

    public void setRoleNote(String roleNote) {
        this.roleNote = roleNote;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFuncIds() {
        return funcIds;
    }

    public void setFuncIds(String funcIds) {
        this.funcIds = funcIds;
    }

    /**
     * role 转 RoleVO
     * @param role
     * @return
     */
    public static RoleVO formRole(Role role) {
        if (role != null) {
            RoleVO roleVO = new RoleVO();
            roleVO.setId(role.getId());

            if (role.getUserByCreateby() != null) {
                roleVO.setUserByCreatebyId(role.getUserByCreateby().getId());
                roleVO.setUserByCreatebyName(role.getUserByCreateby().getUsername());
            }
            if (role.getUserByUpdateby() != null) {
                roleVO.setUserByUpdatebyId(role.getUserByUpdateby().getId());
                roleVO.setUserByUpdatebyName(role.getUserByUpdateby().getUsername());
            }

            roleVO.setCreateTime(DateUtil.formatDate(role.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            roleVO.setUpdateTime(DateUtil.formatDate(role.getUpdatetime(), "yyyy-MM-dd HH:mm:ss"));
            roleVO.setRoleName(role.getRolename());
            roleVO.setRoleNote(role.getRolenote());
            roleVO.setSortNum(role.getSortnum());
            roleVO.setStatus(role.getStatus());
            return roleVO;
        }
        return null;
    }

    /**
     * RoleVO转Role
     * @param roleVO
     * @return
     */
    public static Role formRoleVO(RoleVO roleVO, User user) {
        //rolevo为null直接返回null
        if (roleVO == null) {
            return null;
        }
        Role role = new Role();
        role.setId(roleVO.getId());
        //user为null 不设置
        if (user != null) {
            role.setUserByCreateby(user);
            role.setUserByUpdateby(user);
        }
        role.setCreatetime(new Date());
        role.setUpdatetime(new Date());
        role.setRolename(roleVO.getRoleName());
        role.setRolenote(roleVO.getRoleNote());
        role.setSortnum(roleVO.getSortNum());
        role.setStatus(roleVO.getStatus());
        return role;
    }
}
