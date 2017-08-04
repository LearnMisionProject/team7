package com.web.manage.service;

import com.web.base.service.BaseService;
import com.web.manage.entity.Contract;
import com.web.util.Pager;
import com.web.vo.ContractVO;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface ContractService extends BaseService<Contract,String> {

    Pager getContractListByPage(Integer pageNumber,Integer pageSize,Integer contractOne,Integer contractTwo,String contractThree);

    void save(ContractVO contractVO);

}
