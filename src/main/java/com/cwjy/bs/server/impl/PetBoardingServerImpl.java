package com.cwjy.bs.server.impl;

import com.cwjy.bs.common.EnumCommon;
import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.MapperTools;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.orm.dto.PetBoarding;
import com.cwjy.bs.orm.entity.PetBoardingEntity;
import com.cwjy.bs.server.PetBoardingServer;
import com.cwjy.bs.server.PetBoardingServer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xgp
 * @version 1.0
 * @date 3/23 10:09
 * @table
 */
@Service
public class PetBoardingServerImpl extends MapperTools implements PetBoardingServer {


    @Override
    public ResponseEntity deleteByPrimaryKey(String id) {
        return ResponseEntity.success(petBoardingMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResponseEntity insert(PetBoarding record) {
        return ResponseEntity.success(petBoardingMapper.insert(record));
    }


    @Override
    public ResponseEntity insertSelective(PetBoarding record) {
        return ResponseEntity.success(petBoardingMapper.insertSelective(record));
    }

    @Override
    public ResponseEntity selectByPrimaryKey(String id) {
        return ResponseEntity.success(petBoardingMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity updateByPrimaryKeySelective(PetBoarding record) {
        return ResponseEntity.success(petBoardingMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity updateByPrimaryKey(PetBoarding record) {
        return ResponseEntity.success(petBoardingMapper.updateByPrimaryKey(record));
    }

    @Override
    public ResponseEntity getPage(PetBoarding record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        record.setCreate_user(username);
        List<PetBoardingEntity> mapperPage = petBoardingMapper.getPage(record);
        /**判断订单是否超时 且 注入状态名称*/
        judgmentTimeOut(mapperPage);
        return ResponseEntity.success(mapperPage);
    }

    private void judgmentTimeOut(List<PetBoardingEntity> mapperPage) {
        mapperPage.stream().forEach(item -> {
            item.setStatus_name(EnumCommon.FosterCareStatus.getNameByCode(item.getStatus()));
            boolean flag = item.getStatus() == EnumCommon.FosterCareStatus.APPLYING.getCode() ||
                    item.getStatus() == EnumCommon.FosterCareStatus.MERCHANT_HAS_AGREED.getCode();
            if(flag && System.currentTimeMillis() > item.getReservation_time().getTime()){
                PetBoarding petBoarding = new PetBoarding();
                petBoarding.setId(item.getId());
                petBoarding.setStatus(EnumCommon.FosterCareStatus.FOSTER_CARE_OVERTIME.getCode());
                petBoardingMapper.updateByPrimaryKeySelective(petBoarding);
            }
        });
    }

    @Override
    public ResponseEntity getPageAdmin(PetBoarding record) {
        List<PetBoardingEntity> mapperPage = petBoardingMapper.getPage(record);
        /**判断订单是否超时 且 注入状态名称*/
        judgmentTimeOut(mapperPage);
        return ResponseEntity.success(mapperPage);
    }

    @Override
    public ResponseEntity agree(PetBoarding record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        record.initUpdate(username);
        record.setStatus(EnumCommon.FosterCareStatus.MERCHANT_HAS_AGREED.getCode());
        return ResponseEntity.success(petBoardingMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity refuse(PetBoarding record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        record.initUpdate(username);
        record.setStatus(EnumCommon.FosterCareStatus.MERCHANT_HAS_Refuse.getCode());
        return ResponseEntity.success(petBoardingMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity checkIn(PetBoarding record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        record.initUpdate(username);
        record.setStatus(EnumCommon.FosterCareStatus.CHECK_IN_SUCCESSFULLY.getCode());
        return ResponseEntity.success(petBoardingMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity complete(PetBoarding record) {
        String username = LoginUtilFinal.map.get(LoginUtilFinal.session + "username");
        record.initUpdate(username);
        record.setStatus(EnumCommon.FosterCareStatus.CARRY_OUT.getCode());
        return ResponseEntity.success(petBoardingMapper.updateByPrimaryKeySelective(record));
    }
}