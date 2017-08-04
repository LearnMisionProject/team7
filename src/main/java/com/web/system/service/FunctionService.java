package com.web.system.service;

import com.web.base.service.BaseService;
import com.web.system.entity.Function;
import com.web.vo.FunctionVO;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface FunctionService extends BaseService<Function, String>{

    public List<Function> getAssignList(String id);

    public List<FunctionVO> getAssignlistAll();

    FunctionVO getOne(String id);
    List<Function> getAllFunction();
    Function saveFunction(FunctionVO functionVO);

    void saveFunction(Function function);
    void updateFunction(Function function);
    void deleteFunction(String id);


}
