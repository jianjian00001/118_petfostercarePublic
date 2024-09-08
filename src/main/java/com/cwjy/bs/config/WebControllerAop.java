package com.cwjy.bs.config;

import com.cwjy.bs.common.LoginUtilFinal;
import com.cwjy.bs.common.ResponseEntity;
import com.cwjy.bs.orm.dto.User;
import com.cwjy.bs.orm.entity.AdminEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xgp
 * @version 1.0
 * @date 3/30 9:22
 * @table
 * @description
 */
@Aspect
@Component
public class WebControllerAop {
    /**
     * 指定切点
     * 匹配 com.example.demo.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(public * com.cwjy.bs.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * 前置通知，方法调用前被调用
     *
     * @param joinPoint
     */
    @Around("webLog()")
    public Object roundAsp(ProceedingJoinPoint joinPoint) throws Throwable {
        /**获取请求对象数据*/
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        /**获取request对象*/
        HttpServletRequest req = attributes.getRequest();
        /**获取response对象*/
        HttpServletResponse response = attributes.getResponse();
        /**获取session对象*/
        HttpSession session = req.getSession();
        HttpSession adminSession = req.getSession();
        /**获取sessionId*/
        String sessionId = session.getId();
        String token = (String) session.getAttribute(sessionId + "token");
        String path = req.getServletPath();
        System.out.println(path);
        LoginUtilFinal.session = sessionId;
        /**无需权限可通过地址*/
        if (!(path.equals("/Commodity/selectByPrimaryKey") || path.equals("/shopping_commodity")
                || path.equals("/Commodity/getPage") || path.equals("/ShoppingCart/getCount")
                || path.equals("/") || path.equals("/user/login") || path.equals("/login_user")
                || path.equals("/login_admin") || path.equals("/user/getUsername")
                || path.equals("/registration") || path.equals("/user/insert") || path.equals("/user/loginAdmin"))) {
            if (token == null && !(token + sessionId).equals(LoginUtilFinal.map.get(sessionId + "token"))) {
                response.sendRedirect("/cwjy/login_user");
                return ResponseEntity.error();
            }
        }
        /**后台管理员后台，判断是否为超级管理员*/
        if (path.equals("/index")) /*&& !LoginUtilFinal.map.get(LoginUtilFinal.session + "username").equals("admin"))*/ {
         User user =(User)adminSession.getAttribute("adminSession");
           if(!user.getUsername().equals("admin")) {
         response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8;");
            PrintWriter writer = response.getWriter();
            writer.write(
                    "<script type=\"text/javascript\">alert('非管理员账户,无法进入管理员操作界面');window.location.href = '/cwjy/';</script>");
            writer.flush();
            writer.close();
        }}
        return joinPoint.proceed();
    }
}
