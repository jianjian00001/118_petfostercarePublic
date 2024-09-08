package com.cwjy.bs.server;

import com.cwjy.bs.common.ResponseEntity;

/**
 * @author xgp
 * @version 1.0
 * @date 4/10 14:00
 * @table
 * @description
 */
public interface HomeServer {

    /**
     * 每日商品订单数
     *
     * @return: com.cwjy.bs.common.ResponseEntity
     * @Author: XGP
     * @Date: 4/10 14:01
     */
    ResponseEntity dailyOrder();

    /**
     * 寄养种类分布
     *
     * @return: com.cwjy.bs.common.ResponseEntity
     * @Author: XGP
     * @Date: 4/10 14:01
     */
    ResponseEntity fosterCareClassification();

    /**
     * 享受排行
     *
     * @return: com.cwjy.bs.common.ResponseEntity
     * @Author: XGP
     * @Date: 4/10 14:01
     */
    ResponseEntity salesRanking();

    /**
     * 每日寄养订单数
     *
     * @return: com.cwjy.bs.common.ResponseEntity
     * @Author: XGP
     * @Date: 4/10 14:01
     */
    ResponseEntity dailyFosterOrder();
}
