package com.web.manage.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.manage.dao.AnnouncementDao;
import com.web.manage.entity.Announcement;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Repository
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement, String> implements AnnouncementDao {

    /**
     * 条件查询
     * @param pageNumber
     * @param pageSize
     * @param id 部门名
     * @param title 标题
     * @return
     */
    @Override
    public List<Announcement> getListByPage(Integer pageNumber, Integer pageSize, String id, String title) {
        String hql = "from Announcement ann";
        if (!"".equals(id) && "".equals(title)) {
            hql = hql + " inner join fetch ann.department ad where ad.name like '%" + id + "%'";
        }
        if ("".equals(id) && !"".equals(title)) {
            hql = hql + " where ann.title like '%" + title + "%'";
        }
        if (!"".equals(id) && !"".equals(title)) {
            hql = hql + " inner join fetch ann.department ad where ad.name like '%" + id + "%' and ann.title like '%" + title + "%'";
        }
        return this.getListByPage(pageNumber, pageSize, hql);
    }
}
