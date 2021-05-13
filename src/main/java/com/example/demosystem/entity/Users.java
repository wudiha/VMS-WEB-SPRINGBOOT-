package com.example.demosystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@Component
@NoArgsConstructor
@AllArgsConstructor

public class Users {
    @TableId(type = IdType.ASSIGN_ID) //snowflake id
    private Long id;
    private String username;
    private String email;
    private byte[] salt;
    private String password;
    private Date createdDate;
    //@TableField(fill = FieldFill.INSERT_UPDATE)
    //private Date updated_date;
    @Version
    @TableField(fill = FieldFill.DEFAULT)
    private Integer version;
    @TableLogic
    private int isDeleted;


}
