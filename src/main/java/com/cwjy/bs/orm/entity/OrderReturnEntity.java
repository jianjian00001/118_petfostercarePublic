package com.cwjy.bs.orm.entity;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * 
 */
@Data
public class OrderReturnEntity extends BeanUtilDto implements Serializable {

    /**
     * 状态 1 申请中 0拒绝 2等待输入 3 运输中 4已完成 
     */
    private Integer status;

    /**
     * 状态 1 申请中 0拒绝 2等待输入 3 运输中 4已完成
     */
    private String statusName;

    /**
     * 订单ID
     */
    private String order_id;

    /**
     * 退款类型 1仅退款 2退货退款
     */
    private Integer refund_type;

    /**
     * 物流单号
     */
    private String shipment_number;

    /**
     * 退款说明
     */
    private String refund_instructions;

    /**
     * 商品ID
     */
    private String commodity_id;

    private static final long serialVersionUID = 1L;
}