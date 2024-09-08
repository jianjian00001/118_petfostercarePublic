package com.cwjy.bs.orm.entity;

import com.cwjy.bs.common.BeanUtilDto;
import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class AdminEntity extends BeanUtilDto implements Serializable {
    /**
     * 主键id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
    /**
     * 家庭住址
     */
    private String home_address;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 性别 1 男 2 女
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 第几页
     */
    private Integer left;
    /**
     * 多少个
     */
    private Integer right;
    /**
     * 权限编码
     */
    private String role_code;
    /**
     * 头像路径
     */
    private String images_path;

    private static final long serialVersionUID = 1L;
}