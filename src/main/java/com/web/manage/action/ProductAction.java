package com.web.manage.action;

import com.web.base.action.BaseAction;
import com.web.manage.entity.Product;
import com.web.manage.service.ProductService;
import com.web.system.entity.User;
import com.web.system.service.UserService;
import com.web.util.Pager;
import com.web.util.ResultData;
import com.web.vo.ProductVO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/31.
 */
@Namespace("/manage/product")
@ParentPackage("struts-default")
public class ProductAction extends BaseAction {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    private String name;

    private Double suggestedPrice;

    private ProductVO productVO;

    private String productId;

    private String productIds;



    @Action(value = "ProductAction_list",results = {
            @Result(location = "list_product.jsp")
    })
    public String productManage() {
        return SUCCESS;
    }

    //分页
    @Action("ProductAction_findByPage")
    public void findByPage() throws IOException {
        if(name==null){
            name="";
        }
        Pager pager = productService.getProductListByPage(page,rows,name,suggestedPrice);
        resultData = ResultData.buildSuccessResult("获取列表成功",pager);
        printJSONObject(resultData);
    }


    //去添加或修改的页面
    @Action(value = "ProductAction_edit",results = {
            @Result(name = "success",location = "edit_product.jsp")
    })
    public String add() {
        if(productId!=null && !productId.isEmpty()) {
            productVO = productService.getProductVO(productId);
        }
        return SUCCESS;
    }


    //添加的保存按钮
    @Action(value = "ProductAction_save")
    public void save() throws IOException {
        User user = (User)getSession().getAttribute("user");
        Product product = productVO.fromProductVO(productVO,user);
        if(productVO.getProductid()!=null && !"".equals(productVO.getProductid())){
            productService.update(product);
        }else {
            productService.save(product);
        }
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }




    @Action("ProductAction_remove")
    public void delete() throws IOException {
        boolean status = productService.deleteByIds(productIds);
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

    public Double getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(Double suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }
}
