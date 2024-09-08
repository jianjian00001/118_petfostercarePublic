package com.cwjy.bs.orm.dto;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 * 
 */
@Data
public class Role extends BeanUtilDto implements Serializable {

    /**
     * 菜单名称
     */
    private String role_name;


    private static final long serialVersionUID = 1L;
}