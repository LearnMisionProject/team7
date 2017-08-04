package com.web.vo;


import com.web.system.entity.Dict;
import com.web.system.entity.DictType;

/**
 * Created by Administrator on 2017/7/31.
 */
public class DictVO {

    private String id;
    private String dictTypeId;
    private String dictTypeName;
    private String dictcode;
    private String dictname;
    private String dictnote;
    private String dictvalue;

    /**
     * dict to dictvo
     * @param dict
     * @return
     */
    public static DictVO fromDict(Dict dict) {
        DictVO dictVO = null;
        if (dict != null) {
            dictVO = new DictVO();
            dictVO.setId(dict.getId());
            dictVO.setDictcode(dict.getDictcode());
            dictVO.setDictname(dict.getDictname());
            dictVO.setDictnote(dict.getDictnote());
            if (dict.getDictType() != null) {
                dictVO.setDictTypeName(dict.getDictType().getTypename());
                dictVO.setDictTypeId(dict.getDictType().getId());
            }
            dictVO.setDictvalue(dict.getDictvalue());
        }
        return dictVO;
    }

    /**
     * dictvo to dict
     * @param dictVO
     * @return
     */
    public static Dict fromDictVO(DictVO dictVO, DictType dictType) {
        Dict dict = null;
        if (dictVO != null) {
            dict = new Dict();
            dict.setDictcode(dictVO.getDictcode());
            dict.setDictname(dictVO.getDictname());
            dict.setDictnote(dictVO.getDictnote());
            dict.setDictType(dictType);
            dict.setDictvalue(dictVO.getDictvalue());
            dict.setId(dictVO.getId());
        }
        return dict;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(String dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDictcode() {
        return dictcode;
    }

    public void setDictcode(String dictcode) {
        this.dictcode = dictcode;
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname;
    }

    public String getDictnote() {
        return dictnote;
    }

    public void setDictnote(String dictnote) {
        this.dictnote = dictnote;
    }

    public String getDictvalue() {
        return dictvalue;
    }

    public void setDictvalue(String dictvalue) {
        this.dictvalue = dictvalue;
    }
}
