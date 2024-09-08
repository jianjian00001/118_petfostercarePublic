package com.cwjy.bs.orm.mapper;

import com.cwjy.bs.orm.dto.AuthMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthMenuMapper {
   List<AuthMenu> getAll(@Param("role_code") String role_code);

   List<AuthMenu> getNoDirectory(@Param("role_code") String role_code, @Param("top") int top);

   int insert(List<AuthMenu> list);

   List<AuthMenu> getAllData(@Param("role_code") String role_code);

   int updateAuth(List<AuthMenu> list);

   AuthMenu selectById(int id);

}