/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author ADMIN
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.drl.repositories",
    "com.drl.services"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //them bean cloudinary

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
        http.logout().logoutSuccessUrl("/login");
        //Kiem tra loi
        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
//        //Tranh chen dich vu ma doc  
//        http
//                .authorizeRequests()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/").permitAll() // Cho phép tất cả truy cập đến trang chủ
//                .antMatchers("/admin/**").hasAnyRole("ASSISTANT", "ADMIN") // Các URL dưới /admin yêu cầu vai trò ASSISTANT hoặc ADMIN
//                .anyRequest().authenticated() // Tất cả các yêu cầu khác yêu cầu xác thực
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//                .permitAll()
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403") // Trang lỗi khi truy cập bị từ chối
//                .and()
//                .csrf().disable(); // Tạm thời vô hiệu hóa CSRF để dễ dàng cho mục đích thử nghiệm
//    }
//Tranh chen dich vu ma doc  
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ASSISTANT", "ADMIN");
        //Them quyen cho nguoi chinh bai viet
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/home/**").hasAnyRole("ASSISTANT", "ADMIN");
        //Them quyen cho nguoi chinh trang thong k

//         http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/admin/**").access("hasRole('ROLE_CTSVOU')");
        http.csrf().disable();
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dfs6qhtdp",
                "api_key", "783287636326811",
                "api_secret", "I5yF-_c9P7bfo4rLhwoolpZ6kUE",
                "secure", true));
    }

}
