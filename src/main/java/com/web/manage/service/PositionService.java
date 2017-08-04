package com.web.manage.service;

import com.web.base.service.BaseService;
import com.web.manage.entity.Department;
import com.web.manage.entity.Position;
import com.web.util.Pager;
import com.web.vo.PositionVO;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface PositionService extends BaseService<Position,String>{

    Pager getPositionListByPage(Integer pageNumber, Integer pageSize,String name);

    Position getPById(String id);

    PositionVO getPositionVO(String positionId);

    public boolean del(String...ids);
}
