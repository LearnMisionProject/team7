package com.web.manage.dao.impl;

import com.web.base.dao.impl.BaseDaoImpl;
import com.web.manage.dao.ContractDao;
import com.web.manage.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract,String> implements ContractDao {
    @Autowired
    private ContractDao contractDao;
    @Override
    public List<Contract> getContractListByPage(Integer pageNumber, Integer pageSize,Integer contractOne,Integer contractTwo,String contractThree) {
        StringBuffer hql = new StringBuffer("from Contract c left join fetch c.business b left join fetch c.createUser left join " +
                "fetch c.ownerUser left join fetch c.deleteUser left join fetch b.customer");

        if(contractOne!=null&&contractTwo!=null&&contractThree!=null) {
            if(contractOne == 2 && contractTwo ==1) {
                hql.append(" where b.customer.name like '%");
                hql.append(contractThree);
                hql.append("%'");
            }
            if(contractOne==2 && contractTwo ==2) {
                hql.append("where b.customer.name = ");
                hql.append(contractThree);
            }
            if(contractOne ==3 && contractTwo == 1) {
                hql.append(" where b.businessContacts.name like '%"+contractThree+"%'");
            }
            if(contractOne ==3 && contractTwo==2) {
                //where businessConnectionName='contractThree';
                hql.append(" where b.businessContacts.name ='"+ contractThree +"'");
            }
            if(contractOne==4 && contractTwo==1) {
                hql.append(" where c.ownerUser.username like '%"+contractThree+"%'");
            }
            if(contractOne==4 && contractTwo==2) {
                hql.append(" where c.ownerUser.username = '"+ contractThree +"'");
            }
        }
        return contractDao.getListByPage(pageNumber,pageSize,hql.toString(),new String[]{});
    }

    @Override
    public Integer getSize(Integer contractOne, Integer contractTwo, String contractThree) {
        StringBuffer hql = new StringBuffer("from Contract c left join fetch c.business b left join fetch c.createUser left join " +
                "fetch c.ownerUser left join fetch c.deleteUser left join fetch b.customer");

        if(contractOne!=null&&contractTwo!=null&&contractThree!=null) {
            if(contractOne == 2 && contractTwo ==1) {
                hql.append(" where b.customer.name like '%");
                hql.append(contractThree);
                hql.append("%'");
            }
            if(contractOne==2 && contractTwo ==2) {
                hql.append("where b.customer.name = ");
                hql.append(contractThree);
            }
            if(contractOne ==3 && contractTwo == 1) {
                hql.append(" where b.businessContacts.name like '%"+contractThree+"%'");
            }
            if(contractOne ==3 && contractTwo==2) {
                //where businessConnectionName='contractThree';
                hql.append(" where b.businessContacts.name ='"+ contractThree +"'");
            }
            if(contractOne==4 && contractTwo==1) {
                hql.append(" where c.ownerUser.username like '%"+contractThree+"%'");
            }
            if(contractOne==4 && contractTwo==2) {
                hql.append(" where c.ownerUser.username = '"+ contractThree +"'");
            }
        }
        return this.getSize(hql.toString());
    }
}
