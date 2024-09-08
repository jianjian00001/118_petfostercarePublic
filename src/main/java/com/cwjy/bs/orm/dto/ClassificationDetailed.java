package com.cwjy.bs.orm.dto;

import java.io.Serializable;
import java.util.Date;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class ClassificationDetailed extends BeanUtilDto implements Serializable {

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


    /**
     * 类型详细数组
     */
    private String[] type_detailed_array;

    private static final long serialVersionUID = 1L;
}