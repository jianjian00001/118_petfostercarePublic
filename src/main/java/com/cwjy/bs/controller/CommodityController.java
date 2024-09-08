package com.cwjy.bs.controller;

import com.alibaba.fastjson.JSONArray;
import com.cwjy.bs.common.DaoTools;
import com.cwjy.bs.common.MapperTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.config.BaseException;
import com.cwjy.bs.orm.dto.*;
import com.cwjy.bs.server.CategoryDetailsServer;
import com.cwjy.bs.server.CommodityServer;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author xgp
 * @version 1.0
 * @date 3/23 10:09
 * @table
 */
@RestController
@RequestMapping("Commodity")
@CrossOrigin
@Api(tags = "商品详细")
public class CommodityController extends DaoTools  {

    @PostMapping("deleteByPrimaryKey")
    public ResponseEntity deleteByPrimaryKey(@RequestBody Commodity record) {
        return commodityServer.deleteByPrimaryKey(record.getId());
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestParam("file") MultipartFile file, @RequestParam("record") String record, HttpServletRequest request) {
        Commodity commodity = JSONArray.parseObject(record,Commodity.class);
        if (file.isEmpty()) {
            throw new BaseException("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\educationProject\\宠物系统\\petfostercare\\images\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new BaseException("上传失败");
        }
        commodity.setImage_path(fileName);

        String username = ReturnUsername.getUsername(request);
        commodity.initSaveAndStatus(username);
        return commodityServer.insert(commodity);
    }

    @PostMapping("insertSelective")
    public ResponseEntity insertSelective(@RequestBody Commodity record) {
        return null;
    }

    @PostMapping("selectByPrimaryKey")
    public ResponseEntity selectByPrimaryKey(@RequestBody Commodity record) {
       return commodityServer.selectByPrimaryKey(record.getId());
    }

    @PostMapping("updateByPrimaryKeySelective")
    public ResponseEntity updateByPrimaryKeySelective(@RequestParam(value = "file",required = false) MultipartFile file, @RequestParam("record") String record,@RequestParam(value = "fileNameOld",required = false) String fileNameOld, HttpServletRequest request) {

        Commodity commodity = JSONArray.parseObject(record,Commodity.class);

        if (file==null) {

          /*  throw new BaseException("上传失败，请选择文件");*/
            commodity.setImage_path(fileNameOld);
        }
        else {
            String fileName = file.getOriginalFilename();
            String filePath = "E:\\educationProject\\宠物系统\\petfostercare\\images\\";
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                throw new BaseException("上传失败");
            }
            commodity.setImage_path(fileName);
        }
        String username = ReturnUsername.getUsername(request);
        commodity.initUpdate(username);
        return commodityServer.updateByPrimaryKeySelective(commodity);
    }

    @PostMapping("updateByPrimaryKey")
    public ResponseEntity updateByPrimaryKey(@RequestBody Commodity record) {
        return null;
    }

    @PostMapping("getPage")
    public ResponseEntity getPage(@RequestBody Commodity record) {
        return commodityServer.getPage(record);
    }

    @PostMapping("getProductReviews")
    public ResponseEntity getProductReviews(@RequestBody Commodity record) {
        return commodityServer.getProductReviews(record);
    }

}