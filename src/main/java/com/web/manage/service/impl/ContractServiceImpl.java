package com.web.manage.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.manage.dao.ContractDao;
import com.web.manage.entity.Contract;
import com.web.manage.service.ContractService;
import com.web.util.Pager;
import com.web.vo.ContractVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract,String> implements ContractService {

    @Autowired
    private ContractDao contractDao;

    @Autowired
    public void setContractDao(ContractDao contractDao) {
        super.setBaseDao(contractDao);
    }


    @Override
    public Pager getContractListByPage(Integer pageNumber, Integer pageSize,Integer contractOne,Integer contractTwo,String contractThree) {
        List<Contract> list = contractDao.getContractListByPage(pageNumber, pageSize,contractOne,contractTwo,contractThree);
        List<ContractVO> productVOList = new ArrayList<ContractVO>();
        if (list != null && !list.isEmpty()) {
            for (Contract contract : list) {
                ContractVO contractVO = ContractVO.fromContract(contract);
                productVOList.add(contractVO);
            }
        }
        Integer totalRows = contractDao.getSize(contractOne,contractTwo,contractThree);
        Pager pager = new Pager();
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        pager.setList(productVOList);
        return pager;
    }

    @Override
    public void save(ContractVO contractVO) {
        Contract contract1 = ContractVO.fromContractVO(contractVO);
        contractDao.save(contract1);
    }
}

