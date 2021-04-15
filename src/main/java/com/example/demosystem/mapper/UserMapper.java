package com.example.demosystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demosystem.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<Users> {

    @Select("select * from users")
    List<Users> findAll();

}
