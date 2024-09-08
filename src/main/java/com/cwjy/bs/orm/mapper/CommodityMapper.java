package com.cwjy.bs.orm.mapper;

import com.cwjy.bs.orm.dto.Commodity;
import com.cwjy.bs.orm.dto.Commodity;
import com.cwjy.bs.orm.entity.CommodityEntity;
import com.cwjy.bs.orm.entity.HomeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityMapper {
    /**
     * 通过ID删除数据
     *
     * @param id: 所要删除数据ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:26
     */
    int deleteByPrimaryKey(String id);


    /**
     * 增加数据
     *
     * @param record: 传参增加数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:26
     */
    int insert(Commodity record);

    /**
     * 增加部分数据
     *
     * @param record: 传参增加部分数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    int insertSelective(Commodity record);

    /**
     * 通过ID获取数据
     *
     * @param id: 传输ID
     * @return: com.hr.bak.product.orm.dto.BakDischarge
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    CommodityEntity selectByPrimaryKey(String id);

    /**
     * 修改部分数据
     *
     * @param record: 所要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    int updateByPrimaryKeySelective(Commodity record);

    /**
     * 修改所有数据
     *
     * @param record: 所有要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    int updateByPrimaryKey(Commodity record);


    /**
     * 增加商品评论数
     *
     * @param id: 商品ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    int addProductReviewsCount(String id);


    /**
     * 减少商品评论数
     *
     * @param id: 商品ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    int cutProductReviewsCount(String id);

    /**
     * 获取所有数据
     *
     * @param record: 获取数据所带条件
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    List<CommodityEntity> getPage(Commodity record);


    /**
     * 增加销售数量
     *
     * @param id: 商品ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    int addSalesVolume(String id);

    /**
     * 商品销售数量By商品
     *
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    List<HomeEntity> salesRanking();


}