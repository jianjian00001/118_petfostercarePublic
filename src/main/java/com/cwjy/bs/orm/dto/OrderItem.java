package com.cwjy.bs.orm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class OrderItem implements Serializable {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 商品ID
     */
    private String item_id;

    /**
     * 订单ID
     */
    private String order_id;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 商品总金额
     */
    private BigDecimal totle_fee;

    /**
     * 商品图片
     */
    private String pic_path;

    /**
     * 商品详细
     */
    private String pic_type;

    private static final long serialVersionUID = 1L;
}