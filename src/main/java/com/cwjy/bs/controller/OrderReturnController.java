package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.EnumCommon;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.config.BaseException;
import com.cwjy.bs.orm.dto.Order;
import com.cwjy.bs.orm.dto.OrderReturn;
import com.cwjy.bs.orm.entity.OrderEntity;
import com.cwjy.bs.orm.entity.OrderReturnEntity;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author xgp
 * @version 1.0
 * @date 3/23 10:09
 * @table
 */
@RestController
@RequestMapping("OrderReturn")
@CrossOrigin
@Api(tags = "退货")
public class OrderReturnController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody OrderReturn record) {
        return orderReturnServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody OrderReturn record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initSaveAndStatus(username);
        return orderReturnServer.insert(record);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody OrderReturn record) {
        return orderReturnServer.insertSelective(record);
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody OrderReturn record) {
       return orderReturnServer.selectByPrimaryKey(record.getId());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody OrderReturn record, HttpServletRequest request) {
        return orderReturnServer.updateByPrimaryKeySelective(record);
    }



    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody OrderReturn record) {
        return orderReturnServer.updateByPrimaryKey(record);
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody OrderReturn record) {
        return orderReturnServer.getPage(record);
    }

    /**同意退款*/
    @PostMapping("agreeToRefund")
    public ResponseEntity agreeToRefund(@RequestBody OrderReturn record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initUpdate(username);
        return orderReturnServer.agreeToRefund(record);
    }

    /**拒绝退款*/
    @PostMapping("refusalToRefund")
    public ResponseEntity refusalToRefund(@RequestBody OrderReturn record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initUpdate(username);
        return orderReturnServer.refusalToRefund(record);
    }

    /**再次申请退款*/
    @PostMapping("requestRefundAgain")
    public ResponseEntity requestRefundAgain(@RequestBody OrderReturn record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initUpdate(username);
        return orderReturnServer.requestRefundAgain(record);
    }
    @PostMapping("ReShip")
    public ResponseEntity Ship(@RequestBody OrderReturn record, HttpServletRequest request) {
        OrderReturnEntity m= orderReturnServer.selectByOrderId(record.getOrder_id());

        record.setId(m.getId());
        record.setStatus(3);
        String username = ReturnUsername.getUsername(request);
        record.initUpdate(username);

        return orderReturnServer.updateByPrimaryKeySelective(record);

    }

    @PostMapping("ConfirmRefund")
    public ResponseEntity ConfirmRefund(@RequestBody OrderReturn record, HttpServletRequest request) {

        record.setStatus(4);
        String username = ReturnUsername.getUsername(request);
        record.initUpdate(username);

        return orderReturnServer.updateByPrimaryKeySelective(record);

    }

}