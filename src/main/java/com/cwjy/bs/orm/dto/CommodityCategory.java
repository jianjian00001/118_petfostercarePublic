package com.cwjy.bs.orm.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class CommodityCategory extends BeanUtilDto implements Serializable {




    /**
     * 类型
     */
    private String type_name;


    /**
     * 类别ID
     */
    private String category_details_id;




    private static final long serialVersionUID = 1L;
}