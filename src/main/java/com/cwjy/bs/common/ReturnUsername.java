package com.cwjy.bs.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xgp
 * @version 1.0
 * @date 3/31 15:45
 * @table
 * @description
 */
public class ReturnUsername {
    public static String getUsername(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = LoginUtilFinal.map.get(session.getId() + "username");
        return username;
    }
    public static String getAdminName(HttpServletRequest request){
        HttpSession session = request.getSession();
        String adminName = LoginUtilFinal.map.get(session.getId() + "username");
        return adminName;
    }
}
