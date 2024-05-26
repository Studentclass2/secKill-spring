package com.seckillweb.seckill.entity;

import lombok.Data;

@Data
public class RegisterResponseEntity {
    private boolean success;
    private UserEntity user;

    public RegisterResponseEntity(boolean success, UserEntity user) {
        this.success = success;
        this.user = user;
    }
}
