package com.garry.ehcache.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.garry.ehcache.demo.dao")
@EnableCaching
public class EhcacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhcacheDemoApplication.class, args);
    }

}
