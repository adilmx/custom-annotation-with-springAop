package com.adilmx.aopcustomannotations;

import com.adilmx.aopcustomannotations.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.adilmx.aopcustomannotations","com.adilmx.aopcustomannotations.aspect"})
@EnableAspectJAutoProxy
public class Config {
    /*@Bean
    public User user(User user){
        user = new User();
        return user;
    }*/
}
