package com.seckillweb.seckill.mapper;

import com.seckillweb.seckill.entity.SecKilRecordEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RecordMapper {
    @Select("select * from seckill_record where userId = #{userId} and productId = #{productId}")
    SecKilRecordEntity findByUIdPId(Integer userId,Integer productId);

    @Insert("insert into seckill_record(userId,productId) values (#{userId},#{productId})")
    void insert(SecKilRecordEntity secKilRecord);

}
