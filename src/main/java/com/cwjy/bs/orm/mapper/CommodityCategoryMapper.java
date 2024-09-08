package com.cwjy.bs.orm.mapper;

import com.cwjy.bs.orm.dto.CommodityCategory;
import com.cwjy.bs.orm.entity.CommodityCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityCategoryMapper {
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
     * @param category_details_id: 所要删除数据类型ID
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:26
     */
    int deleteByCategoryDetailsId(String category_details_id);


    /**
     * 增加数据
     *
     * @param record: 传参增加数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:26
     */
    int insert(List<CommodityCategory> record);

    /**
     * 增加部分数据
     *
     * @param record: 传参增加部分数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    int insertSelective(CommodityCategory record);

    /**
     * 通过ID获取数据
     *
     * @param id: 传输ID
     * @return: com.hr.bak.product.orm.dto.BakDischarge
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    CommodityCategoryEntity selectByPrimaryKey(String id);


    /**
     * 通过ID获取数据
     *
     * @param category_details_id: 类别ID
     * @return: com.hr.bak.product.orm.dto.BakDischarge
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    List<CommodityCategoryEntity> selectByCategoryDetailsId(String category_details_id);

    /**
     * 修改部分数据
     *
     * @param record: 所要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:27
     */
    int updateByPrimaryKeySelective(CommodityCategory record);

    /**
     * 修改所有数据
     *
     * @param record: 所有要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 2021/3/22 8:28
     */
    int updateByPrimaryKey(CommodityCategory record);
}