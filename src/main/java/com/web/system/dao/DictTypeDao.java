package com.web.system.dao;

import com.web.base.dao.BaseDao;
import com.web.system.entity.DictType;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface DictTypeDao extends BaseDao<DictType, String> {

    /**
     * 获取下拉菜单,status为1(可用)
     */
    List<DictType> getListMenu();
}
