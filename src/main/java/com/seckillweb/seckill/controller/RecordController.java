package com.seckillweb.seckill.controller;


import com.seckillweb.seckill.entity.SecKillResponseEntity;
import com.seckillweb.seckill.service.impl.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class RecordController {

    @Autowired
    private RecordServiceImpl recordService;

    /**
     * 秒杀权限接口
     * @param request 请求
     * @return SecKillResponseEntity类
     */
    @RequestMapping("/seckill")
    private SecKillResponseEntity secKill(@RequestBody Map<String,Object> request){
        System.out.println("secKill:::: " + request.get("userId").getClass().getName());
        Integer userId = (Integer) request.get("userId");
        Integer productId = (Integer) request.get("productId");
        System.out.println("secKill: " + userId + " " + productId);
        return recordService.secKill(userId,productId);
    }

}
