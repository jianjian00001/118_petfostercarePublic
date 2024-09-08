package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.orm.dto.PetBoarding;
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
@RequestMapping("PetBoarding")
@CrossOrigin
@Api(tags = "寄养")
public class PetBoardingController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody PetBoarding record) {
        return petBoardingServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody PetBoarding record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initSaveAndStatus(username);
        return petBoardingServer.insert(record);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody PetBoarding record) {
        return petBoardingServer.insertSelective(record);
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody PetBoarding record) {
       return petBoardingServer.selectByPrimaryKey(record.getId());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestBody PetBoarding record, HttpServletRequest request) {
        String username = ReturnUsername.getUsername(request);
        record.initUpdate(username);
       return petBoardingServer.updateByPrimaryKeySelective(record);
    }

    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody PetBoarding record) {
        return petBoardingServer.updateByPrimaryKey(record);
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody PetBoarding record) {
        return petBoardingServer.getPage(record);
    }


    @PostMapping("getPageAdmin")
    public ResponseEntity getPageAdmin(@RequestBody PetBoarding record) {
        return petBoardingServer.getPageAdmin(record);
    }

    @PostMapping("agree")
    public ResponseEntity agree(@RequestBody PetBoarding record) {
        return petBoardingServer.agree(record);
    }

    @PostMapping("refuse")
    public ResponseEntity refuse(@RequestBody PetBoarding record) {
        return petBoardingServer.refuse(record);
    }

    @PostMapping("checkIn")
    public ResponseEntity checkIn(@RequestBody PetBoarding record) {
        return petBoardingServer.checkIn(record);
    }

    @PostMapping("complete")
    public ResponseEntity complete(@RequestBody PetBoarding record) {
        return petBoardingServer.complete(record);
    }


}