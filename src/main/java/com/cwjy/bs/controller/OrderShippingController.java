package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.orm.dto.OrderShipping;
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
@RequestMapping("OrderShipping")
@CrossOrigin
@Api(tags = "地址")
public class OrderShippingController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody OrderShipping record) {
        return orderShippingServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody OrderShipping record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initSaveAndStatus(username);
        return orderShippingServer.insert(record);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody OrderShipping record) {
        return orderShippingServer.insertSelective(record);
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody OrderShipping record) {
       return orderShippingServer.selectByPrimaryKey(record.getId());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody OrderShipping record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initUpdate(username);
        return orderShippingServer.updateByPrimaryKeySelective(record);
    }



    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody OrderShipping record) {
        return orderShippingServer.updateByPrimaryKey(record);
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody OrderShipping record) {
        return orderShippingServer.getPage(record);
    }

}