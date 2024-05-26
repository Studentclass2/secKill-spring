package com.seckillweb.seckill.controller;


import com.seckillweb.seckill.entity.RegisterResponseEntity;
import com.seckillweb.seckill.entity.UserEntity;
import com.seckillweb.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 用户信息查询
     * @param request 前端请求信息
     * @return 对应用户信息
     */
    @RequestMapping("/user")
    public UserEntity findById(@RequestBody Map<String,Object> request) {
        String id = (String) request.get("id");
        return userService.findById(Integer.valueOf(id));
    }

    /**
     * 检测用户信息接口
     * @param request 前端请求信息
     * @return boolean
     */
    @RequestMapping("/check-username")
    public boolean checkUser(@RequestBody Map<String,Object> request) {
        String id = (String) request.get("id");
        System.out.println("check id :" + id);
        return userService.checkUser(Integer.valueOf(id));
    }

    /**
     * 注册接口
     * @param user 用户类
     * @return boolean
     */
    @RequestMapping("/register")
    public ResponseEntity<RegisterResponseEntity> registerUser(@RequestBody UserEntity user){
        System.out.println("register :" + user.toString());
        try {
            UserEntity userEntity = userService.registerUser(user);
            System.out.println("userEntity-toString : " + userEntity.toString());
            System.out.println("注册成功");
            return ResponseEntity.ok(new RegisterResponseEntity(true,userEntity));
        } catch (Exception e) {
            return ResponseEntity.ok(new RegisterResponseEntity(false,null));
        }
    }

    /**
     * 登录接口
     * @param user 用户类
     * @return 用户信息
     */
    @RequestMapping("/login")
    public ResponseEntity<Map<String,Object>> loginUser(@RequestBody UserEntity user){
        System.out.println("login : " + user.toString());
        boolean ok = userService.isUser(user.getId(), user.getPassword());
        System.out.println("ok: " + ok);
        Map<String, Object> response = new HashMap<>();
        if (ok) {
            UserEntity isUser = userService.findById(user.getId());
            response.put("success", true);
            response.put("username", isUser.getUserName());
            response.put("userId",isUser.getId());
            return ResponseEntity.ok(response);
        } else {
            response.put("success",false);
        }
        return ResponseEntity.ok(response);
    }
}
