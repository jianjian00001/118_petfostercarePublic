package com.cwjy.bs.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author xgp
 * @version 1.0
 * @date 3/15 16:57
 * @table
 * @description
 */
@Data
public class BeanUtilDto implements Serializable {

    private static final long serialVersionUID = 7105598389519415329L;
    /**
     * 主键id
     */
    private String id;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date create_date;

    /**
     * 创建人
     */
    private String create_user;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date update_date;

    /**
     * 修改人
     */
    private String update_user;

    /**
     * 状态(0删除 1未删除)
     */
    private Integer status;

    public void initSaveAndStatus(String name){
        this.id = UUID.randomUUID().toString().replaceAll("-","");
        this.create_date = new Date();
        this.update_date = new Date();
        this.create_user = name;
        this.update_user = name;
        this.status = 1;
    }

    public void initSave(String name){
        this.id = UUID.randomUUID().toString().replaceAll("-","");
        this.create_date = new Date();
        this.update_date = new Date();
        this.create_user = name;
        this.update_user = name;
    }

    public void initUpdate(String name){
        this.update_date = new Date();
        this.update_user = name;
    }
    public void initSaveId(){
        this.id = UUID.randomUUID().toString().replaceAll("-","");
    }
    public void initSaveIdAndStatus(){
        this.id = UUID.randomUUID().toString().replaceAll("-","");
        this.status = 1;
    }


}
