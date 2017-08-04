package com.web.vo;

import com.web.system.entity.Function;

import java.util.List;

import com.web.system.entity.Role;
import com.web.util.DateUtil;

import java.util.ArrayList;
import java.util.Set;
/**
 * Created by Administrator on 2017/8/1.
 */
public class FunctionVO {

        private String id;
        private String funcName;
        private String funcCode;
        private Integer funcType;
        private String funcUrl;
        private String funcNote;
        private String createByUserName;
        private String createTime;
        private String updateByUserName;
        private String updateTime;
        private String status;
        private String parentId;
        private String parentName;
        private String sortNum;
        private String iconclass;
        private String iconurl;
        private List rolesNames;
        private List functionIds;

        public List getRolesNames() {
            return rolesNames;
        }

        public void setRolesNames(List rolesNames) {
            this.rolesNames = rolesNames;
        }

        public List getFunctionIds() {
            return functionIds;
        }

        public void setFunctionIds(List functionIds) {
            this.functionIds = functionIds;
        }

        public  static FunctionVO fromFunction(Function function) {
            if (function != null) {
                FunctionVO functionVO = new FunctionVO();
                functionVO.setId(function.getId());
                functionVO.setFuncName(function.getFuncname());
                functionVO.setFuncNote(function.getFuncnote());
                functionVO.setCreateTime(DateUtil.formatDate(function.getCreatetime(), "yyyy-MM-dd HH-mm-ss"));
                functionVO.setFuncType(function.getFunctype());
                functionVO.setFuncUrl(function.getFuncurl());
                functionVO.setStatus(function.getStatus().toString());
                functionVO.setFuncCode(function.getFunccode());
                if(function.getSortnum() != null){
                    functionVO.setSortNum(function.getSortnum().toString());
                }else{
                    functionVO.setSortNum(null);
                }
                functionVO.setUpdateTime(DateUtil.formatDate(function.getUpdatetime(), "yyyy-MM-dd HH-mm-ss"));
                functionVO.setIconclass(function.getIconclass());
                functionVO.setIconurl(function.getIconurl());

                if (function.getUserByCreateby() != null) {
                    functionVO.setCreateByUserName(function.getUserByCreateby().getUsername());
                } else {
                    functionVO.setCreateByUserName(null);
                }
                if (function.getUserByUpdateby() != null) {
                    functionVO.setUpdateByUserName(function.getUserByUpdateby().getUsername());
                } else {
                    functionVO.setUpdateByUserName(null);
                }
                if (function.getFunction() != null) {
                    functionVO.setParentId(function.getFunction().getId());
                    functionVO.setParentName(function.getFunction().getFuncname());
                } else {
                    functionVO.setParentId(null);
                    functionVO.setParentName(null);
                }
                if (function.getRoles() != null){
                    Set<Role> roles = function.getRoles();
                    List roleName = new ArrayList();
                    for(Role role : roles){
                        if (role.getRolename() != null){
                            roleName.add(role.getRolename());
                        }
                    }
                    functionVO.setRolesNames(roleName);
                }else {
                    functionVO.setRolesNames(null);
                }
                if (function.getFunctions() != null){
                    Set<Function> functions = function.getFunctions();
                    List functionId = new ArrayList();
                    for (Function fun :functions){
                        if (fun != null){
                            functionId.add(fun.getId());
                        }
                    }
                    functionVO.setFunctionIds(functionId);
                }else{
                    functionVO.setFunctionIds(null);
                }

                return functionVO;
            }
            return null;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFuncName() {
            return funcName;
        }

        public void setFuncName(String funcName) {
            this.funcName = funcName;
        }

        public Integer getFuncType() {
            return funcType;
        }

        public void setFuncType(Integer funcType) {
            this.funcType = funcType;
        }

    public String getFuncUrl() {
            return funcUrl;
        }

        public void setFuncUrl(String funcUrl) {
            this.funcUrl = funcUrl;
        }

        public String getFuncNote() {
            return funcNote;
        }

        public void setFuncNote(String funcNote) {
            this.funcNote = funcNote;
        }

        public String getCreateByUserName() {
            return createByUserName;
        }

        public void setCreateByUserName(String createByUserName) {
            this.createByUserName = createByUserName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateByUserName() {
            return updateByUserName;
        }

        public void setUpdateByUserName(String updateByUserName) {
            this.updateByUserName = updateByUserName;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getFuncCode() {
            return funcCode;
        }

        public void setFuncCode(String funcCode) {
            this.funcCode = funcCode;
        }

        public String getSortNum() {
            return sortNum;
        }

        public void setSortNum(String sortNum) {
            this.sortNum = sortNum;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public String getIconclass() {
            return iconclass;
        }

        public void setIconclass(String iconclass) {
            this.iconclass = iconclass;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }
    }


