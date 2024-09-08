package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.orm.entity.RoleEntity;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xgp
 * @version 1.0
 * @date 3/15 17:51
 * @table
 * @description
 */
@RestController
@RequestMapping("/Role")
@Api(tags = "角色管理")
@CrossOrigin
public class RoleController extends DaoTools {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody RoleEntity record) {
        return ResponseEntity.success(roleServer.deleteByPrimaryKey(record.getId()));
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody RoleEntity record, HttpServletRequest request) {
        return ResponseEntity.success(roleServer.insert(record));
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody RoleEntity record) {
        return ResponseEntity.success(roleServer.insertSelective(record));
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody RoleEntity record) {
        return ResponseEntity.success(roleServer.selectByPrimaryKey(record.getId()));
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody RoleEntity record) {
        return ResponseEntity.success(roleServer.getPage(record));
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody RoleEntity record, HttpServletRequest request) {
        return ResponseEntity.success(roleServer.updateByPrimaryKeySelective(record));
    }

    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody RoleEntity record, HttpServletRequest request) {
        return ResponseEntity.success(roleServer.updateByPrimaryKey(record));
    }

    @GetMapping("getAll")
    public ResponseEntity getAll(){
        return ResponseEntity.success(roleServer.getAll());
    }


/*
    @PostMapping("getByName")
    public ResponseEntity getByName(@RequestBody RoleEntity record) {
        return ResponseEntity.success(roleServer.selectByName(record.getUsername()));
    }*/
}
