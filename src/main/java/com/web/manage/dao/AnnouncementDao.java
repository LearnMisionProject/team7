package com.web.manage.dao;

import com.web.base.dao.BaseDao;
import com.web.manage.entity.Announcement;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface AnnouncementDao extends BaseDao<Announcement, String> {

    List<Announcement> getListByPage(Integer pageNumber, Integer pageSize, String id ,String title);
}
