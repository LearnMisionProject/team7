package com.web.manage.dao;

import com.web.base.dao.BaseDao;
import com.web.manage.entity.Position;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface PositionDao extends BaseDao<Position,String>{


    /**
     * 通过pageNumber和pageSize分页查询
     */
    List<Position> getPositionListByPage(Integer pageNumber, Integer pageSize,String name);


    Position getFormTopId(String id);
}
