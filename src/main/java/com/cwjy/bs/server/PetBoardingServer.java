package com.cwjy.bs.server;

import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.orm.dto.PetBoarding;

/**
 * @author xgp
 * @version 1.0
 * @date 3/24 9:18
 * @table
 * @description
 */
public interface PetBoardingServer {

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
    ResponseEntity insert(PetBoarding record);

    /**
     * 增加部分数据
     *
     * @param record: 传参增加部分数据
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:27
     */
    ResponseEntity insertSelective(PetBoarding record);

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
    ResponseEntity updateByPrimaryKeySelective(PetBoarding record);

    /**
     * 修改所有数据
     *
     * @param record: 所有要修改数据
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity updateByPrimaryKey(PetBoarding record);



    /**
     * 获取所有数据
     *
     * @param record: 获取数据请求参数
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity getPage(PetBoarding record);
    /**
     * 获取所有数据系统管理员
     *
     * @param record: 获取数据请求参数
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity getPageAdmin(PetBoarding record);

    /**
     * 同意寄养预约
     *
     * @param record: 获取数据请求参数
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity agree(PetBoarding record);



    /**
     * 拒绝寄养预约
     *
     * @param record: 获取数据请求参数
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity refuse(PetBoarding record);

    /**
     * 宠物入住
     *
     * @param record: 获取数据请求参数
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity checkIn(PetBoarding record);


    /**
     * 寄养完成
     *
     * @param record: 获取数据请求参数
     * @return: int
     * @Author: XGP
     * @Date: 3/22 8:28
     */
    ResponseEntity complete(PetBoarding record);
}
