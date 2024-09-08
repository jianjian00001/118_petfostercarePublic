package com.cwjy.bs.orm.mapper;

import com.cwjy.bs.orm.dto.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    
    /** 
     * 获取菜单目录
     *
     * @return: java.util.List<com.cwyy.hospital.orm.dto.Menu>
     * @Author: XGP
     * @Date: 2021/3/16 16:15
     */ 
   List<Menu> getDirectory();
   
   /** 
    * 通过目录ID获取子目录
    *
    * @param id:目录ID
    * @return: java.util.List<com.cwyy.hospital.orm.dto.Menu>
    * @Author: XGP
    * @Date: 2021/3/16 16:15
    */ 
   List<Menu> getNoDirectory(@Param("id") String id);


    /**
     * 获取所有菜单数据
     *
     * @return: java.util.List<com.cwyy.hospital.orm.dto.Menu>
     * @Author: XGP
     * @Date: 2021/3/16 16:15
     */
    List<Menu> getAll();
}