package com.cwjy.bs.orm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xgp
 * @version 1.0
 * @date 3/17 16:42
 * @table
 * @description
 */
@Data
public class UserPasswordEntity implements Serializable {
    private static final long serialVersionUID = 1096585876441346259L;
    private String username;
    private String old_password;
    private String new_password;
    private String qr_new_nassword;
}
