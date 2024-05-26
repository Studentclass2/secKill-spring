package com.seckillweb.seckill.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductEntity {
    private Integer id;
    private String name;
    private String original_price;
    private String secKill_price;
    private Integer stock;
    private Timestamp secKill_start_time;
    private String img_path;
}
