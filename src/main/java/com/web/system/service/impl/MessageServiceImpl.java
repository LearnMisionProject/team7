package com.web.system.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.system.dao.MessageDao;
import com.web.system.entity.Message;
import com.web.system.entity.User;
import com.web.system.service.MessageService;
import com.web.util.Pager;
import com.web.vo.MessageVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Service
public class MessageServiceImpl extends BaseServiceImpl<Message, String> implements MessageService {

    @Resource
    private MessageDao messageDao;
    @Resource
    private void setMessageDao(MessageDao messageDao) {
        super.setBaseDao(messageDao);
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Pager getList(Integer pageNumber, Integer pageSize) {
        List<Message> messageList = messageDao.getMessageList(pageNumber, pageSize);
        List<MessageVO> messageVOList = new ArrayList<MessageVO>();
        if (messageList != null && !messageList.isEmpty()) {
            for (Message message : messageList) {
                MessageVO messageVO = MessageVO.fromMessage(message);
                messageVOList.add(messageVO);
            }
        }
        Integer totalRows = messageDao.count();
        Pager pager = new Pager();
        pager.setList(messageVOList);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public void writeMessage(MessageVO messageVO, User user) {
        Message message = MessageVO.fromMessageVO(messageVO, user);
        this.save(message);
    }
}
