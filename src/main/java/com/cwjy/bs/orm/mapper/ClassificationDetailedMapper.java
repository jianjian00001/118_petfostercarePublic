package com.cwjy.bs.orm.mapper;

import com.cwjy.bs.orm.dto.ClassificationDetailed;
import com.cwjy.bs.orm.entity.ClassificationDetailedEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassificationDetailedMapper {
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
     * 通过类型ID删除数据
     *
     * @param commodity_category_id: 所要删除数据类型ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:26
     */
    int deleteByCommodityCategoryId(String commodity_category_id);



    /**
     * 通过类型ID删除数据
     *
     * @param commodity_category_id: 所要删除数据类型ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:26
     */
    int deleteByCommodityCategoryIdAndCommodityId(String commodity_category_id,String commodity_id);

    /**
     * 增加数据
     *
     * @param record: 传参增加数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:26
     */
    int insert(ClassificationDetailed record);

    /**
     * 增加部分数据
     *
     * @param record: 传参增加部分数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    int insertSelective(ClassificationDetailed record);

    /**
     * 通过ID获取数据
     *
     * @param id: 传输ID
     * @return: com.hr.bak.product.orm.dto.BakDischarge
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    ClassificationDetailedEntity selectByPrimaryKey(String id);



    /**
     * 通过ID获取数据
     *
     * @param commodity_category_id: 类型ID
     * @param commodity_id: 商品ID
     * @return: com.hr.bak.product.orm.dto.BakDischarge
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    List< ClassificationDetailedEntity> selectByCommodityCategoryIdAndCommodityId(String commodity_category_id,String commodity_id);



    /**
     * 修改部分数据
     *
     * @param record: 所要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    int updateByPrimaryKeySelective(ClassificationDetailed record);

    /**
     * 修改所有数据
     *
     * @param record: 所有要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    int updateByPrimaryKey(ClassificationDetailed record);
}