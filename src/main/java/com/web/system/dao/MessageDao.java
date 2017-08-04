package com.web.system.dao;

import com.web.base.dao.BaseDao;
import com.web.system.entity.Message;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface MessageDao extends BaseDao<Message, String>{

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Message> getMessageList(Integer pageNumber, Integer pageSize);
}
