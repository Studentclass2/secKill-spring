package com.seckillweb.seckill.mapper;

import com.seckillweb.seckill.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 根据id查找并返回用户的全部信息
     * @param id 账号参数
     * @return int
     */
    @Select("select * from users where id = #{id}")
    UserEntity findById(Integer id);

    @Select("select * from users where id = #{id}")
    @ResultType(Integer.class)
    Integer existsByUserId(Integer id);

    @Insert("insert into users (id,username,password) values (#{id},#{userName},#{password})")
    void insert(UserEntity user);



}
