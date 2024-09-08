package com.cwjy.bs.orm.dto;

import java.io.Serializable;
import java.util.Date;

import com.cwjy.bs.common.BeanUtilDto;
import com.cwjy.bs.orm.entity.CommodityEntity;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class ShoppingCart extends BeanUtilDto implements Serializable {


    /**
     * 销售价格
     */
    private String payment;

    /**
     * 邮费
     */
    private String post_fee;

    /**
     * 商品ID
     */
    private String commodity_id;

    /**
     * 留言
     */
    private String buyer_message;

    /**
     * 商品类型
     */
    private String commodity_type;

    /**
     * 收货地址ID
     */
    private String order_shipping_id;

    /**
     * 数量
     */
    private Integer commodity_num;

    /**
     * 商品信息
     */
    private CommodityEntity commodityEntity;

    private static final long serialVersionUID = 1L;
}