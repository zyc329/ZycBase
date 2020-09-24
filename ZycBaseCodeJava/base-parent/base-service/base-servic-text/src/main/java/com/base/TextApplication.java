package com.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author ZengYc
 */
@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端
/**
 * 开启通用Mapper的包扫描
 * 注解包名：tk.mybatis.spring.annotation.MapperScan
 */
@MapperScan(basePackages = {"com.base.mapper"})
public class TextApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextApplication.class, args);
    }
}
