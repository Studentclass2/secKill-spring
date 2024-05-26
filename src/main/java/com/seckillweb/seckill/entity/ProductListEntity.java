package com.seckillweb.seckill.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ProductListEntity {
    private List<ProductEntity> productEntityList;
}
