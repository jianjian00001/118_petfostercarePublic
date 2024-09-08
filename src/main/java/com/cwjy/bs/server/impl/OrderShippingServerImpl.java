package com.cwjy.bs.server.impl;

import com.cwjy.bs.common.EnumCommon;
import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.MapperTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.orm.dto.OrderShipping;
import com.cwjy.bs.server.OrderShippingServer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @author xgp
 * @version 1.0
 * @date 3/23 10:09
 * @table
 */
@Service
public class OrderShippingServerImpl extends MapperTools implements OrderShippingServer {


    @Override
    public ResponseEntity deleteByPrimaryKey(String id) {
        return ResponseEntity.success(orderShippingMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResponseEntity insert(OrderShipping record) {
        return ResponseEntity.success(orderShippingMapper.insert(record));
    }


    @Override
    public ResponseEntity insertSelective(OrderShipping record) {
        return ResponseEntity.success(orderShippingMapper.insertSelective(record));
    }

    @Override
    public ResponseEntity selectByPrimaryKey(String id) {
        return ResponseEntity.success(orderShippingMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity updateByPrimaryKeySelective(OrderShipping record) {
        return ResponseEntity.success(orderShippingMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity updateByPrimaryKey(OrderShipping record) {
        return ResponseEntity.success(orderShippingMapper.updateByPrimaryKey(record));
    }

    @Override
    public ResponseEntity getPage(OrderShipping record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        record.setCreate_user(username);
        return ResponseEntity.success(orderShippingMapper.getPage(record));
    }
}