package com.cwjy.bs.server.impl;

import com.cwjy.bs.common.EnumCommon;
import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.MapperTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.config.BaseException;
import com.cwjy.bs.orm.dto.*;
import com.cwjy.bs.orm.entity.OrderEntity;
import com.cwjy.bs.orm.entity.PetBoardingEntity;
import com.cwjy.bs.orm.entity.ProductReviewsBoardingEntity;
import com.cwjy.bs.orm.entity.ProductReviewsEntity;
import com.cwjy.bs.server.ProductReviewsBoardingServer;
import com.cwjy.bs.server.ProductReviewsServer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author xgp
 * @version 1.0
 * @date 3/23 10:09
 * @table
 */
@Service
public class ProductReviewsBoardingServerImpl extends MapperTools implements ProductReviewsBoardingServer {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity deleteByPrimaryKey(String id) {
        ProductReviewsBoardingEntity entity = productReviewsBoardingMapper.selectByPrimaryKey(id);
        int count = commodityMapper.cutProductReviewsCount(entity.getBoarding_id());
        return ResponseEntity.success(productReviewsBoardingMapper.deleteByPrimaryKey(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity insert(ProductReviewsBoarding record) {
        PetBoardingEntity boardingEntity = petBoardingMapper.selectByPrimaryKey(record.getBoarding_id());
        if(boardingEntity != null && boardingEntity.getStatus() == EnumCommon.FosterCareStatus.CARRY_OUT_EVALUATED.getCode()){
            throw new BaseException("此订单已评论，请联系管理员");
        }
        /**修改订单状态*/
        PetBoarding petBoarding = new PetBoarding();
        petBoarding.setId(record.getBoarding_id());
        petBoarding.setStatus(EnumCommon.FosterCareStatus.CARRY_OUT_EVALUATED.getCode());
        petBoardingMapper.updateByPrimaryKeySelective(petBoarding);

        record.setReceiver("admin");
        record.setParent_node("0");
        record.setStatus(1);
        record.setCommentator(record.getCreate_user());
        /**增加评论*/
        return ResponseEntity.success(productReviewsBoardingMapper.insert(record));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity insertSend(ProductReviewsBoarding record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        ProductReviewsBoardingEntity reviewsEntity = productReviewsBoardingMapper.selectByPrimaryKey(record.getId());
        commodityMapper.addProductReviewsCount(reviewsEntity.getBoarding_id());
        record.initSaveAndStatus(username);
        record.setBoarding_id(reviewsEntity.getBoarding_id());
        record.setOrder_id(reviewsEntity.getOrder_id());
        record.setCommentator(username);
        record.setReceiver(reviewsEntity.getCommentator());
        record.setParent_node("0".equals(reviewsEntity.getParent_node()) ? reviewsEntity.getId() : reviewsEntity.getParent_node());
        return ResponseEntity.success(productReviewsBoardingMapper.insert(record));
    }



    @Override
    public ResponseEntity insertSelective(ProductReviewsBoarding record) {
        return ResponseEntity.success(productReviewsBoardingMapper.insertSelective(record));
    }

    @Override
    public ResponseEntity selectByPrimaryKey(String id) {
        return ResponseEntity.success(productReviewsBoardingMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity updateByPrimaryKeySelective(ProductReviewsBoarding record) {
        return ResponseEntity.success(productReviewsBoardingMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity updateByPrimaryKey(ProductReviewsBoarding record) {
        return ResponseEntity.success(productReviewsBoardingMapper.updateByPrimaryKey(record));
    }

    @Override
    public ResponseEntity getPage(ProductReviewsBoarding record) {
        record.setCreate_user(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        record.setParent_node("0");
        List<ProductReviewsBoardingEntity> reviewsBoardingMapperPage = productReviewsBoardingMapper.getPage(record);
        reviewsBoardingMapperPage.stream().forEach(item -> {
            ProductReviewsBoarding productReviewsSubclass = new ProductReviewsBoarding();
            productReviewsSubclass.setOrder_id(item.getOrder_id());
            productReviewsSubclass.setParent_node(item.getId());
            List<ProductReviewsBoardingEntity> reviewsMapperPage = productReviewsBoardingMapper.getPage(productReviewsSubclass);
            reviewsMapperPage.stream().forEach(itemPage -> {
                String images_path = userMapper.selectByNameUser(itemPage.getCommentator()) == null ? null :
                        userMapper.selectByNameUser(itemPage.getCommentator()).getImages_path();
                itemPage.setImagesFile(images_path);
            });
            item.setProductReviewsList(reviewsMapperPage);
            item.setImagesFile(userMapper.selectByNameUser(item.getCommentator()).getImages_path());
        });
        return ResponseEntity.success(reviewsBoardingMapperPage);
    }

    @Override
    public ResponseEntity getOrderPage(ProductReviewsBoarding record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        if(!"admin".equals(username)){
            record.setCreate_user(username);
        }
        List<ProductReviewsBoardingEntity> reviewsMapperOrderPage = productReviewsBoardingMapper.getOrderPage(record);
        reviewsMapperOrderPage.stream().forEach(item -> {
            ProductReviewsBoarding productReviewsSubclass = new ProductReviewsBoarding();
            productReviewsSubclass.setOrder_id(item.getOrder_id());
            productReviewsSubclass.setParent_node(item.getId());
            List<ProductReviewsBoardingEntity> reviewsMapperPage = productReviewsBoardingMapper.getPage(productReviewsSubclass);
            reviewsMapperPage.stream().forEach(itemPage -> {
                String images_path = userMapper.selectByNameUser(itemPage.getCommentator()) == null ? null :
                        userMapper.selectByNameUser(itemPage.getCommentator()).getImages_path();
                itemPage.setImagesFile(images_path);
            });
            item.setProductReviewsList(reviewsMapperPage);
            item.setImagesFile(userMapper.selectByNameUser(item.getCommentator()).getImages_path());
        });
        return ResponseEntity.success(reviewsMapperOrderPage);
    }
}