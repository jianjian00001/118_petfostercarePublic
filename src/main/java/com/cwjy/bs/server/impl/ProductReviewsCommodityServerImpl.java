package com.cwjy.bs.server.impl;

import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.MapperTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.config.BaseException;
import com.cwjy.bs.orm.dto.Order;
import com.cwjy.bs.orm.dto.ProductReviews;
import com.cwjy.bs.orm.dto.ProductReviewsCommodity;
import com.cwjy.bs.orm.entity.OrderEntity;
import com.cwjy.bs.orm.entity.ProductReviewsCommodityEntity;
import com.cwjy.bs.orm.entity.ProductReviewsEntity;
import com.cwjy.bs.server.ProductReviewsCommodityServer;
import com.cwjy.bs.server.ProductReviewsServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xgp
 * @version 1.0
 * @date 3/23 10:09
 * @table
 */
@Service
public class ProductReviewsCommodityServerImpl extends MapperTools implements ProductReviewsCommodityServer {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity deleteByPrimaryKey(String id) {
        ProductReviewsCommodityEntity entity = productReviewsCommodityMapper.selectByPrimaryKey(id);
        int count = commodityMapper.cutProductReviewsCount(entity.getCommodity_id());
        return ResponseEntity.success(productReviewsCommodityMapper.deleteByPrimaryKey(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity insert(ProductReviewsCommodity record) {
        OrderEntity orderEntity = orderMapper.selectByPrimaryKey(record.getOrder_id());
        if(orderEntity != null && orderEntity.getBuyer_rate() != 0){
            throw new BaseException("此订单已评论，请联系管理员");
        }
        record.setReceiver("admin");
        record.setParent_node("0");
        record.setStatus(1);
        record.setCommentator(record.getCreate_user());
        Order order =  new Order();
        order.initUpdate(record.getCreate_user());
        order.setId(record.getOrder_id());
        order.setBuyer_rate(1);
        orderMapper.updateByPrimaryKeySelective(order);
        commodityMapper.addProductReviewsCount(order.getCommodity_id());
        return ResponseEntity.success(productReviewsCommodityMapper.insert(record));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity insertSend(ProductReviewsCommodity record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        ProductReviewsCommodityEntity reviewsEntity = productReviewsCommodityMapper.selectByPrimaryKey(record.getId());
        commodityMapper.addProductReviewsCount(reviewsEntity.getCommodity_id());
        record.initSaveAndStatus(username);
        record.setCommodity_id(reviewsEntity.getCommodity_id());
        record.setOrder_id(reviewsEntity.getOrder_id());
        record.setCommentator(username);
        record.setReceiver(reviewsEntity.getCommentator());
        record.setParent_node("0".equals(reviewsEntity.getParent_node()) ? reviewsEntity.getId() : reviewsEntity.getParent_node());
        return ResponseEntity.success(productReviewsCommodityMapper.insert(record));
    }



    @Override
    public ResponseEntity insertSelective(ProductReviewsCommodity record) {
        return ResponseEntity.success(productReviewsCommodityMapper.insertSelective(record));
    }

    @Override
    public ResponseEntity selectByPrimaryKey(String id) {
        return ResponseEntity.success(productReviewsCommodityMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity updateByPrimaryKeySelective(ProductReviewsCommodity record) {
        return ResponseEntity.success(productReviewsCommodityMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity updateByPrimaryKey(ProductReviewsCommodity record) {
        return ResponseEntity.success(productReviewsCommodityMapper.updateByPrimaryKey(record));
    }

    @Override
    public ResponseEntity getPage(ProductReviewsCommodity record) {
        record.setCreate_user(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        return ResponseEntity.success(productReviewsCommodityMapper.getPage(record));
    }

    @Override
    public ResponseEntity getOrderPage(ProductReviewsCommodity record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        if(!"admin".equals(username)){
            record.setCreate_user(username);
        }
        return ResponseEntity.success(productReviewsCommodityMapper.getOrderPage(record));
    }
}