package com.cwjy.bs.orm.entity;

import com.cwjy.bs.common.BeanUtilDto;
import com.cwjy.bs.orm.dto.OrderItem;
import com.cwjy.bs.orm.dto.OrderShipping;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 
 * 
 */
@Data
public class OrderEntity extends BeanUtilDto implements Serializable {


    /**
     * 实付金额
     */
    private BigDecimal payment;

    /**
     * 支付类型
     */
    private Integer payment_type;

    /**
     * 邮费
     */
    private BigDecimal post_fee;

    /**
     * 状态 1 未付款 2已付款 3 未发货 4 已发货 5交易成功 6交易关闭
     */
    private Integer status;

    /**
     * 付款时间
     */
    private Date payment_time;

    /**
     * 发货时间
     */
    private Date consigo_time;

    /**
     * 交易完成时间
     */
    private Date end_time;

    /**
     * 交易关闭时间
     */
    private Date close_time;

    /**
     * 物流名称
     */
    private String shipping_name;

    /**
     * 物流单号
     */
    private String shipping_code;

    /**
     * 用户ID
     */
    private String user_id;

    /**
     * 买家留言
     */
    private String buyer_message;

    /**
     * 买家昵称
     */
    private String buyer_nick;

    /**
     * 买家是否评价
     */
    private Integer buyer_rate;

    /**
     * 商品ID
     */
    private String commodity_id;

    /**
     * 商品详细类型
     */
    private String commodity_type;

    /**
     * 收货地址ID
     */
    private String order_shipping_id;

    /**物流详细*/
    private OrderShippingEntity orderShippingEntity;

    /**订单商品详细*/
    private List<OrderItemEntity> orderItemEntity;

    /**订单退款详细*/
    private OrderReturnEntity orderReturnEntity;

    /**状态名称*/
    private String statusName;
    /**
     *物流 类型
     */
    private String shipping_type;

    /**
     *商品详细
     */
    private List<OrderItem> OrderItem;

    private static final long serialVersionUID = 1L;
}