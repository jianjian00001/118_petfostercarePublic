package com.cwjy.bs.config;

import com.alibaba.fastjson.JSON;
import com.cwjy.bs.common.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xgp
 * @version 1.0
 * @date 3/25 14:03
 * @table
 * @description
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();

            try {
                response.setContentType("application/json; charset=UTF-8");
                response.getWriter().write(JSON.toJSONString(ResponseEntity.error("500",e.getMessage())));
                response.getWriter().close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;

    }

    /**
     * @return boolean
     * @description 判断是否是ajax请求
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With").toString()));
    }
}
