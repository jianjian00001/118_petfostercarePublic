package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.orm.dto.CategoryDetails;
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
@RequestMapping("CategoryDetails")
@CrossOrigin
@Api(tags = "类别")
public class CategoryDetailsController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody CategoryDetails record) {
        return categoryDetailsServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody CategoryDetails record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initSaveAndStatus(username);
        return categoryDetailsServer.insert(record);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody CategoryDetails record) {
        return categoryDetailsServer.insertSelective(record);
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody CategoryDetails record) {
       return categoryDetailsServer.selectByPrimaryKey(record.getId());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody CategoryDetails record,HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initUpdate(username);
        return categoryDetailsServer.updateByPrimaryKeySelective(record);
    }



    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody CategoryDetails record) {
        return categoryDetailsServer.updateByPrimaryKey(record);
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody CategoryDetails record) {
        return categoryDetailsServer.getPage(record);
    }

}