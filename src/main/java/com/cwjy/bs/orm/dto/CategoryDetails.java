package com.cwjy.bs.orm.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

/**
 * @author
 */
@Data
public class CategoryDetails extends BeanUtilDto implements Serializable {


    /**
     * 类别名称
     */
    private String classification_name;

    /**
     * 类型参数
     */
    private String[] commodityCategory;


    private static final long serialVersionUID = 1L;
}