package com.iceyyy.icessm.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iceyyy.icessm.pojo.User;
import com.iceyyy.icessm.service.UserService;

@Controller
public class UserController {
    // private static Logger log =
    // LoggerFactory.getLogger(UserController.class);
    private static Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String user(HttpServletRequest request, HttpServletResponse response) {
        List<User> user = userService.getAll();
        request.setAttribute("user", user);
        System.out.println("查询用户");
        return "user";
    }

    // http://127.0.0.1:8080/icessm/list.do
    @ResponseBody
    @RequestMapping("/list")
    public List<User> list(HttpServletRequest request, HttpServletResponse response) {
        log.info("查询用户信息");
        List<User> user = userService.getAll();
        return user;
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request, HttpServletResponse response) {
        int z = 0 / 0;
        return "user";
    }

    // http://127.0.0.1:8080/icessm/batchDelete.html?ids=1001,1002
    @RequestMapping("/batchDelete")
    public String batchDelete(String[] ids, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ids=" + Arrays.toString(ids));
        System.out.println(Integer.parseInt(ids[1]) * 3);
        int count = userService.deleteBatch(ids);
        System.out.println("删除" + count + "条记录");
        return "user";
    }

    // http://127.0.0.1:8080/icessm/deploy.do
    @ResponseBody
    @RequestMapping("/deploy")
    public String deploy() {
        return "测试test002";
    }
}
