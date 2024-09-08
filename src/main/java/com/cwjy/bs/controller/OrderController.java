package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.config.BaseException;
import com.cwjy.bs.orm.dto.Order;
import com.cwjy.bs.orm.dto.OrderShipping;
import com.cwjy.bs.orm.entity.OrderEntity;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author xgp
 * @version 1.0
 * @date 3/23 10:09
 * @table
 */
@RestController
@RequestMapping("Order")
@CrossOrigin
@Api(tags = "订单")
public class OrderController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody Order record) {
        return orderServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insertList")
    public ResponseEntity insertList(@RequestBody List<Order> record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.stream().forEach(item -> {
            item.initSaveAndStatus(username);
        });
        return orderServer.insertList(record);
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody Order record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initSave(username);
        return orderServer.insert(record);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody Order record, HttpServletRequest request) {
        return orderServer.insertSelective(record);
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody Order record) {
       return commodityServer.selectByPrimaryKey(record.getCommodity_id());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody Order record, HttpServletRequest request) {
        return orderServer.updateByPrimaryKeySelective(record);
    }


    @PostMapping("Ship")
    public ResponseEntity Ship(@RequestBody Order record, HttpServletRequest request) {
        OrderEntity entity = (OrderEntity) orderServer.selectByPrimaryKey(record.getId()).getData();
        if(entity.getStatus() != 2){
            throw new BaseException("当前订单已发货，请勿重复发货！");
        }
        record.setStatus(4);
        record.setConsigo_time(new Date());
        String username = ReturnUsername.getUsername(request);
        record.initUpdate(username);
        return orderServer.updateByPrimaryKeySelective(record);
    }
    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody Order record, HttpServletRequest request) {
        return orderServer.updateByPrimaryKey(record);
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody Order record, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = LoginUtilFinal.map.get(session.getId() + "username");
        record.setCreate_user(username);
        return orderServer.getPage(record);
    }


    @PostMapping("getPageAdmin")
    public ResponseEntity getPageAdmin(@RequestBody Order record, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = LoginUtilFinal.map.get(session.getId() + "username");
        if(!username.equals("admin")){
            return ResponseEntity.error("非管理员用户!");
        }
        return orderServer.getPage(record);
    }


    @PostMapping("confirmReceipt")
    public ResponseEntity confirmReceipt(@RequestBody Order record) {
        return orderServer.confirmReceipt(record);
    }

}