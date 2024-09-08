package com.cwjy.bs.orm.mapper;

import com.cwjy.bs.orm.dto.OrderShippingItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderShippingItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderShippingItem record);

    int insertSelective(OrderShippingItem record);

    OrderShippingItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderShippingItem record);

    int updateByPrimaryKey(OrderShippingItem record);

    OrderShippingItem getByOrderId(String order_id);

}