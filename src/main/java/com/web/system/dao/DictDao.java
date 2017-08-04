package com.web.system.dao;

import com.web.base.dao.BaseDao;
import com.web.system.entity.Dict;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface DictDao extends BaseDao<Dict, String> {

    List<Dict> getfromDictTypeId(Integer pageNumber, Integer pageSize, String id);
    List<Dict> getBusinessType();
    List<Dict> getBusinessOrigan();

}
