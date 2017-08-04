package com.web.manage.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.manage.dao.ContactsDao;
import com.web.manage.entity.Contacts;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/8/3.
 */
@Repository
public class ContactsDaoImpl extends BaseDaoImpl<Contacts , String> implements ContactsDao{
}
