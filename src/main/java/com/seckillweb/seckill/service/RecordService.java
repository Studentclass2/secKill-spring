package com.seckillweb.seckill.service;

import com.seckillweb.seckill.entity.SecKillResponseEntity;

public interface RecordService {
    SecKillResponseEntity secKill(Integer userId, Integer productId);
    boolean hasSecKilled(Integer userId, Integer productId);
}
