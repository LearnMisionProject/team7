package com.web.system.action;

import com.web.base.action.BaseAction;
import com.web.system.entity.DictType;
import com.web.system.entity.User;
import com.web.system.service.DictTypeService;
import com.web.util.ResultData;
import com.web.vo.DictTypeVO;
import org.apache.struts2.convention.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@ParentPackage("struts-default")
@Namespace("/system/dicttype")
public class DictTypeAction extends BaseAction {

    /**
     * 获取字典类型
     */
    @Action(value = "DictTypeAction_findAll")
    public void DictTypeAction_findAll() throws IOException {
        List<DictTypeVO>  dictTypeVOList = dictTypeService.getAllList();
        resultData = ResultData.buildSuccessResult("查询列表", dictTypeVOList);
        printJSONObject(resultData);
    }

    /**
     * 跳转到编辑页面
     */
    @Action(value = "DictTypeAction_edit", results = {
            @Result(location = "/WEB-INF/content/system/dict/edit_dictType.jsp")
    })
    public String DictTypeAction_edit() {
        if ("ACEAF0031E2C4F92B16EAB5F5D923DE7".equals(dictTypeVO.getId())) {
            dictTypeVO.setId("");
        }
        if (!"".equals(dictTypeVO.getId())) {
            dictTypeVO = dictTypeService.getFromId(dictTypeVO.getId());
        }
        return SUCCESS;
    }

    /**
     * 修改or新增
     * @throws IOException
     */
    @Action(value = "saveDictType")
    public void saveDictType() throws IOException {
        User user = (User) getSession().getAttribute("user");
        if ("ACEAF0031E2C4F92B16EAB5F5D923DE7".equals(dictTypeVO.getId())) {
            dictTypeVO.setId("");
        }
        if (!"".equals(dictTypeVO.getId())) {
            dictTypeService.editDictType(dictTypeVO, user);
        } else {
            dictTypeService.saveDictType(dictTypeVO, user);
        }
        printJSONObject(ResultData.buildSuccessResult());
    }

    /**
     * 删除
     * @throws IOException
     */
    @Action(value = "DictTypeAction_remove")
    public void del() throws IOException {
       boolean status = dictTypeService.deleteByIds(dictTypeVO.getId());
       if (status) {
           printJSONObject(ResultData.buildSuccessResult());
       } else {
           printJSONObject(ResultData.buildFailureResult("删除失败,有关联字段无法删除"));
       }
    }

}
