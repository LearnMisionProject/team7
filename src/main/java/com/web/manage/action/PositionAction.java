package com.web.manage.action;

import com.web.base.action.BaseAction;
import com.web.manage.entity.Department;
import com.web.manage.entity.Position;
import com.web.manage.service.DepartmentSerivce;
import com.web.manage.service.PositionService;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.PositionVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */
@ParentPackage("struts-default")
@Namespace("/manage/position")
public class PositionAction extends BaseAction {

    @Autowired
    private PositionService positionService;

    @Autowired
    private DepartmentSerivce departmentSerivce;

    private String name;

    private PositionVO positionVO;

    private List<Position> list;

    private List<Department> dl;

    private String  positionId;

    private String positionIds;


    @Action(value = "PositionAction_list",results ={
            @Result(location = "list_position.jsp")
    })
    public String positionManage() {
        return SUCCESS;
    }

    //分页

    @Action("PositionAction_list1")
    public void findByPage() throws IOException {
        Pager pager = positionService.getPositionListByPage(page,rows,name);
        resultData = ResultData.buildSuccessResult("获取列表成功",pager);
        printJSONObject(resultData,new String[]{});
    }

    //新增的保存
    @Action(value = "Position_save")
    public void save() throws IOException {
        Department department = departmentSerivce.get(positionVO.getDepartmentParentId());
        Position position2 = positionService.get(positionVO.getPositionTopId());
        Position position = PositionVO.fromPositionVO(positionVO, department, position2);
        if(positionVO.getPositionid()!=null && !"".equals(positionVO.getPositionid())){
            positionService.update(position);
        } else {
            positionService.save(position);
        }
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }


    //修改的页面
    @Action(value = "toEditPage",results = {
            @Result(name = "success",location = "edit_position.jsp")
})
    public String edit() {
        if (positionId != null && !positionId.isEmpty()){
            positionVO = positionService.getPositionVO(positionId);
        }
        list = positionService.getAll();
        dl = departmentSerivce.getAll();
        return  SUCCESS;
    }

    //删除
    @Action("PositionAction_delete")
    public void  delete () throws IOException {
        boolean status = positionService.deleteByIds(positionIds);
        if (status) {
            resultData = ResultData.buildSuccessResult("删除成功");
        } else {
            resultData = ResultData.buildFailureResult("删除失败");
        }
        printJSONObject(resultData);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PositionVO getPositionVO() {
        return positionVO;
    }

    public void setPositionVO(PositionVO positionVO) {
        this.positionVO = positionVO;
    }

    public List<Position> getList() {
        return list;
    }

    public void setList(List<Position> list) {
        this.list = list;
    }

    public List<Department> getDl() {
        return dl;
    }

    public void setDl(List<Department> dl) {
        this.dl = dl;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(String positionIds) {
        this.positionIds = positionIds;
    }
}
