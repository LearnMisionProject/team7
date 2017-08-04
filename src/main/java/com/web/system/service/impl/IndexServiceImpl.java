package com.web.system.service.impl;

import com.web.system.dao.FunctionDao;
import com.web.system.dao.RoleDao;
import com.web.system.entity.Function;
import com.web.system.entity.Role;
import com.web.system.entity.User;
import com.web.system.service.IndexService;
import com.web.vo.IndexVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private RoleDao roleDao;
    @Resource
    private FunctionDao functionDao;

    @Override
    public List<IndexVO> getIndex(User user) {

        //通过用户查询出对应的角色集合
        List<Role> roleList = roleDao.getRole(user);

        if (roleList == null || roleList.isEmpty()) {
            return null;
        }
        String[] id = new String[roleList.size()];

        //遍历roleList获取id值
        for(int i = 0; i < roleList.size(); i++) {
            id[i] = roleList.get(i).getId();
        }

        //通过角色ID查询出对应的权限集合
        //functype=1 代表是菜单,0代表按钮
        Integer functype = 1;
        List<Function> functionList = functionDao.getFunc(functype, id);
        List<IndexVO> indexVOList = new ArrayList<IndexVO>();
        //写入到InexVO中
        if (functionList != null && !functionList.isEmpty()) {
            for (Function fun : functionList) {
                IndexVO indexVO = new IndexVO();
                indexVO.setId(fun.getId());
                indexVO.setName(fun.getFuncname());
                indexVO.setUrl(fun.getFuncurl());
                if (fun.getFunction() != null) {
                    indexVO.setpId(fun.getFunction().getId());
                } else {
                    indexVO.setpId(null);
                    indexVO.setOpen(true);
                }
                indexVOList.add(indexVO);
            }
        }
        return indexVOList;
    }
}
