package com.seckillweb.seckill.entity;


import lombok.Data;

@Data
public class UserEntity {
    private Integer id;
    private String userName;
    private String password;
    private String qq;
    private String weChat;
    private String gitee;
}
