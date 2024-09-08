package com.cwjy.bs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xgp
 * @version 1.0
 * @date 3/17 11:26
 * @table
 * @description
 */
@Controller
public class LoginController {
    @RequestMapping("/login_user")
    public String hello() {
        return "login";
    }

    @RequestMapping("/login_admin")
    public String loginAdmin() {
        return "login_admin";
    }

    @RequestMapping("/category")
    public String category() {
        return "category";
    }

    @RequestMapping("/commodity")
    public String Commodity() {
        return "commodity";
    }

    @RequestMapping("/grzx")
    public String Grzx() {
        return "grzx";
    }

    @RequestMapping("/home")
    public String Home() {
        return "home";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/order_review")
    public String order_review() {
        return "order_review";
    }

    @RequestMapping("/personal_order_inquiry")
    public String personal_order_inquiry() {
        return "personal_order_inquiry";
    }

    @RequestMapping("/personal_order_inquiry_admin")
    public String personal_order_inquiry_admin() {
        return "personal_order_inquiry_admin";
    }

    @RequestMapping("/pet_boarding_add")
    public String pet_boarding_add() {
        return "pet_boarding_add";
    }

    @RequestMapping("/pet_boarding_table")
    public String pet_boarding_table() {
        return "pet_boarding_table";
    }

    @RequestMapping("/product_reviews")
    public String product_reviews() {
        return "product_reviews";
    }

    @RequestMapping("/product_reviews_order")
    public String product_reviews_order() {
        return "product_reviews_order";
    }

    @RequestMapping("/registration")
    public String registration() {
        return "registration";
    }

    @RequestMapping("/role")
    public String role() {
        return "role";
    }

    @RequestMapping("/user_admin")
    public String user_admin() {
        return "user_admin";
    }

    @RequestMapping("/shoppingCart")
    public String shoppingCart() {
        return "shoppingCart";
    }

    @RequestMapping("/shipping")
    public String shipping() {
        return "shipping";
    }

    @RequestMapping("/")
    public String shopping_commodity() {
        return "shopping_commodity";
    }

    @RequestMapping("/shoppingHome")
    public String shoppingHome() {
        return "shoppingHome";
    }

    @RequestMapping("/pet_boarding_table_admin")
    public String pet_boarding_table_admin() {
        return "pet_boarding_table_admin";
    }

    @RequestMapping("/product_reviews_boarding")
    public String product_reviews_boarding() {
        return "product_reviews_boarding";
    }

    @RequestMapping("/product_reviews_boarding_user")
    public String product_reviews_boarding_user() {
        return "product_reviews_boarding_user";
    }

    @RequestMapping("/product_reviews_order_user")
    public String product_reviews_order_user() {
        return "product_reviews_order_user";
    }

}
