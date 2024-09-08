package com.cwjy.bs.common;




import com.cwjy.bs.orm.dto.ProductReviewsCommodity;
import com.cwjy.bs.orm.mapper.*;
import com.cwjy.bs.server.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author xgp
 * @version 1.0
 * @date 1/19 10:09
 * @table
 */
@Resource
public class DaoTools {

    @Autowired
    protected CategoryDetailsServer categoryDetailsServer;
    @Autowired
    protected ClassificationDetailedServer classificationDetailedServer;
    @Autowired
    protected CommodityCategoryServer commodityCategoryServer;
    @Autowired
    protected CommodityServer commodityServer;
    @Autowired
    protected OrderServer orderServer;
    @Autowired
    protected OrderShippingServer orderShippingServer;
    @Autowired
    protected OrderReturnServer orderReturnServer;
    @Autowired
    protected ProductReviewsServer productReviewsServer;
    @Autowired
    protected ProductReviewsBoardingServer productReviewsBoardingServer;
    @Autowired
    protected ProductReviewsCommodityServer productReviewsCommodityServer;
    @Autowired
    protected PetBoardingServer petBoardingServer;
    @Autowired
    protected RoleServer roleServer;
    @Autowired
    protected UserServer userServer;
    @Autowired
    protected ShoppingCartServer shoppingCartServer;
    @Autowired
    protected HomeServer homeServer;



}
