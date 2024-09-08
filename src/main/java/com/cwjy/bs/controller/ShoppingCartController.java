package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.orm.dto.ShoppingCart;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xgp
 * @version 1.0
 * @date 3/23 10:09
 * @table
 */
@RestController
@RequestMapping("ShoppingCart")
@CrossOrigin
@Api(tags = "购物车")
public class ShoppingCartController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody ShoppingCart record) {
        return shoppingCartServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody ShoppingCart record, HttpServletRequest request) {
        return shoppingCartServer.insert(record);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody ShoppingCart record) {
        return shoppingCartServer.insertSelective(record);
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody ShoppingCart record) {
       return shoppingCartServer.selectByPrimaryKey(record.getId());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody ShoppingCart record, HttpServletRequest request) {
        return shoppingCartServer.updateByPrimaryKeySelective(record);
    }



    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody ShoppingCart record) {
        return shoppingCartServer.updateByPrimaryKey(record);
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody ShoppingCart record) {
        return shoppingCartServer.getPage(record);
    }

    @PostMapping("getCount")
    public ResponseEntity getCount() {
        return shoppingCartServer.getCount();
    }

}