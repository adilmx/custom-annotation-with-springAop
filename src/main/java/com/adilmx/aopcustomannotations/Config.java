package com.adilmx.aopcustomannotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.adilmx.aopcustomannotations","com.adilmx.aopcustomannotations.aspect"})
@EnableAspectJAutoProxy
public class Config {
}
