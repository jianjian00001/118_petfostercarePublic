package com.cwjy.bs.server.impl;

import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.MapperTools;
import com.cwjy.bs.config.BaseException;
import com.cwjy.bs.orm.dto.AuthMenu;
import com.cwjy.bs.orm.dto.Menu;
import com.cwjy.bs.orm.dto.Role;
import com.cwjy.bs.orm.entity.RoleEntity;
import com.cwjy.bs.server.RoleServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author xgp
 * @version 1.0
 * @date 3/15 17:38
 * @table
 * @description
 */
@Service
public class RoleServerImpl extends MapperTools implements RoleServer {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(String id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role.getRole_name().equals("系统管理员")){
            throw new BaseException("系统管理员无法进行修改！");
        }
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoleEntity record) {
        int count = roleMapper.selectByName(record.getRole_name());
        if(count > 0){
            throw new BaseException("当前角色名已存在！");
        }
        record.initSave(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        String role_code = UUID.randomUUID().toString().replaceAll("-", "");
        record.setId(role_code);
        List<Menu> menus = menuMapper.getAll();
        List<AuthMenu> menuList = new ArrayList<>();
        menus.stream().forEach(item -> {
            AuthMenu authMenu = new AuthMenu();
            authMenu.setIs_directory(item.getIs_directory());
            authMenu.setMenu_name(item.getMenu_name());
            authMenu.setMenu_url(item.getMenu_url());
            authMenu.setMenu_icon(item.getMenu_icon());
            authMenu.setTags(item.getTags());
            authMenu.setSort(item.getSort());
            authMenu.setTop(item.getTop());
            authMenu.setMenu_id(item.getId());
            authMenu.setRole_code(role_code);
            authMenu.setIs_auth(0);
            menuList.add(authMenu);
        });
        if(menuList.size() > 0){
            authMenuMapper.insert(menuList);
        }
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleEntity record) {
        record.initSave(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        return roleMapper.insert(record);
    }

    @Override
    public Role selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<Role> getPage(RoleEntity record) {
        return roleMapper.getPage(record);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleEntity record) {
        Role role = roleMapper.selectByPrimaryKey(record.getId());
        if(role.getRole_name().equals("系统管理员")){
            throw new BaseException("系统管理员无法进行修改！");
        }
        record.initUpdate(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleEntity record) {
        record.initUpdate(LoginUtilFinal.map.get(LoginUtilFinal.session + "username"));
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectByName(String Rolename) {
        return roleMapper.selectByName(Rolename);
    }

    @Override
    public List<Role> getAll() {
        return roleMapper.getAll();
    }
}
