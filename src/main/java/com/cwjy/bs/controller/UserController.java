package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.config.BaseException;
import com.cwjy.bs.orm.dto.User;
import com.cwjy.bs.orm.entity.AdminEntity;
import com.cwjy.bs.orm.entity.UserEntity;
import com.cwjy.bs.orm.entity.UserPasswordEntity;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author xgp
 * @version 1.0
 * @date 3/15 17:51
 * @table
 * @description
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户相关操作")
@CrossOrigin
public class UserController extends DaoTools {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody UserEntity record) {
        return ResponseEntity.success(userServer.deleteByPrimaryKey(record.getId()));
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody UserEntity record, HttpServletRequest request) {
        return ResponseEntity.success(userServer.insert(record));
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody UserEntity record) {
        return ResponseEntity.success(userServer.insertSelective(record));
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody UserEntity record) {
        return ResponseEntity.success(userServer.selectByPrimaryKey(record.getId()));
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody UserEntity record) {
        return ResponseEntity.success(userServer.getPage(record));
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody UserEntity record, HttpServletRequest request) {
        return ResponseEntity.success(userServer.updateByPrimaryKeySelective(record));
    }

    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody UserEntity record) {
        return ResponseEntity.success(userServer.updateByPrimaryKey(record));
    }

    @PostMapping("getByName")
    public ResponseEntity getByName(@RequestBody UserEntity record) {
        return ResponseEntity.success(userServer.selectByName(record.getUsername()));
    }
    @PostMapping("getAll")
    public ResponseEntity getAll(@RequestBody UserEntity record) {
        return ResponseEntity.success(userServer.getAll(record));
    }
    @PostMapping("login")
    public ResponseEntity login(@RequestBody UserEntity record, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        return ResponseEntity.success(userServer.login(record,request,response));
    }

    @PostMapping("loginAdmin")
    public ResponseEntity loginAdmin(@RequestBody AdminEntity recordAdmin, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        if(!recordAdmin.getUsername().equals("admin")){
            throw new BaseException("非管理员用户，无法进入后台管理系统！请您联系管理员进行登录！谢谢！");
        }
        else {
            session=request.getSession();
            String username = "admin";
            session.setAttribute("adminSession",userServer.getUsername(username));}
        return ResponseEntity.success(userServer.loginAdmin(recordAdmin,request,response));
    }

    @RequestMapping("/checkLogin")
    public int checkLogin(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String sessionId = session.getId();
        String token = (String) session.getAttribute("token") + sessionId;
        System.out.println(token);
        if(token != null && token.equals(LoginUtilFinal.map.get("md5"))){
            return 0;
        }else {
            return 1;
        }
    }
    @PostMapping("/updatePassword")
    public ResponseEntity updatePassword(@RequestBody UserPasswordEntity entity,HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        entity.setUsername(username);
        return ResponseEntity.success(userServer.updatePassword(entity));
    }

    @PostMapping("/updateImages")
    public ResponseEntity updateImages(@RequestParam("file") MultipartFile file,@RequestParam("username") String username) {
        if (file.isEmpty()) {
            throw new BaseException("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        System.getProperty("user.dir");
        String filePath = "E:\\educationProject\\宠物系统\\petfostercare\\images\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new BaseException("上传失败");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        userEntity.setImages_path(fileName);
        return ResponseEntity.success(userServer.updateImages(userEntity));
    }

    @PostMapping("/getUsername")
    public ResponseEntity getUsername(HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        return ResponseEntity.success(userServer.getUsername(username));
    }
 /*   @PostMapping("/getAdminName")
    public ResponseEntity getAdminName(HttpServletRequest request) {
        String username = "a";
   *//*     ReturnUsername.getAdminName(request);*//*
        return ResponseEntity.success(userServer.getUsername(username));
    }*/
    @PostMapping("/getAdminName")
    public void getAdminName(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String username = "admin";
     session.setAttribute("adminSession",userServer.getUsername(username));

    }
}
