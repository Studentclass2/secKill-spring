package com.seckillweb.seckill.entity;

import lombok.Data;

@Data
public class SecKillResponseEntity {
    private boolean success;
    private String message;

    public SecKillResponseEntity(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
