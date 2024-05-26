package com.seckillweb.seckill.service.impl;

import com.seckillweb.seckill.entity.ProductEntity;
import com.seckillweb.seckill.entity.ProductListEntity;
import com.seckillweb.seckill.mapper.ProductMapper;
import com.seckillweb.seckill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    /**
     * 查询所有商品
     * @return 商品列表
     */
    @Override
    public ProductListEntity findAll (){
        List<ProductEntity> products = productMapper.findAll();
        ProductListEntity productList = new ProductListEntity();
        productList.setProductEntityList(products);
        return productList;
    }

    /**
     * 判断商品是否还有库存
     * @param id 商品id
     * @return boolean
     */
    @Override
    public boolean changeStock(Integer id) {
        Integer stock = productMapper.checkStock(id);
        if (stock > 0 )
            return productMapper.changeStock(id);
        else
            return false;
    }
}
