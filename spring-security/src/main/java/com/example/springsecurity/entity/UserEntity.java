package com.example.springsecurity.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zxy
 * @Classname UserEntity
 * @Date 2022/5/14 18:04
 */
@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @TableId
    private Integer id;

    private String username;
    private String password;

}
