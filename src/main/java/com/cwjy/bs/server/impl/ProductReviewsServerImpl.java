package com.cwjy.bs.server.impl;

import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.MapperTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.config.BaseException;
import com.cwjy.bs.orm.dto.Order;
import com.cwjy.bs.orm.dto.ProductReviews;
import com.cwjy.bs.orm.dto.ProductReviewsCommodity;
import com.cwjy.bs.orm.entity.OrderEntity;
import com.cwjy.bs.orm.entity.ProductReviewsEntity;
import com.cwjy.bs.server.ProductReviewsServer;
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
public class ProductReviewsServerImpl extends MapperTools implements ProductReviewsServer {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity deleteByPrimaryKey(String id) {
        ProductReviewsEntity entity = productReviewsMapper.selectByPrimaryKey(id);
        int count = commodityMapper.cutProductReviewsCount(entity.getCommodity_id());
        return ResponseEntity.success(productReviewsMapper.deleteByPrimaryKey(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity insert(ProductReviews record) {
        OrderEntity orderEntity = orderMapper.selectByPrimaryKey(record.getOrder_id());
        if(orderEntity != null && orderEntity.getBuyer_rate() != 0){
            throw new BaseException("此订单已评论，请联系管理员");
        }
        record.setReceiver("admin");
        record.setParent_node("0");
        record.setStatus(1);
        record.setCommentator(record.getCreate_user());
        /**修改订单评价状态*/
        Order order =  new Order();
        order.initUpdate(record.getCreate_user());
        order.setId(record.getOrder_id());
        order.setBuyer_rate(1);
        orderMapper.updateByPrimaryKeySelective(order);
        /**增加商品评论和商品评论数*/
        Arrays.stream(record.getCommodity_id_array()).forEach(item -> {
            /**增加商品评论数*/
            commodityMapper.addProductReviewsCount(item);
            /**增加商品评论*/
            ProductReviewsCommodity productReviewsCommodity = new ProductReviewsCommodity();
            BeanUtils.copyProperties(record,productReviewsCommodity);
            productReviewsCommodity.setCommodity_id(item);
            productReviewsCommodityMapper.insert(productReviewsCommodity);
        });
        /**增加评论*/
        return ResponseEntity.success(productReviewsMapper.insert(record));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity insertSend(ProductReviews record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        ProductReviewsEntity reviewsEntity = productReviewsMapper.selectByPrimaryKey(record.getId());
        commodityMapper.addProductReviewsCount(reviewsEntity.getCommodity_id());
        record.initSaveAndStatus(username);
        record.setCommodity_id(reviewsEntity.getCommodity_id());
        record.setOrder_id(reviewsEntity.getOrder_id());
        record.setCommentator(username);
        record.setReceiver(reviewsEntity.getCommentator());
        record.setParent_node("0".equals(reviewsEntity.getParent_node()) ? reviewsEntity.getId() : reviewsEntity.getParent_node());
        return ResponseEntity.success(productReviewsMapper.insert(record));
    }



    @Override
    public ResponseEntity insertSelective(ProductReviews record) {
        return ResponseEntity.success(productReviewsMapper.insertSelective(record));
    }

    @Override
    public ResponseEntity selectByPrimaryKey(String id) {
        return ResponseEntity.success(productReviewsMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity updateByPrimaryKeySelective(ProductReviews record) {
        return ResponseEntity.success(productReviewsMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity updateByPrimaryKey(ProductReviews record) {
        return ResponseEntity.success(productReviewsMapper.updateByPrimaryKey(record));
    }

    @Override
    public ResponseEntity getPage(ProductReviews record) {
        record.setCreate_user(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        record.setParent_node("0");
        List<ProductReviewsEntity> reviewsMapperOrderPage = productReviewsMapper.getPage(record);
        reviewsMapperOrderPage.stream().forEach(item -> {
            ProductReviews productReviewsSubclass = new ProductReviews();
            productReviewsSubclass.setOrder_id(item.getOrder_id());
            productReviewsSubclass.setParent_node(item.getId());
            List<ProductReviewsEntity> reviewsMapperPage = productReviewsMapper.getPage(productReviewsSubclass);
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

    @Override
    public ResponseEntity getOrderPage(ProductReviews record) {
        List<ProductReviewsEntity> reviewsMapperOrderPage = productReviewsMapper.getOrderPage(record);
        reviewsMapperOrderPage.stream().forEach(item -> {
            ProductReviews productReviewsSubclass = new ProductReviews();
            productReviewsSubclass.setOrder_id(item.getOrder_id());
            productReviewsSubclass.setParent_node(item.getId());
            List<ProductReviewsEntity> reviewsMapperPage = productReviewsMapper.getPage(productReviewsSubclass);
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