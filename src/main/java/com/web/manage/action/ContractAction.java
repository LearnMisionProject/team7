package com.web.manage.action;

import com.web.base.action.BaseAction;
import com.web.manage.entity.Business;
import com.web.manage.entity.Contract;
import com.web.manage.service.BusinessService;
import com.web.manage.service.ContractService;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.BusinessVO;
import com.web.vo.ContractVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
@ParentPackage("struts-default")
@Namespace("/manage/contract")
public class ContractAction extends BaseAction {

    private Integer contractOne;
    private Integer contractTwo;
    private String contract;

    private BusinessVO businessVO;
    private ContractVO contractVO;
    private List<Business> list;

    @Autowired
    private ContractService contractService;
    @Autowired
    private BusinessService businessService;
    //分页的页面
    @Action(value = "ContractAction_list",results = {
            @Result(name = "success",location = "list_contract.jsp")
    })
    public  String topage() {
        return SUCCESS;
    }

    //获取分页的数据
    @Action("ContractAction_findByPage")
    public void findByPage() throws IOException {
        Pager pager =contractService.getContractListByPage(page,rows,contractOne,contractTwo,contract);
        resultData = ResultData.buildSuccessResult("获取列表成功",pager);
        printJSONObject(resultData);
    }

    //去添加或修改的页面
    @Action(value = "ContractAction_edit",results={
            @Result(name = "success",location = "edit_contract.jsp")
    })
    public String add() {
        list = businessService.getAll();
        return SUCCESS;
    }

    @Action(value = "ContractAction_saveOrUpdate")
    public void save() {
        contractService.save(contractVO);
    }



    public Integer getContractOne() {
        return contractOne;
    }

    public void setContractOne(Integer contractOne) {
        this.contractOne = contractOne;
    }

    public Integer getContractTwo() {
        return contractTwo;
    }

    public void setContractTwo(Integer contractTwo) {
        this.contractTwo = contractTwo;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public List<Business> getList() {
        return list;
    }

    public void setList(List<Business> list) {
        this.list = list;
    }

    public BusinessVO getBusinessVO() {
        return businessVO;
    }

    public void setBusinessVO(BusinessVO businessVO) {
        this.businessVO = businessVO;
    }

    public ContractVO getContractVO() {
        return contractVO;
    }

    public void setContractVO(ContractVO contractVO) {
        this.contractVO = contractVO;
    }
}
