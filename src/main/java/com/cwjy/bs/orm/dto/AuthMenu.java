package com.cwjy.bs.orm.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 * 
 */
@Data
public class AuthMenu implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String menu_name;

    /**
     * 菜单路径
     */
    private String menu_url;

    /**
     * 菜单图标
     */
    private String menu_icon;

    /**
     * 标识
     */
    private String tags;

    /**
     * 1目录 0 菜单
     */
    private Integer is_directory;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父类
     */
    private Integer top;

    /**
     * 权限
     */
    private String role_code;

    /**
     * 是否有权限
     */
    private Integer is_auth;

    /**
     * 菜单ID
     */
    private Integer menu_id;

    private static final long serialVersionUID = 1L;
}