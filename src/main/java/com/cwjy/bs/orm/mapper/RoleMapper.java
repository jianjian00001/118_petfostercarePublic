package com.cwjy.bs.orm.mapper;

import com.cwjy.bs.orm.dto.Role;
import com.cwjy.bs.orm.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    /**
     * 通过唯一主键ID删除数据
     *
     * @param id: 唯一ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int deleteByPrimaryKey(String id);

    /**
     * 增加数据进用户表
     *
     * @param record: 增加用户相关数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int insert(RoleEntity record);

    /**
     * 增加部分数据进用户表
     *
     * @param record: 增加用户相关数据部分
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int insertSelective(RoleEntity record);

    /**
     * 通过ID查询数据
     *
     * @param id: 用户主键唯一ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    Role selectByPrimaryKey(String id);

    /**
     * 分页查询数据
     *
     * @param record: 用户主键唯一ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    List<Role> getPage(RoleEntity record);


    /**
     * 修改部分数据
     *
     * @param record: 修改用户相关数据部分
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int updateByPrimaryKeySelective(RoleEntity record);

    /**
     * 修改全部数据
     *
     * @param record: 修改用户全部数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int updateByPrimaryKey(RoleEntity record);

    /**
     * 查询当前插入用户是否存在
     *
     * @param roleName: 用户名
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int selectByName(String roleName);


    /**
     * 查询所有的角色信息
     *
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    List<Role> getAll();
}