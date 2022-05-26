package com.example.springsecurity.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springsecurity.entity.UserEntity;
import com.example.springsecurity.mapper.UserMapper;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author zxy
 * @Classname MyUserDetailsService
 * @Date 2022/5/14 17:49
 */

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("username", username));

        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 权限集合
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user");
        System.out.println(auths);
        System.out.println(user);
        return new User(user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()),auths);
    }
}
