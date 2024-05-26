package com.seckillweb.seckill.controller;

import com.seckillweb.seckill.entity.ProductListEntity;
import com.seckillweb.seckill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 商品展示接口
     * @return 所有商品信息
     */
    @RequestMapping("/product")
    public ProductListEntity findAll() {
        return  productService.findAll();
    }

    /* @RequestMapping("/changeStock")
    public boolean changeStock(Integer id){
        return productService.changeStock(id);
    }*/
}
