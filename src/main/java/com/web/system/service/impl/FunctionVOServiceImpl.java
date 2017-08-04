package com.web.system.service.impl;

import com.web.system.dao.FunctionDao;
import com.web.system.dao.RoleDao;
import com.web.system.entity.Function;
import com.web.system.entity.Role;
import com.web.system.entity.User;
import com.web.system.service.FunctionVOService;
import com.web.vo.FunctionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
@Service
public class FunctionVOServiceImpl implements FunctionVOService {


    @Autowired
    private FunctionDao functionDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<FunctionVO> getFunctionListVO(User user) {
        //通过user查角色
        List<Role> roles = roleDao.getRole(user);
        String[] roleIds = new String[roles.size()];
        for (int i=0;i<roles.size();i++){
            roleIds[i]=roles.get(i).getId();
        }
        //通过角色id查权限
        List<Function> funcs = functionDao.getFunctionByRoleId(roleIds);


        //将权限集合转成菜单集合
        List<FunctionVO> functionVOS = new ArrayList<FunctionVO>();
        if (funcs != null && funcs.size()>0){
            for (Function function : funcs){
                FunctionVO functionVO = FunctionVO.fromFunction(function);
                functionVOS.add(functionVO);
            }
        }
        return functionVOS;


    }
}
