package com.cwjy.bs.orm.entity;

import com.cwjy.bs.common.BeanUtilDto;
import com.cwjy.bs.orm.dto.CommodityCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 * 
 */
@Data
public class CategoryDetailsEntity extends BeanUtilDto implements Serializable {


    /**
     * 类别名称
     */
    private String classification_name;


    /**
     * 类型参数
     */
    private List<CommodityCategoryEntity> commodityCategory;

    private static final long serialVersionUID = 1L;
}