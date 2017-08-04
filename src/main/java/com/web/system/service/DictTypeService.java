package com.web.system.service;

import com.web.base.service.BaseService;
import com.web.system.entity.DictType;
import com.web.system.entity.User;
import com.web.vo.DictTypeVO;

import java.util.List;

public interface DictTypeService extends BaseService<DictType, String>{

    /**
     * 获取全部列表
     * @return
     */
    List<DictTypeVO> getAllList();

    /**
     * 新增
     * @param dictTypeVO
     * @param user
     */
    void saveDictType(DictTypeVO dictTypeVO, User user);

    /**
     * 修改
     * @param dictTypeVO
     * @param user
     */
    void editDictType(DictTypeVO dictTypeVO, User user);

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    DictTypeVO getFromId(String id);

    /**
     * 通过ID查询返回DictType
     * @param id
     * @return
     */
    DictType returnDictType(String id);

    /**
     * 获取下拉菜单,status为1(可用)
     */
    List<DictTypeVO> getMenuList();
}
