package com.cwjy.bs.server;

import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.orm.dto.Commodity;

public interface CommodityServer {

    /**
     * 通过ID删除数据
     *
     * @param id: 所要删除数据ID
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:26
     */
    ResponseEntity deleteByPrimaryKey(String id);


    /**
     * 增加数据
     *
     * @param record: 传参增加数据
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:26
     */
    ResponseEntity insert(Commodity record);

    /**
     * 增加部分数据
     *
     * @param record: 传参增加部分数据
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:27
     */
    ResponseEntity insertSelective(Commodity record);

    /**
     * 通过ID获取数据
     *
     * @param id: 传输ID
     * @return: com.hr.bak.product.orm.dto.BakDischarge
     * @Author: XGP
     * @Date: 3/22 8:27
     */
    ResponseEntity selectByPrimaryKey(String id);

    /**
     * 修改部分数据
     *
     * @param record: 所要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:27
     */
    ResponseEntity updateByPrimaryKeySelective(Commodity record);

    /**
     * 修改所有数据
     *
     * @param record: 所有要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity updateByPrimaryKey(Commodity record);

    /**
     * 获取所有数据
     *
     * @param record: 获取数据请求参数
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity getPage(Commodity record);

    /**
     * 获取所有商品评价
     *
     * @param record: 获取数据请求参数
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity getProductReviews(Commodity record);
}