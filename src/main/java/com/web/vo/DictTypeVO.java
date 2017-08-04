package com.web.vo;

import com.web.system.entity.DictType;
import com.web.system.entity.User;
import com.web.util.DateUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/31.
 */
public class DictTypeVO {

    private String id;
    private String typename;
    private String typecode;
    private String typenote;
    private Integer sortnum;
    private Integer status;
    private String userByCreatebyName;
    private String createbyId;
    private String userByUpdatebyName;
    private String updatebyId;
    private String createtime;
    private String updatetime;
    private Integer version;

    /**
     * dicttype to dicttypevo
     * @param dictType
     * @return
     */
    public static DictTypeVO fromDictType(DictType dictType) {
        DictTypeVO dictTypeVO = null;
        if (dictType != null) {
            dictTypeVO = new DictTypeVO();
            dictTypeVO.setId(dictType.getId());
            if (dictType.getCreatetime() != null) {
                dictTypeVO.setCreatetime(DateUtil.formatDate(dictType.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (dictType.getUpdatetime() != null) {
                dictTypeVO.setUpdatetime(DateUtil.formatDate(dictType.getUpdatetime(), "yyyy-MM-dd HH:mm:ss"));
            }
            dictTypeVO.setSortnum(dictType.getSortnum());
            dictTypeVO.setStatus(dictType.getStatus());
            dictTypeVO.setTypecode(dictType.getTypecode());
            dictTypeVO.setTypename(dictType.getTypename());
            dictTypeVO.setTypenote(dictType.getTypenote());
            if (dictType.getUserByCreateby() != null) {
                dictTypeVO.setUserByCreatebyName(dictType.getUserByCreateby().getUsername());
                dictTypeVO.setCreatebyId(dictType.getUserByCreateby().getId());
            }
            if (dictType.getUserByUpdateby() != null) {
                dictTypeVO.setUserByUpdatebyName(dictType.getUserByUpdateby().getUsername());
                dictTypeVO.setUpdatebyId(dictType.getUserByUpdateby().getId());
            }
            dictTypeVO.setVersion(dictType.getVersion());
        }
        return dictTypeVO;
    }

    /**
     * dicttypevo to dicttype
     * @param dictTypeVO
     * @param user
     * @return
     */
    public static DictType fromDictTypeVO(DictTypeVO dictTypeVO, User user) {
        DictType dictType = null;
        if (dictTypeVO != null) {
            dictType = new DictType();
            dictType.setCreatetime(new Date());
            dictType.setUpdatetime(new Date());
            dictType.setId(dictTypeVO.getId());
            dictType.setSortnum(dictTypeVO.getSortnum());
            dictType.setStatus(dictTypeVO.getStatus());
            dictType.setTypecode(dictTypeVO.getTypecode());
            dictType.setTypename(dictTypeVO.getTypename());
            dictType.setTypenote(dictTypeVO.getTypenote());
            dictType.setUserByCreateby(user);
            dictType.setUserByUpdateby(user);
            dictType.setVersion(dictTypeVO.getVersion());
        }
        return dictType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypenote() {
        return typenote;
    }

    public void setTypenote(String typenote) {
        this.typenote = typenote;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatebyId() {
        return createbyId;
    }

    public void setCreatebyId(String createbyId) {
        this.createbyId = createbyId;
    }

    public String getUpdatebyId() {
        return updatebyId;
    }

    public void setUpdatebyId(String updatebyId) {
        this.updatebyId = updatebyId;
    }

    public String getUserByCreatebyName() {
        return userByCreatebyName;
    }

    public void setUserByCreatebyName(String userByCreatebyName) {
        this.userByCreatebyName = userByCreatebyName;
    }

    public String getUserByUpdatebyName() {
        return userByUpdatebyName;
    }

    public void setUserByUpdatebyName(String userByUpdatebyName) {
        this.userByUpdatebyName = userByUpdatebyName;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
