package com.web.system.dao;

import com.web.base.dao.BaseDao;
import com.web.system.entity.Function;
import com.web.system.entity.Role;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
public interface FunctionDao extends BaseDao<Function, String>{

    List<Function> getFunc(Integer functype, String... id);

    List<Function> getAssignList(String id);

    List<Function> getFunctionByRoleId(String...roleIds);

    Function getOne(String id);

    List<Function> getAllFunction();

    void saveFunction(Function function);
    void updateFunction(Function function);
    void deleteFunction(String id);

}
