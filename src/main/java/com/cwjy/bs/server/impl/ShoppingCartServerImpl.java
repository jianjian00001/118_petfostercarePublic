package com.cwjy.bs.server.impl;

import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.MapperTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.common.ReturnUsername;
import com.cwjy.bs.orm.dto.ShoppingCart;
import com.cwjy.bs.orm.entity.CommodityEntity;
import com.cwjy.bs.orm.entity.OrderShippingEntity;
import com.cwjy.bs.orm.entity.ShoppingCartEntity;
import com.cwjy.bs.server.ShoppingCartServer;
import com.cwjy.bs.server.ShoppingCartServer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xgp
 * @version 1.0
 * @date 3/23 10:09
 * @table
 */
@Service
public class ShoppingCartServerImpl extends MapperTools implements ShoppingCartServer {


    @Override
    public ResponseEntity deleteByPrimaryKey(String id) {
        return ResponseEntity.success(shoppingCartMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResponseEntity insert(ShoppingCart record) {
        record.initSaveAndStatus(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        return ResponseEntity.success(shoppingCartMapper.insert(record));
    }


    @Override
    public ResponseEntity insertSelective(ShoppingCart record) {
        return ResponseEntity.success(shoppingCartMapper.insertSelective(record));
    }

    @Override
    public ResponseEntity selectByPrimaryKey(String id) {
        return ResponseEntity.success(shoppingCartMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity updateByPrimaryKeySelective(ShoppingCart record) {
        return ResponseEntity.success(shoppingCartMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity updateByPrimaryKey(ShoppingCart record) {
        return ResponseEntity.success(shoppingCartMapper.updateByPrimaryKey(record));
    }

    @Override
    public ResponseEntity getPage(ShoppingCart record) {
        record.setCreate_user(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        List<ShoppingCartEntity> cartMapperPage = shoppingCartMapper.getPage(record);
        cartMapperPage.stream().forEach(item ->{
            CommodityEntity commodityEntity = commodityMapper.selectByPrimaryKey(item.getCommodity_id());
            item.setCommodityEntity(commodityEntity);
            OrderShippingEntity shippingEntity = orderShippingMapper.selectByPrimaryKey(item.getOrder_shipping_id());
            item.setOrderShippingEntity(shippingEntity);
        });
        return ResponseEntity.success(cartMapperPage);
    }
    @Override
    public ResponseEntity getCount() {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        return ResponseEntity.success(shoppingCartMapper.getCount(username));
    }
}