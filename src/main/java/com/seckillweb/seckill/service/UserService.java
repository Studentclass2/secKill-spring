package com.seckillweb.seckill.service;

import com.seckillweb.seckill.entity.UserEntity;

public interface UserService {
    UserEntity findById(Integer id);

    boolean checkUser (Integer id);

    UserEntity registerUser (UserEntity user);

    boolean isUser(Integer id, String password);
}
