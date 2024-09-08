package com.cwjy.bs.orm.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class OrderShippingItem implements Serializable {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 订单ID
     */
    private String order_id;

    /**
     * 地址ID
     */
    private String order_shipping_id;

    private static final long serialVersionUID = 1L;
}