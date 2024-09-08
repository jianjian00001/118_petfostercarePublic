package com.cwjy.bs.orm.entity;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 
 * 
 */
@Data
public class ProductReviewsCommodityEntity extends BeanUtilDto implements Serializable {


    /**
     * 商品ID
     */
    private String commodity_id;

    /**
     * 评论内容
     */
    private String information;

    /**
     * 评论人
     */
    private String commentator;

    /**
     * 接收人
     */
    private String receiver;

    /**
     * 父类ID
     */
    private String parent_node;

    /**
     * 订单ID
     */
    private String order_id;

    /**
     * 描述相符分数
     */
    private Integer descriptive_match_score;

    /**
     * 物流服务分数
     */
    private Integer logistics_service_score;

    /**子类详细评价*/
    private List<ProductReviewsCommodityEntity> productReviewsList;

    /**用户头像信息*/
    private String userImages;

    private static final long serialVersionUID = 1L;
}