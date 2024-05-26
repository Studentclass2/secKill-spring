package com.seckillweb.seckill.entity;

import lombok.Data;

@Data
public class SecKilRecordEntity {
    private Integer id;
    private Integer userId;
    private Integer productId;

    public SecKilRecordEntity(Integer userId, Integer productId) {
        this.userId = userId;
        this.productId = productId;
    }
}
