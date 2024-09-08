package com.cwjy.bs.orm.entity;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 * 
 */
@Data
public class RoleEntity extends BeanUtilDto implements Serializable {

    /**
     * 菜单名称
     */
    private String role_name;
    /**
     * 第几页
     */
    private Integer left;
    /**
     * 多少个
     */
    private Integer right;



    private static final long serialVersionUID = 1L;
}