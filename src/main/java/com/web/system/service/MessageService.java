package com.web.system.service;

import com.web.base.service.BaseService;
import com.web.system.entity.Message;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.vo.MessageVO;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface MessageService extends BaseService<Message, String>{

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Pager getList(Integer pageNumber, Integer pageSize);

    /**
     * 写信
     * @param messageVO
     */
    void writeMessage(MessageVO messageVO, User user);
}
