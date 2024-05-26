package com.seckillweb.seckill.service.impl;

import com.seckillweb.seckill.entity.UserEntity;
import com.seckillweb.seckill.mapper.UserMapper;
import com.seckillweb.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 给前端发送当前用户的信息
     * @param id 用户的账号参数
     * @return UserEntity
     */
    @Override
    public UserEntity findById(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * 判断该用户是否存在
     * @param id 账号信息参数
     * @return boolean
     */
    @Override
    public boolean checkUser(Integer id) {
        Integer count = userMapper.existsByUserId(id);
        return count != null && count > 0;
    }

    /**
     * 用户注册
     * @param user 用户信息
     * @return 用户类
     */
    @Override
    public UserEntity registerUser(UserEntity user) {
        userMapper.insert(user);
        return userMapper.findById(user.getId());
    }

    /**
     * 判断登录账号密码是否正确
     * @param id 用户账号
     * @param password 用户密码
     * @return boolean
     */
    @Override
    public boolean isUser(Integer id, String password) {
        System.out.println("isUserImpl : " + id + "," + password);
        UserEntity user = userMapper.findById(id);
        return user != null && user.getPassword().equals(password);
    }
}
