package com.example.springsecurity.confige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author zxy
 * @Classname SpringSecurityConfig
 * @Date 2022/5/14 15:28
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    // 注入数据源
    @Autowired
    private DataSource dataSource;

    /**
     * 记住我功能实现
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){

        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        // 设置数据源
        jdbcTokenRepository.setDataSource(dataSource);
        //在启动时把表创建
        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.formLogin() // 自定义自己编写的登录页面
                .loginPage("/login.html")  //登录页面
                .loginProcessingUrl("/user/login") //登录controller访问路径  但是具体方法内部的代码不用写,只需要定义那个方法controller即可
                .defaultSuccessUrl("/success.html").permitAll() // 登录成功，跳转路径
                .and()                                               // permitAll()是允许此方法


                .logout().logoutUrl("/user/logout")   // 设置注销的路径  不用写具体的方法
                .logoutSuccessUrl("/test/hello").permitAll()   // 退出成功跳转路径

                .and()
                .authorizeRequests()   // 定义哪些方法是否需要认证
                .antMatchers("/","/test/hello","/user/login","/login").permitAll()  //设置哪些路径不需要认证直接访问。

                .antMatchers("/test/index").hasAuthority("admin")   // 具有指定的权限可以访问(指定的全部权限)
                .antMatchers("/test/hello").hasAuthority("admin111")   // 上面放行没用
                .antMatchers("/test/h1").hasAnyAuthority("admin,user,hhh")   // 有其中一个权限就可以了

          //      .antMatchers("/test/index").hasRole("sale")   // 和hasAuthority()类似，  但是会在权限的前面加上一个  ROLE_sale 所以，数据库也要一样
            //    .antMatchers("/test/index").hasAnyRole("sale,admin")   // hasAnyAuthority()类似，  但是会在权限的前面加上一个  ROLE_sale,ROLE_admin 所以，数据库也要一样
                .anyRequest().authenticated()  // 需要认证


                .and().csrf().disable() // 关闭csrf防护

                .rememberMe().tokenRepository(persistentTokenRepository())    // 设置记住我功能自动登录
                .tokenValiditySeconds(60)   // 设置有效时间  秒为单位
                .userDetailsService(userDetailsService) // 查询数据库


                .and()
                .exceptionHandling().accessDeniedPage("/403.html");   // 设置没有权限的跳转页面

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String password = passwordEncoder.encode("123456");
//        auth.inMemoryAuthentication().withUser("zxy").password(password).roles("admin","user");

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    /**
     * 密码配置器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
