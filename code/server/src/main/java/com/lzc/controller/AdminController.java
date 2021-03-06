package com.lzc.controller;

import com.lzc.common.CommonResult;
import com.lzc.pojo.Admin;
import com.lzc.pojo.Token;
import com.lzc.service.AdminService;
import com.lzc.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Lzc
 * @Class : AdminController
 * @description : 管理员控制类
 * @date : 2021-03-07 15:36
 */

@CrossOrigin
@Controller
@RequestMapping("")
public class AdminController {
    @Autowired
    AdminService adminService;


    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Token> login(@RequestBody Admin adminlogin) {
        CommonResult<Token> commonResult;

        System.out.println(adminlogin);

        String tokenString = TokenUtil.sign(adminlogin.getUsername());
        Token token = new Token();
        token.setToken(tokenString);
        System.out.println("token");
        Admin admin = adminService.login(adminlogin.getUsername());
        System.out.println(admin);

        if (admin.getPassword().equals(adminlogin.getPassword())) {
            commonResult = CommonResult.success(token);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }


    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Admin> info() {
        return CommonResult.success(adminService.get(1));
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success("success");
    }


}

