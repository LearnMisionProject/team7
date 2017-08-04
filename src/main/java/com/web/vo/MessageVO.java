package com.web.vo;

import com.web.system.entity.Message;
import com.web.system.entity.User;
import com.web.util.DateUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/2.
 */
public class MessageVO {

    private String messageid;
    private String userByTouserid;
    private String userByTousername;
    private String userByFromuserid;
    private String userByFromusername;
    private String content;
    private String readtime;
    private String sendtime;
    private String status;

    /**
     * message to messagevo
     * @param message
     * @return
     */
    public static MessageVO fromMessage(Message message) {
        MessageVO messageVO = new MessageVO();
        if (message != null) {
            messageVO.setMessageid(message.getMessageid());
            if (message.getUserByFromuserid() != null) {
                messageVO.setUserByFromuserid(message.getUserByFromuserid().getId());
                messageVO.setUserByFromusername(message.getUserByFromuserid().getUsername());
            }
            if (message.getUserByTouserid() != null) {
                messageVO.setUserByTouserid(message.getUserByTouserid().getId());
                messageVO.setUserByTousername(message.getUserByTouserid().getUsername());
            }
            messageVO.setContent(message.getContent());
            messageVO.setReadtime(DateUtil.formatDate(message.getReadtime(), "yyyy-MM-dd HH:mm:ss"));
            messageVO.setSendtime(DateUtil.formatDate(message.getSendtime(), "yyyy-MM-dd HH:mm:ss"));
            messageVO.setStatus(message.getStatus().toString());
        }
        return messageVO;
    }

    /**
     * messagevo to message
     * @param messageVO
     * @param user
     * @return
     */
    public static Message fromMessageVO(MessageVO messageVO, User user) {
        Message message = new Message();
        if (messageVO != null) {
            message.setContent(messageVO.getContent());
            message.setMessageid(messageVO.getMessageid());
            message.setReadtime(new Date());
            message.setSendtime(new Date());
            if (user != null) {
                message.setUserByFromuserid(user);
                message.setUserByTouserid(user);
            }
            message.setStatus(Boolean.getBoolean(messageVO.getStatus()));
        }
        return message;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getUserByTouserid() {
        return userByTouserid;
    }

    public void setUserByTouserid(String userByTouserid) {
        this.userByTouserid = userByTouserid;
    }

    public String getUserByTousername() {
        return userByTousername;
    }

    public void setUserByTousername(String userByTousername) {
        this.userByTousername = userByTousername;
    }

    public String getUserByFromuserid() {
        return userByFromuserid;
    }

    public void setUserByFromuserid(String userByFromuserid) {
        this.userByFromuserid = userByFromuserid;
    }

    public String getUserByFromusername() {
        return userByFromusername;
    }

    public void setUserByFromusername(String userByFromusername) {
        this.userByFromusername = userByFromusername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReadtime() {
        return readtime;
    }

    public void setReadtime(String readtime) {
        this.readtime = readtime;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
