package com.example.demosystem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demosystem.entity.Users;
import com.example.demosystem.mapper.UserMapper;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class SomethingController {

    final
    Users users;

    final
    UserMapper userMapper;

    Logger logger = LoggerFactory.getLogger(SomethingController.class);

    public SomethingController(Users users, UserMapper userMapper) {
        this.users = users;
        this.userMapper = userMapper;
    }

    @GetMapping("something")
    public List<Users> getAll(){
       return userMapper.findAll();
    }

    @RequestMapping("something2")
    public List<Users> getAll2(){
        List<Users> usersList = userMapper.selectList(null);
        return usersList;
    }

    @GetMapping("getusername")
    public String some(){
        return userMapper.selectById(1004).getUsername();
    }

    @GetMapping("update")
    public void update() throws NoSuchAlgorithmException {
        //byte[] salt = getSalt();
        Users users = userMapper.selectById(111L);
        users.setEmail("occtesting@gmail.com");
        userMapper.updateById(users);
        //int insert = userMapper.insert(users);
        //users.setVersion(users.getVersion()+1);
    }

    @GetMapping("newusers")
    public int add() throws NoSuchAlgorithmException {
        byte[] salt = getSalt();
        Users users = new Users();
        users.setUsername("newtesting");
        users.setPassword("newpassword");
        users.setSalt(salt);
        users.setEmail("newtetsing@gmail.com");
        return userMapper.insert(users);
    }


    @GetMapping("batchselect")
    public List<Users> batchselect(){
        logger.trace("Batch select method executed.");
       return userMapper.selectBatchIds(Arrays.asList(1001,111,1002));
    }

    @GetMapping("selectbymap")
    public List<Users> selectbymap(){
        Map<String,Object>map=new HashMap<>();
        map.put("username","test1");
        map.put("password","testing");
        return userMapper.selectByMap(map);
    }

    @GetMapping("paginationtest")
    public void testpage(){
        Page<Users> page = new Page<>(1,2);
        Page<Users> usersPage = userMapper.selectPage(page,null);
        long pages = usersPage.getPages();
        long current = usersPage.getCurrent();
        List<Users> records = usersPage.getRecords();
        long total = usersPage.getTotal();
        boolean hasNext = usersPage.hasNext();
        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
    }

    @GetMapping("deletebyid")
    public int deltebyid(){
        return userMapper.deleteById(1381983369386102786L);
    }

    @GetMapping("querywrapper")
    public List<Users> querywrapper() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("version",1); //ge = greater equal /gt,le,lt
        //queryWrapper.eq("username","newusername");
        queryWrapper.like("email","gmail");
        //queryWrapper.between("","","");
        //queryWrapper.orderByAsc("username");
        List<Users> users = userMapper.selectList(queryWrapper);
        return users;
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

}
