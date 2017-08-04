package com.web.vo;

import com.web.manage.entity.Product;
import com.web.system.entity.User;
import com.web.util.DateUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/31.
 */
public class ProductVO {
        private String productid;
        private String name;
        private String link;
        private String updateTime;
        private String createTime;
        private Double costPrice;
        private Double suggestedPrice;
        private String userId;  //创建人的id
        private String userName;    //创建人的姓名


    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(Double suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //将product对象转化为productVO对象的方法
    public static ProductVO fromProduct(Product product){
        if(product!=null) {
            ProductVO productVO = new ProductVO();
            productVO.setProductid(product.getProductid());
            productVO.setLink(product.getLink());
            productVO.setName(product.getName());
            productVO.setCostPrice(product.getCostprice());
            productVO.setSuggestedPrice(product.getSuggestedprice());
            productVO.setCreateTime(DateUtil.formatDate(product.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            productVO.setUpdateTime(DateUtil.formatDate(product.getUpdatetime(),"yyyy-MM-dd HH:mm:ss"));
            if(product.getUser()!=null) {
                productVO.setUserId(product.getUser().getId());
                productVO.setUserName(product.getUser().getUsername());
        }
            return productVO;

        }
            return  null;
    }


    public static  Product fromProductVO(ProductVO productVO,User user) {
        if(productVO!= null) {
            Product product = new Product();
            product.setProductid(productVO.getProductid());
            product.setName(productVO.getName());
            product.setCostprice(productVO.getCostPrice());
            product.setSuggestedprice(productVO.getSuggestedPrice());
            product.setLink(productVO.getLink());
            product.setCreatetime(new Date());
            product.setUpdatetime(new Date());
            product.setUser(user);

            return  product;
        }
            return  null;
    }
}
