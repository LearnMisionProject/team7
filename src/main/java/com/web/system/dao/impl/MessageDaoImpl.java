package com.web.system.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.system.dao.MessageDao;
import com.web.system.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message, String> implements MessageDao{

    @Override
    public List<Message> getMessageList(Integer pageNumber, Integer pageSize) {
        String hql = "from Message";
        return this.getListByPage(pageNumber, pageSize, hql);
    }
}
