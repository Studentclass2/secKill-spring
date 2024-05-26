package com.seckillweb.seckill.service.impl;

import java.time.Duration;
import com.seckillweb.seckill.entity.SecKilRecordEntity;
import com.seckillweb.seckill.entity.SecKillResponseEntity;
import com.seckillweb.seckill.mapper.ProductMapper;
import com.seckillweb.seckill.mapper.RecordMapper;
import com.seckillweb.seckill.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;



@Service
public class RecordServiceImpl implements RecordService{


    @Autowired
    private RecordMapper recordMapper;

    /*@Autowired
    private RedisTemplate<String, Boolean> redisTemplate;*/

    @Autowired
    private ProductMapper productMapper;

    /**
     * 判断用户抢购商品时状态和库存
     * @param userId 用户id
     * @param productId 商品id
     * @return SecKillResponseEntity类
     */
    @Override
    public SecKillResponseEntity secKill(Integer userId, Integer productId) {
        System.out.println("seckill: " + productId);
        System.out.println("seckill userId: " + userId);
        if (hasSecKilled(userId, productId)) {
            return new SecKillResponseEntity(false,"您已秒杀过此商品");
        }

        if (productMapper.checkStock(productId) <= 0){
            return new SecKillResponseEntity(false,"该商品库存为0");
        }

        // 将用户对商品的秒杀记录存入 Redis，过期时间设置为一定的时长
        /*String key = "user_seckill:" + userId + ":" + productId;
        redisTemplate.opsForValue().set(key, true, Duration.ofMinutes(10));*/

        SecKilRecordEntity record = new SecKilRecordEntity(userId,productId);
        System.out.println("record: ++" + record);
        recordMapper.insert(record);

        productMapper.changeStock(productId);

        return new SecKillResponseEntity(true,"秒杀成功");

    }

    /**
     * 判断用户抢购状态
     * @param userId 用户id
     * @param productId 商品id
     * @return boolean
     */
    @Override
    public boolean hasSecKilled(Integer userId, Integer productId) {
        SecKilRecordEntity byUIdPId = recordMapper.findByUIdPId(userId, productId);
        return byUIdPId != null;
    }


}
