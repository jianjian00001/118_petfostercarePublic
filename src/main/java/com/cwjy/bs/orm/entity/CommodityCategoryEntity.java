package com.cwjy.bs.orm.entity;

import com.cwjy.bs.common.BeanUtilDto;
import com.cwjy.bs.orm.dto.ClassificationDetailed;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 * 
 */
@Data
public class CommodityCategoryEntity extends BeanUtilDto implements Serializable {


    /**
     * 类型
     */
    private String type_name;


    /**
     * 类别ID
     */
    private String category_details_id;

    /**商品类型详细*/
    private List<ClassificationDetailedEntity> classificationDetaileds;

    private static final long serialVersionUID = 1L;
}