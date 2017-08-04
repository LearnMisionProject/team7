package com.web.system.action;

import com.web.base.action.BaseAction;
import com.web.system.entity.DictType;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.DictTypeVO;
import com.web.vo.DictVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;
import java.util.List;

@ParentPackage("struts-default")
@Namespace("/system/dict")
public class DictAction extends BaseAction {

    private DictVO dictVO;
    private String dictIds;

    /**
     * 跳转到字典主页
     * @return
     */
    @Action(value = "DictAction_index", results = {
            @Result(location = "/WEB-INF/content/system/dict/index_dict.jsp")
    })
    public String getDict() {
        return SUCCESS;
    }

    /**
     * 获取下拉菜单
     */
    @Action(value = "DictTypeAction_findAll")
    public void getDictAll() throws IOException {
        List<DictTypeVO> dictTypeVOList = dictTypeService.getMenuList();
        printJSONObject(ResultData.buildSuccessResult("获取下拉菜单", dictTypeVOList));
    }

    /**
     * 字典分页查询
     * @throws IOException
     */
    @Action(value = "DictAction_findByDictTypeId")
    public void dictList() throws IOException {
        if ("ACEAF0031E2C4F92B16EAB5F5D923DE7".equals(dictTypeVO.getId())) {
            dictTypeVO.setId("");
        }
        Pager pager = dictService.getfromDictTypeId(page, rows, dictTypeVO.getId());
        resultData = ResultData.buildSuccessResult("获取分页列表", pager);
        printJSONObject(resultData);
    }

    /**
     * 跳转到新增or修改
     * @return
     */
    @Action(value = "DictAction_edit", results = {
            @Result(location = "edit_dict.jsp")
    })
    public String toEdit() {
        if (dictVO.getId() != null && !"".equals(dictVO.getId())) {
            dictVO = dictService.getFromId(dictVO.getId());
        }
        return SUCCESS;
    }

    /**
     * 新增or修改
     */
    @Action(value = "DictAction_saveOrUpdate")
    public void saveOrEdit() throws IOException {
        DictType dictType = dictTypeService.returnDictType(dictVO.getDictTypeId());
        if (dictVO.getId() != null && !"".equals(dictVO.getId())) {
            dictService.editFromDictVO(dictVO, dictType);
        } else {
            dictService.saveFromDictVO(dictVO, dictType);
        }
        printJSONObject(ResultData.buildSuccessResult());
    }

    /**
     * 删除
     */
    @Action(value = "DictAction_remove")
    public void del() throws IOException {
        boolean status = dictService.deleteByIds(dictIds);
        if (status) {
            resultData = ResultData.buildSuccessResult("删除成功");
        } else {
            resultData = ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }

    public DictVO getDictVO() {
        return dictVO;
    }

    public void setDictVO(DictVO dictVO) {
        this.dictVO = dictVO;
    }

    public String getDictIds() {
        return dictIds;
    }

    public void setDictIds(String dictIds) {
        this.dictIds = dictIds;
    }
}
