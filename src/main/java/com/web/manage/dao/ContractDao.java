package com.web.manage.dao;

import com.web.base.dao.BaseDao;
import com.web.manage.entity.Contract;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface ContractDao extends BaseDao<Contract,String> {

    List<Contract> getContractListByPage(Integer pageNumber,Integer pageSize,Integer contractOne,Integer contractTwo,String contractThree);

    Integer getSize(Integer contractOne,Integer contractTwo,String contractThree);
}
