package com.cwjy.bs.orm.entity;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 * 
 */
@Data
public class OrderShippingEntity extends BeanUtilDto implements Serializable {


    /**
     * 订单ID
     */
    private String order_id;

    /**
     * 收货人姓名
     */
    private String receiver_name;

    /**
     * 固定电话
     */
    private String receiver_phone;

    /**
     * 移动电话
     */
    private String receiver_mobile;

    /**
     * 省会
     */
    private String receiver_state;

    /**
     * 城市
     */
    private String receiver_city;

    /**
     * 区县
     */
    private String receiver_district;

    /**
     * 收货地址
     */
    private String receiver_address;

    /**
     * 邮政编码
     */
    private String receiver_zip;



    private static final long serialVersionUID = 1L;
}