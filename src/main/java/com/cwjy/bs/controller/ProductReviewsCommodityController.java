package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.orm.dto.ProductReviews;
import com.cwjy.bs.orm.dto.ProductReviewsCommodity;
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
@RequestMapping("ProductReviewsCommodity")
@CrossOrigin
@Api(tags = "商品评价")
public class ProductReviewsCommodityController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody ProductReviewsCommodity record) {
        return productReviewsCommodityServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody ProductReviewsCommodity record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initSaveAndStatus(username);
        return productReviewsCommodityServer.insert(record);
    }

    @PostMapping("insertSend")
    public ResponseEntity insertSend(@RequestBody ProductReviewsCommodity record, HttpServletRequest request) {
        return productReviewsCommodityServer.insertSend(record);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody ProductReviewsCommodity record) {
        return productReviewsCommodityServer.insertSelective(record);
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody ProductReviewsCommodity record) {
       return productReviewsCommodityServer.selectByPrimaryKey(record.getId());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody ProductReviewsCommodity record, HttpServletRequest request) {
        return productReviewsCommodityServer.updateByPrimaryKeySelective(record);
    }



    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody ProductReviewsCommodity record) {
        return productReviewsCommodityServer.updateByPrimaryKey(record);
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody ProductReviewsCommodity record) {
        return productReviewsCommodityServer.getPage(record);
    }


    @PostMapping("getOrderPage")
    public ResponseEntity getOrderPage(@RequestBody ProductReviewsCommodity record) {
        return productReviewsCommodityServer.getOrderPage(record);
    }
}