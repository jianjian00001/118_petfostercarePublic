package com.cwjy.bs.controller;

import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.ResponseEntity;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xgp
 * @version 1.0
 * @date 4/10 13:56
 * @table
 * @description
 */
@RestController
@RequestMapping("Home")
@CrossOrigin
@Api(tags = "首页")
public class HomeController extends DaoTools {

    @PostMapping("dailyOrder")
    public ResponseEntity dailyOrder() {
        return homeServer.dailyOrder();
    }

    @PostMapping("fosterCareClassification")
    public ResponseEntity fosterCareClassification() {
        return homeServer.fosterCareClassification();
    }

    @PostMapping("salesRanking")
    public ResponseEntity salesRanking() {
        return homeServer.salesRanking();
    }

    @PostMapping("dailyFosterOrder")
    public ResponseEntity dailyFosterOrder() {
        return homeServer.dailyFosterOrder();
    }

}
