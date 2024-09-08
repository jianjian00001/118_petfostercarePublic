package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.orm.dto.ProductReviews;
import com.cwjy.bs.orm.dto.ProductReviewsBoarding;
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
@RequestMapping("ProductReviewsBoarding")
@CrossOrigin
@Api(tags = "宠物寄养评价")
public class ProductReviewsBoardingController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody ProductReviewsBoarding record) {
        return productReviewsBoardingServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody ProductReviewsBoarding record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initSaveAndStatus(username);
        return productReviewsBoardingServer.insert(record);
    }

    @PostMapping("insertSend")
    public ResponseEntity insertSend(@RequestBody ProductReviewsBoarding record, HttpServletRequest request) {
        return productReviewsBoardingServer.insertSend(record);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody ProductReviewsBoarding record) {
        return productReviewsBoardingServer.insertSelective(record);
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody ProductReviewsBoarding record) {
       return productReviewsBoardingServer.selectByPrimaryKey(record.getId());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody ProductReviewsBoarding record, HttpServletRequest request) {
        return productReviewsBoardingServer.updateByPrimaryKeySelective(record);
    }



    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody ProductReviewsBoarding record) {
        return productReviewsBoardingServer.updateByPrimaryKey(record);
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody ProductReviewsBoarding record) {
        return productReviewsBoardingServer.getPage(record);
    }


    @PostMapping("getOrderPage")
    public ResponseEntity getOrderPage(@RequestBody ProductReviewsBoarding record) {
        return productReviewsBoardingServer.getOrderPage(record);
    }
}