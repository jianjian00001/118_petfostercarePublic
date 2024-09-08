package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.orm.dto.ProductReviews;
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
@RequestMapping("ProductReviews")
@CrossOrigin
@Api(tags = "订单评价")
public class ProductReviewsController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody ProductReviews record) {
        return productReviewsServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody ProductReviews record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initSaveAndStatus(username);
        return productReviewsServer.insert(record);
    }

    @PostMapping("insertSend")
    public ResponseEntity insertSend(@RequestBody ProductReviews record, HttpServletRequest request) {
        return productReviewsServer.insertSend(record);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody ProductReviews record) {
        return productReviewsServer.insertSelective(record);
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody ProductReviews record) {
       return productReviewsServer.selectByPrimaryKey(record.getId());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody ProductReviews record, HttpServletRequest request) {
        return productReviewsServer.updateByPrimaryKeySelective(record);
    }



    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody ProductReviews record) {
        return productReviewsServer.updateByPrimaryKey(record);
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody ProductReviews record) {
        return productReviewsServer.getPage(record);
    }


    @PostMapping("getOrderPage")
    public ResponseEntity getOrderPage(@RequestBody ProductReviews record) {
        return productReviewsServer.getOrderPage(record);
    }
}