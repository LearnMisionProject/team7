package com.web.system.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.system.dao.DictDao;
import com.web.system.entity.Dict;
import com.web.system.entity.DictType;
import com.web.system.service.DictService;
import com.web.util.Pager;
import com.web.vo.DictVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class DictServiceImpl extends BaseServiceImpl<Dict, String> implements DictService {

    @Resource
    private DictDao dictDao;

    @Resource
    private void setDictDao (DictDao dictDao) {
        super.setBaseDao(dictDao);
    }

    /**
     * 通过DictType ID 查询Dict分页
     * @param pageNumber
     * @param pageSize
     * @param id
     * @return
     */
    @Override
    public Pager getfromDictTypeId(Integer pageNumber, Integer pageSize, String id) {
        List<Dict> dictList = dictDao.getfromDictTypeId(pageNumber, pageSize, id);
        List<DictVO> dictVOList = new ArrayList<DictVO>();
        if (dictList != null && dictList.size() > 0) {
            for (Dict dict : dictList) {
                DictVO dictVO = DictVO.fromDict(dict);
                dictVOList.add(dictVO);
            }
        }
        Integer totalRows = dictList.size();
        Pager pager = new Pager();
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        pager.setList(dictVOList);
        return pager;
    }

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @Override
    public DictVO getFromId(String id) {
        return DictVO.fromDict(dictDao.get(id));
    }

    /**
     * 新增
     * @param dictVO
     */
    @Override
    public void saveFromDictVO(DictVO dictVO, DictType dictType) {
        Dict dict = DictVO.fromDictVO(dictVO, dictType);
        dictDao.save(dict);
    }

    /**
     * 修改
     * @param dictVO
     */
    @Override
    public void editFromDictVO(DictVO dictVO, DictType dictType) {
        Dict dict = DictVO.fromDictVO(dictVO, dictType);
        dictDao.update(dict);
    }
}
