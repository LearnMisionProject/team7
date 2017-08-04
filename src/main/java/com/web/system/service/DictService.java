package com.web.system.service;

import com.web.base.service.BaseService;
import com.web.system.entity.Dict;
import com.web.system.entity.DictType;
import com.web.util.Pager;
import com.web.vo.DictVO;


/**
 * Created by Administrator on 2017/7/31.
 */
public interface DictService extends BaseService<Dict, String>{

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param id
     * @return
     */
    Pager getfromDictTypeId(Integer pageNumber, Integer pageSize, String id);

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    DictVO getFromId(String id);

    /**
     * 新增
     * @param dictVO
     */
    void saveFromDictVO(DictVO dictVO, DictType dictType);

    /**
     * 修改
     * @param dictVO
     */
    void editFromDictVO(DictVO dictVO, DictType dictType);
}
