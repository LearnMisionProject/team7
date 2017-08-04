package com.web.manage.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.manage.dao.PositionDao;
import com.web.manage.entity.Department;
import com.web.manage.entity.Position;
import com.web.manage.service.PositionService;
import com.web.util.Pager;
import com.web.vo.PositionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class PositionServiceImpl extends BaseServiceImpl<Position,String> implements PositionService {
    @Autowired
    private PositionDao positionDao;

    @Autowired
    private PositionService positionService;
    @Autowired
    public void setPositionDao(PositionDao positionDao) {
        super.setBaseDao(positionDao);
    }



    @Override
    public Position getPById(String id) {
        return positionDao.get(id);
    }

    @Override
    public PositionVO getPositionVO(String positionId) {
        Position position = positionService.get(positionId);
        return PositionVO.fromPosition(position);
    }

    @Override
    public boolean del(String... ids) {
        if(ids!=null && ids.length>0) {
            for(String id : ids) {
                positionService.delete(id);
            }
            return true;
        }

        return false;
    }

    @Override
    public Pager getPositionListByPage(Integer pageNumber, Integer pageSize,String name) {
        //获取总条数
        Integer totalRows = positionDao.count();
        List<Position> list = positionDao.getPositionListByPage(pageNumber,pageSize,name);
        List<PositionVO> list1= new ArrayList<PositionVO>();
        //将存储position对象的list集合转化成positionVO对象的集合
        if(list!=null && !list.isEmpty()) {
            for(Position position : list) {
                PositionVO positionVO = PositionVO.fromPosition(position);
                list1.add(positionVO);
            }
        }
        Pager pager = new Pager();
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        pager.setList(list1);
        return pager;
    }
}
