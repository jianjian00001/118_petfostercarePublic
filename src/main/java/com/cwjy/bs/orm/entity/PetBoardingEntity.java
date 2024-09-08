package com.cwjy.bs.orm.entity;

import com.cwjy.bs.common.BeanUtilDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * 
 */
@Data
public class PetBoardingEntity extends BeanUtilDto implements Serializable {


    /**
     * 主人名称
     */
    private String master_name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 家庭住址
     */
    private String address_home;

    /**
     * 寄养开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date foster_care_start_time;

    /**
     * 寄养预计结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date foster_care_end_time;

    /**
     * 宠物类型
     */
    private Integer pet_type;

    /**
     * 其他类型
     */
    private String other_type;

    /**
     * 是否注射狂犬疫苗
     */
    private Integer is_rabies_vaccine;

    /**
     * 是否发情或怀孕
     */
    private Integer is_pregnancy_or_estrus;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 物品清单
     */
    private String checklist;

    /**
     * 预约时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date reservation_time;

    /**
     * 完成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date complete_time;


    /**状态名称*/
    private String status_name;

    private static final long serialVersionUID = 1L;
}