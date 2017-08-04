package com.web.system.service.impl;

import com.web.base.service.impl.BaseServiceImpl;
import com.web.system.dao.FunctionDao;
import com.web.system.dao.UserDao;
import com.web.system.entity.Function;
import com.web.system.entity.Role;
import com.web.system.service.FunctionService;
import com.web.util.DateUtil;
import com.web.vo.FunctionVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function, String> implements FunctionService {

    @Resource
    private FunctionDao functionDao;
    @Resource
    private UserDao userDao;

    @Resource
    private void setFunctionDao(FunctionDao functionDao) {
        this.functionDao = functionDao;
    }

    /**
     * 通过ID查询对应的权限列表
     * @param id
     * @return
     */
    public List<Function> getAssignList(String id) {
        return functionDao.getAssignList(id);
    }



    /**
     * 获取权限列表
     * @return
     */
    public List<FunctionVO> getAssignlistAll() {
        List<Function> functionList = functionDao.getAll();
        List<FunctionVO> functionVOList = new ArrayList<FunctionVO>();
        if (!functionList.isEmpty() && functionList != null) {
            for (Function function : functionList) {
                FunctionVO functionVO = new FunctionVO();
                functionVO.setFuncName(function.getFuncname());
                functionVO.setFuncNote(function.getFuncnote());
                functionVO.setFuncType(function.getFunctype());
                functionVO.setFuncUrl(function.getFuncurl());
                functionVO.setId(function.getId());
                functionVO.setStatus(function.getStatus().toString());
                if (function.getFunction() != null) {
                    functionVO.setParentId(function.getFunction().getId());
                } else {
                    functionVO.setParentId(null);
                }
                functionVOList.add(functionVO);
            }
        }
        return functionVOList;
    }

    @Override
    public FunctionVO getOne(String id) {
        Function function = functionDao.getOne(id);
        if (function != null) {
            FunctionVO functionVO = FunctionVO.fromFunction(function);
            return functionVO;
        }
        return null;
    }

    @Override
    public List<Function> getAllFunction() {
        return functionDao.getAllFunction();
    }

    @Override
    public Function saveFunction(FunctionVO functionVO) {
        if (functionVO != null) {
            Function function = new Function();
            if (functionVO.getId() != null && !functionVO.getId().isEmpty()) {
                function.setId(functionVO.getId());
            } else {
                function.setId(null);
            }
            function.setFuncname(functionVO.getFuncName());
            function.setFuncurl(functionVO.getFuncUrl());
            function.setFunccode(functionVO.getFuncCode());
            if (functionVO.getFuncType() != null) {
                function.setFunctype(functionVO.getFuncType());
            } else {
                function.setFunctype(null);
            }
            function.setFunction(functionDao.getOne(functionVO.getParentId()));
            if (functionVO.getSortNum() != null && !functionVO.getSortNum().isEmpty()) {
                function.setSortnum(Integer.parseInt(functionVO.getSortNum()));
            } else {
                function.setSortnum(null);
            }
            function.setStatus(Integer.parseInt(functionVO.getStatus()));
            function.setFuncnote(functionVO.getFuncNote());
            function.setUserByCreateby(userDao.userNameCheck(functionVO.getCreateByUserName()));
            function.setCreatetime(DateUtil.parseDate(functionVO.getCreateTime(), "yyyy-MM-dd HH-mm-ss"));
            return function;
        }
        return null;
    }

    @Override
    public void saveFunction(Function function) {
        functionDao.saveFunction(function);
    }

    @Override
    public void updateFunction(Function function) {
        functionDao.update(function);
    }

    @Override
    public void deleteFunction(String id) {
        functionDao.deleteFunction(id);
    }


}
