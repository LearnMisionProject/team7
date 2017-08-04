package com.web.system.action;

import com.web.base.action.BaseAction;
import com.web.system.entity.User;
import com.web.system.service.MessageService;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.MessageVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/31.
 */
@ParentPackage("struts-default")
@Namespace("/system/message")
public class MessageAction extends BaseAction {

    @Resource
    private MessageService messageService;

    private String submit;
    private MessageVO messageVO;

    /**
     * 跳转到站内信主页
     * @return
     */
    @Action(value = "MessageAction_list", results = {
            @Result(location = "list_message.jsp")
    })
    public String toIndex() {
        return SUCCESS;
    }

    /**
     * 跳转写信页面or发送
     * @return
     */
    @Action(value = "MessageAction_write", results = {
            @Result(location = "write_message.html")
    })
    public String toWriteMessage() throws IOException {
        if ("发送".equals(submit)) {
            User user = (User) getSession().getAttribute("user");
            messageService.writeMessage(messageVO, user);
        }
        return SUCCESS;
    }

    /**
     * 获取列表
     */
    @Action(value = "MessageAction_findByPage")
    public void messageList() throws IOException {
        Pager pager = messageService.getList(page, rows);
        printJSONObject(ResultData.buildSuccessResult("获取列表成功", pager));
    }

    public MessageVO getMessageVO() {
        return messageVO;
    }

    public void setMessageVO(MessageVO messageVO) {
        this.messageVO = messageVO;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }
}
