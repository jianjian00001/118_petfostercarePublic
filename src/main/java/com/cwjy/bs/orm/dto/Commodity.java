package com.cwjy.bs.orm.dto;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 
 * 
 */
@Data
public class Commodity extends BeanUtilDto implements Serializable {

    /**
     * 商品名称
     */
    private String product_name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 促销价格
     */
    private BigDecimal sales_price;

    /**
     * 销售数量
     */
    private Integer sales_volume;

    /**
     * 评价数量
     */
    private Integer evaluation;

    /**
     * 积分
     */
    private Integer integral;

    /**
     * 类别ID
     */
    private String category_details;

    /**
     * 类别名称
     */
    private String category_details_name;

    /**
     * 商品图片路径
     */
    private String image_path;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 邮费
     */
    private Integer post_fee;

    /**类型详细*/
    private List<ClassificationDetailed> classificationDetailedList;



    private static final long serialVersionUID = 1L;
}