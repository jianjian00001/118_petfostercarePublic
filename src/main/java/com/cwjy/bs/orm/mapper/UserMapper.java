package com.cwjy.bs.orm.mapper;

import com.cwjy.bs.orm.dto.User;
import com.cwjy.bs.orm.entity.AdminEntity;
import com.cwjy.bs.orm.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
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
    int insert(UserEntity record);

    /**
     * 增加部分数据进用户表
     *
     * @param record: 增加用户相关数据部分
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int insertSelective(UserEntity record);

    /**
     * 通过ID查询数据
     *
     * @param id: 用户主键唯一ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    User selectByPrimaryKey(String id);

    /**
     * 分页查询数据
     *
     * @param record: 用户主键唯一ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    List<User> getPage(UserEntity record);


    /**
     * 修改部分数据
     *
     * @param record: 修改用户相关数据部分
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int updateByPrimaryKeySelective(UserEntity record);

    /**
     * 修改全部数据
     *
     * @param record: 修改用户全部数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int updateByPrimaryKey(UserEntity record);

    /**
     * 查询当前插入用户是否存在
     *
     * @param username: 用户名
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int selectByName(String username);



    /**
     * 查询当前插入用户是否存在
     *
     * @param username: 用户名
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    User selectByNameUser(String username);

    /**
     * 获取所有用户信息
     *
     * @param record: 请求参数
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    List<User> getAll(UserEntity record);

    /**
     * 登录
     *
     * @param record: 请求参数账号密码
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int login(UserEntity record);

    int loginAdmin(AdminEntity adminEntity);
    /**
     * 登录
     *
     * @param record: 请求参数账号密码
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int updatePassword(UserEntity record);

    /**
     * 修改头像
     *
     * @param record: 修改头像参数
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    int updateImages(UserEntity record);



    /**
     * 查询当前用户详细信息
     *
     * @param username: 用户名
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    User getUsername(String username);

}