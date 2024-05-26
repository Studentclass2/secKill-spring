package com.seckillweb.seckill.mapper;

import com.seckillweb.seckill.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from products")
    List<ProductEntity> findAll();

    @Select("select stock from products where id = #{id}")
    Integer checkStock(Integer id);
    @Update("update products set stock = stock - 1 where id = #{id}")
    boolean changeStock(Integer id);
}
