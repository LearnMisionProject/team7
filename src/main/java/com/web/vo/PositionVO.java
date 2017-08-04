package com.web.vo;

import com.web.manage.dao.DepartmentDao;
import com.web.manage.dao.PositionDao;
import com.web.manage.dao.impl.DepartmentDaoImpl;
import com.web.manage.dao.impl.PositionDaoImpl;
import com.web.manage.entity.Department;
import com.web.manage.entity.Position;
import com.web.manage.service.DepartmentSerivce;
import com.web.manage.service.impl.DepartmentSerivceImpl;
import com.web.manage.service.impl.PositionServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/29.
 */
public class PositionVO {


    private String positionid;
    private String name;
    private String departmentName;//所属部门
    private String departmentParentId;
    private String  positiontopName;//岗位管理上级名称
    private String description;//岗位描述
    private String positionTopId; //岗位管理上级id;


    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositiontopName() {
        return positiontopName;
    }

    public void setPositiontopName(String positiontopName) {
        this.positiontopName = positiontopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getPositionTopId() {
        return positionTopId;
    }

    public void setPositionTopId(String positionTopId) {
        this.positionTopId = positionTopId;
    }

    public String getDepartmentParentId() {
        return departmentParentId;
    }

    public void setDepartmentParentId(String departmentParentId) {
        this.departmentParentId = departmentParentId;
    }

    public static PositionVO fromPosition(Position position) {
        if(position!=null) {
            PositionVO positonVO = new PositionVO();
            positonVO.setPositionid(position.getPositionid());
            positonVO.setName(position.getName());
            positonVO.setDescription(position.getDescription());
            if(position.getDepartment() != null) {
                positonVO.setDepartmentName(position.getDepartment().getName());
                positonVO.setDepartmentParentId(position.getDepartment().getDepartmentid());
            }
            if (position.getPosition() != null) {
                positonVO.setPositiontopName(position.getPosition().getName());
                positonVO.setPositionTopId(position.getPosition().getPositionid());
            }
            return positonVO;
        }
        return  null;

    }

    public static Position fromPositionVO(PositionVO positionVO, Department department, Position position2) {
        if (positionVO != null) {
            Position position = new Position();
            position.setPositionid(positionVO.getPositionid());
            position.setName(positionVO.getName());
            position.setDescription(positionVO.getDescription());
    //        if (positionVO.getDepartmentName() != null) {
               /* position.setDepartment(department);*/
/*
            String Did = positionVO.getDepartmentParentId();
            DepartmentSerivce departmentSerivce = new DepartmentSerivceImpl();
            Department department = departmentSerivce.getDById(Did);*/
               position.setDepartment(department);

            /*String pId = positionVO.getPositionTopId();
            PositionServiceImpl positionService = new PositionServiceImpl();
            Position position1 = positionService.get(pId);*/
               position.setPosition(position2);


//              DepartmentDao departmentDao = new DepartmentDaoImpl();
//               Department department = departmentDao.getFromName(positionVO.getDepartmentName());
//               position.setDepartment(department);
//            }
//            if(positionVO.getPositionTopId()!=null){
//               /* position.setPosition();*/
//                PositionDao positionDao = new PositionDaoImpl();
//                position = positionDao.getFormTopId(positionVO.getPositionTopId());
//                position.setPosition(position);
//            }



                 return position;
        }
                 return null;
    }

}
