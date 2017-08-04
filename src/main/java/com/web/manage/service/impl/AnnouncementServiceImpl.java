package com.web.manage.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.manage.dao.AnnouncementDao;
import com.web.manage.entity.Announcement;
import com.web.manage.entity.Department;
import com.web.manage.service.AnnouncementService;
import com.web.manage.service.DepartmentSerivce;
import com.web.system.entity.User;
import com.web.util.Pager;
import com.web.vo.AnnouncementVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Service
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement, String> implements AnnouncementService{

    @Resource
    private AnnouncementDao announcementDao;
    @Resource
    private void setAnnouncementDao(AnnouncementDao announcementDao) {
        super.setBaseDao(announcementDao);
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Pager listByPage(Integer pageNumber, Integer pageSize, String id, String title) {
        List<Announcement> announcementList = announcementDao.getListByPage(pageNumber, pageSize, id, title);
        List<AnnouncementVO> announcementVOList = new ArrayList<AnnouncementVO>();
        if (announcementList != null && !announcementList.isEmpty()) {
            for (Announcement announcement : announcementList) {
                AnnouncementVO announcementVO = AnnouncementVO.fromAnnouncement(announcement);
                announcementVOList.add(announcementVO);
            }
        }
        //查询数据总条数
        Integer totalRows = announcementVOList.size();
        Pager pager = new Pager();
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        pager.setList(announcementVOList);
        return pager;
    }

    /**
     * 新增
     * @param announcementVO
     * @param user
     */
    @Override
    public void toSave(AnnouncementVO announcementVO, User user, Department department) throws ParseException {
        Announcement announcement = AnnouncementVO.fromAnnouncementVO(announcementVO, user, department);
        announcementDao.save(announcement);
    }

    /**
     * 修改
     * @param announcementVO
     * @param user
     * @param department
     * @throws ParseException
     */
    @Override
    public void toEdit(AnnouncementVO announcementVO, User user, Department department) throws ParseException {
        Announcement announcement = AnnouncementVO.fromAnnouncementVO(announcementVO, user, department);
        announcementDao.update(announcement);
    }

    /**
     * 通过Id查询
     * @param id
     * @return
     */
    public AnnouncementVO getIdToAnnouncementVO(String id) {
        Announcement announcement = announcementDao.get(id);
        return AnnouncementVO.fromAnnouncement(announcement);
    }
}
