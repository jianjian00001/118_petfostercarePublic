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
public class ClassificationDetailedEntity extends BeanUtilDto implements Serializable {




    /**
     * 类型详细
     */
    private String type_detailed;

    /**
     * 类型ID
     */
    private String commodity_category_id;


    /**
     * 商品ID
     */
    private String commodity_id;

    private static final long serialVersionUID = 1L;
}