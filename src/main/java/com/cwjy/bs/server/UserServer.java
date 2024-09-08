package com.cwjy.bs.server;


import com.cwjy.bs.orm.dto.User;
import com.cwjy.bs.orm.entity.AdminEntity;
import com.cwjy.bs.orm.entity.UserEntity;
import com.cwjy.bs.orm.entity.UserPasswordEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author xgp
 * @version 1.0
 * @date 2021/3/15 17:39
 * @table
 * @description
 */
public interface UserServer {
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
     * 获取所有用户信息
     *
     * @param record: 获取所有数据参数
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/15 17:40
     */
    List<User> getAll(UserEntity record);

    /**
     * 验证登录是否成功
     *
     * @param userEntity: 前端传输账号密码
     * @param request: 请求参数内容
     * @param response: 返回参数内容
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/17 10:28
     */
    int login(UserEntity userEntity, HttpServletRequest request, HttpServletResponse response);
    int loginAdmin(AdminEntity adminEntity, HttpServletRequest request, HttpServletResponse response);
    /**
     * 修改密码
     *
     * @param entity: 需要修改的用户
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/17 10:28
     */
    int updatePassword(UserPasswordEntity entity);

    /**
     * 修改头像
     *
     * @param entity: 修改头像
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/17 10:28
     */
    int updateImages(UserEntity entity);


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
