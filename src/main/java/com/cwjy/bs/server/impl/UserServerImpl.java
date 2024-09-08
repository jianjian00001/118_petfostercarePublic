package com.cwjy.bs.server.impl;

import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.MapperTools;
import com.cwjy.bs.config.BaseException;
import com.cwjy.bs.orm.dto.User;
import com.cwjy.bs.orm.entity.AdminEntity;
import com.cwjy.bs.orm.entity.UserEntity;
import com.cwjy.bs.orm.entity.UserPasswordEntity;
import com.cwjy.bs.server.UserServer;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @author xgp
 * @version 1.0
 * @date 2021/3/15 17:38
 * @table
 * @description
 */
@Service
public class UserServerImpl extends MapperTools implements UserServer {
    @Override
    public int deleteByPrimaryKey(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user.getUsername().equals("admin")){
            throw new BaseException("系统管理员无法进行修改！");
        }
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserEntity record) {
        int i = userMapper.selectByName(record.getUsername());
        if(i > 0){
          throw new RuntimeException("用户名已存在！");
        }
        record.initSave(LoginUtilFinal.map.get(LoginUtilFinal.session+"username"));
        record.setId(UUID.randomUUID().toString().replaceAll("-",""));
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(UserEntity record) {
        record.initSave(LoginUtilFinal.map.get(LoginUtilFinal.session+"username"));
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<User> getPage(UserEntity record) {
        List<User> userMapperPage = userMapper.getPage(record);
        return userMapperPage;
    }

    @Override
    public int updateByPrimaryKeySelective(UserEntity record) {
        User user = userMapper.selectByPrimaryKey(record.getId());
        if(user.getUsername().equals("admin")){
            throw new BaseException("系统管理员无法进行修改！");
        }
        record.initUpdate(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserEntity record) {
        record.initUpdate(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public List<User> getAll(UserEntity record) {
        List<User> userMapperAll = userMapper.getAll(record);
        return userMapperAll;
    }

    @Override
    public int login(UserEntity userEntity, HttpServletRequest request, HttpServletResponse response) {
        int login = userMapper.login(userEntity);
        if(login < 1){
            throw new RuntimeException("账户密码或错误!");
        }
        User user = userMapper.selectByNameUser(userEntity.getUsername());
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String userNameAndPassword = userEntity.getUsername()+userEntity.getPassword();
        String md5Password = DigestUtils.md5DigestAsHex(userNameAndPassword.getBytes());
        LoginUtilFinal.map.put(sessionId + "username",userEntity.getUsername());
        LoginUtilFinal.map.put(sessionId + "password",userEntity.getPassword( ));
        LoginUtilFinal.map.put(sessionId + "md5",md5Password + sessionId);
        session.setAttribute(sessionId + "un",userEntity.getUsername());
        session.setAttribute(sessionId + "token",md5Password);
        Cookie cookie = new Cookie("un",userEntity.getUsername());
        cookie.setPath("/");
        response.addCookie(cookie);
        return login;
    }
    @Override
    public int loginAdmin(AdminEntity adminEntity, HttpServletRequest request, HttpServletResponse response) {
        int login = userMapper.loginAdmin(adminEntity);
        if(login < 1){
            throw new RuntimeException("账户密码或错误!");
        }
        User user = userMapper.selectByNameUser(adminEntity.getUsername());
        HttpSession session = request.getSession();
        String sessionAdminId = session.getId();
        String userNameAndPassword = adminEntity.getUsername()+adminEntity.getPassword();
        String md5Password = DigestUtils.md5DigestAsHex(userNameAndPassword.getBytes());
        LoginUtilFinal.map.put(sessionAdminId + "username",adminEntity.getUsername());
        LoginUtilFinal.map.put(sessionAdminId + "password",adminEntity.getPassword( ));
        LoginUtilFinal.map.put(sessionAdminId + "md5",md5Password + sessionAdminId);
        session.setAttribute(sessionAdminId + "un",adminEntity.getUsername());
        session.setAttribute(sessionAdminId + "token",md5Password);
        Cookie cookie = new Cookie("un",adminEntity.getUsername());
        cookie.setPath("/");
        response.addCookie(cookie);
        return login;
    }
    @Override
    public int updatePassword(UserPasswordEntity entity) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(entity.getUsername());
        userEntity.setPassword(entity.getOld_password());
        int login = userMapper.login(userEntity);
        if(login < 1){
            throw new RuntimeException("旧密码输入错误！");
        }
        userEntity.setPassword(entity.getNew_password());
        return userMapper.updatePassword(userEntity);
    }

    @Override
    public int updateImages(UserEntity entity) {
        return userMapper.updateImages(entity);
    }

    @Override
    public User getUsername(String username) {
        return userMapper.getUsername(username);
    }
}
