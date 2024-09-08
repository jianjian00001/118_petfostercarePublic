package com.cwjy.bs.common;


import com.cwjy.bs.orm.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author xgp
 * @version 1.0
 * @date 1/19 10:09
 * @table
 */
@Resource
public class MapperTools {

    @Autowired
    protected CategoryDetailsMapper categoryDetailsMapper;
    @Autowired
    protected ClassificationDetailedMapper classificationDetailedMapper;
    @Autowired
    protected CommodityCategoryMapper commodityCategoryMapper;
    @Autowired
    protected CommodityMapper commodityMapper;
    @Autowired
    protected OrderMapper orderMapper;

    @Autowired
    protected OrderItemMapper orderItemMapper;

    @Autowired
    protected OrderShippingMapper orderShippingMapper;
    @Autowired
    protected OrderShippingItemMapper orderShippingItemMapper;
    @Autowired
    protected OrderReturnMapper orderReturnMapper;
    @Autowired
    protected ProductReviewsMapper productReviewsMapper;
    @Autowired
    protected ProductReviewsBoardingMapper productReviewsBoardingMapper;
    @Autowired
    protected ProductReviewsCommodityMapper productReviewsCommodityMapper;
    @Autowired
    protected PetBoardingMapper petBoardingMapper;
    @Autowired
    protected RoleMapper roleMapper;
    @Autowired
    protected MenuMapper menuMapper;
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected AuthMenuMapper authMenuMapper;
    @Autowired
    protected ShoppingCartMapper shoppingCartMapper;

}
