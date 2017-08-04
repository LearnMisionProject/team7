package com.web.manage.service;

import com.web.base.service.BaseService;
import com.web.manage.entity.Announcement;
import com.web.manage.entity.Department;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.vo.AnnouncementVO;

import java.text.ParseException;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface AnnouncementService extends BaseService<Announcement, String> {

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Pager listByPage(Integer pageNumber, Integer pageSize, String id, String title);

    /**
     * 新增
     * @param announcementVO
     * @param user
     * @param department
     */
    void toSave(AnnouncementVO announcementVO, User user, Department department) throws ParseException;

    /**
     * 修改
     * @param announcementVO
     * @param user
     * @param department
     * @throws ParseException
     */
    void toEdit(AnnouncementVO announcementVO, User user, Department department) throws ParseException;

    AnnouncementVO getIdToAnnouncementVO(String id);
}
