package com.cwjy.bs.orm.mapper;

import com.cwjy.bs.orm.dto.ProductReviews;
import com.cwjy.bs.orm.dto.ProductReviewsBoarding;
import com.cwjy.bs.orm.entity.ProductReviewsBoardingEntity;
import com.cwjy.bs.orm.entity.ProductReviewsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductReviewsBoardingMapper {
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
    int insert(ProductReviewsBoarding record);

    /**
     * 增加部分数据
     *
     * @param record: 传参增加部分数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    int insertSelective(ProductReviewsBoarding record);

    /**
     * 通过ID获取数据
     *
     * @param id: 传输ID
     * @return: com.hr.bak.product.orm.dto.BakDischarge
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    ProductReviewsBoardingEntity selectByPrimaryKey(String id);

    /**
     * 修改部分数据
     *
     * @param record: 所要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    int updateByPrimaryKeySelective(ProductReviewsBoarding record);

    /**
     * 修改所有数据
     *
     * @param record: 所有要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    int updateByPrimaryKey(ProductReviewsBoarding record);

    /**
     * 获取所有数据
     *
     * @param record: 获取数据所带条件
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    List<ProductReviewsBoardingEntity> getPage(ProductReviewsBoarding record);


    /**
     * 获取所有订单评价
     *
     * @param record: 获取所有订单评价
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    List<ProductReviewsBoardingEntity> getOrderPage(ProductReviewsBoarding record);
}