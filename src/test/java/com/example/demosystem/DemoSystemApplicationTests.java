package com.example.demosystem;

import com.example.demosystem.entity.Users;
import com.example.demosystem.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demosystem.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoSystemApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testmapper(){
        List<Users> userList = userMapper.selectList(null);
        System.out.println(userList);
    }
}
