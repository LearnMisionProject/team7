package com.web.base.dao;

import com.web.util.Pager;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * 基础dao接口
 * Created by lx on 2017/7/14.
 */
public interface BaseDao<T, PK extends Serializable> {

    /**
     * 根据主键进行查询
     * @param id
     * @return
     */
    public T get(PK id);

    /**
     * 查询所有
     * @return
     */
    public List<T> getAll();

    /**
     * 保存
     * @param entity
     */
    public void save(T entity);

    /**
     * 根据主键删除
     * @param id
     */
    public void delete(PK id);

    /**
     * 修改
     * @param entity
     */
    public void update(T entity);

    /**
     * 修改or新增
     * @param entity
     */
    void saveOrUpdate(T entity);

    /**
     * 分页查询
     * @param pager
     * @return
     */
    public Pager getListByPage(Pager pager, DetachedCriteria detachedCriteria);

    public List<T> getListByPage(Integer pageNumber, Integer pageSize, String hql, Object... args);

    public Integer count();


    public Integer getSize(String hql);
}
