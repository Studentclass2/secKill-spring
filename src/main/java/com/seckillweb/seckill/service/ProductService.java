package com.seckillweb.seckill.service;

import com.seckillweb.seckill.entity.ProductListEntity;

public interface ProductService {
    ProductListEntity findAll();

    boolean changeStock(Integer id);
}
