package com.web.system.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.system.dao.DictTypeDao;
import com.web.system.entity.DictType;
import com.web.system.entity.User;
import com.web.system.service.DictTypeService;
import com.web.vo.DictTypeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class DictTypeServiceImpl extends BaseServiceImpl<DictType, String> implements DictTypeService{

    @Resource
    private DictTypeDao dictTypeDao;

    @Resource
    private void setDictTypeDao(DictTypeDao dictTypeDao) {
        super.setBaseDao(dictTypeDao);
    }

    @Override
    public List<DictTypeVO> getAllList() {
        List<DictType> dictTypeList = dictTypeDao.getAll();
        List<DictTypeVO> dictTypeVOList = new ArrayList<DictTypeVO>();
        if (dictTypeList != null) {
            for (DictType dictType : dictTypeList) {
                DictTypeVO dictTypeVO = new DictTypeVO();
                dictTypeVO = DictTypeVO.fromDictType(dictType);
                dictTypeVOList.add(dictTypeVO);
            }
        }
        return dictTypeVOList;
    }

    @Override
    public void saveDictType(DictTypeVO dictTypeVO, User user) {
        DictType dictType = DictTypeVO.fromDictTypeVO(dictTypeVO, user);
        dictTypeDao.save(dictType);
    }

    @Override
    public void editDictType(DictTypeVO dictTypeVO, User user) {
        DictType dictType = DictTypeVO.fromDictTypeVO(dictTypeVO, user);
        dictTypeDao.update(dictType);
    }

    @Override
    public DictTypeVO getFromId(String id) {
        DictType dictType = dictTypeDao.get(id);
        return DictTypeVO.fromDictType(dictType);
    }

    @Override
    public DictType returnDictType(String id) {
        return dictTypeDao.get(id);
    }

    /**
     * 获取下拉菜单,status为1(可用)
     */
    @Override
    public List<DictTypeVO> getMenuList() {
        List<DictType> dictTypeList = dictTypeDao.getListMenu();
        List<DictTypeVO> dictTypeVOList = new ArrayList<DictTypeVO>();
        if (dictTypeList != null) {
            for (DictType dictType : dictTypeList) {
                DictTypeVO dictTypeVO = new DictTypeVO();
                dictTypeVO = DictTypeVO.fromDictType(dictType);
                dictTypeVOList.add(dictTypeVO);
            }
        }
        return dictTypeVOList;
    }
}
