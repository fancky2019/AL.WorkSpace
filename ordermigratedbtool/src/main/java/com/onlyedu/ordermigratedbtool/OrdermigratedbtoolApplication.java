package com.onlyedu.ordermigratedbtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients//启用feign。微服务之间调用,服务发现
public class OrdermigratedbtoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdermigratedbtoolApplication.class, args);
    }

}
