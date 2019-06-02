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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iceyyy.icessm.pojo.User;
import com.iceyyy.icessm.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="用户管理")
@Controller
@RequestMapping(value = "/user")
public class UserController {
    // private static Logger log =
    // LoggerFactory.getLogger(UserController.class);
    private static Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping("/user")
    public String user(HttpServletRequest request, HttpServletResponse response) {
        List<User> user = userService.getAll();
        request.setAttribute("user", user);
        System.out.println("查询用户");
        return "user";
    }

    // http://127.0.0.1:8080/icessm/user/page.do?pageSize=10&pageNum=1
    @ApiOperation(value = "分页查询用户", notes = "分页查询用户")
    @ResponseBody
    @RequestMapping("/page")
    public PageInfo<User> page(Page<User> page,User user, HttpServletRequest request, HttpServletResponse response) {
        log.info("查询用户信息");
        PageInfo<User> pageInfo = userService.pageUser(page, user);
        return pageInfo;
    }

    // http://127.0.0.1:8080/icessm/user/getUserById.do?userId=1001
    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户")
    @ResponseBody
    @RequestMapping("/getUserById")
    public User getUserById(Integer userId, HttpServletRequest request, HttpServletResponse response) {
    	log.info("根据id查询用户");
    	User user = userService.getUserById(userId);
    	return user;
    }

    // http://127.0.0.1:8080/icessm/user/saveUser.do?username=zs&password=ls
    @ApiOperation(value = "保存用户", notes = "保存用户")
    @ResponseBody
    @RequestMapping("/saveUser")
    public User saveUser(User user, HttpServletRequest request, HttpServletResponse response) {
    	log.info("保存用户");
    	userService.saveUser(user);
    	return user;
    }

    // http://127.0.0.1:8080/icessm/user/updateUserBatch.do?ids=1001,1002&username=zs
    @ApiOperation(value = "批量更新用户", notes = "批量更新用户")
    @ResponseBody
    @RequestMapping("/updateUserBatch")
    public User updateUserBatch(User user, String ids, HttpServletRequest request, HttpServletResponse response) {
    	log.info("批量更新用户");
    	userService.updateUserBatch(user, ids);
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
