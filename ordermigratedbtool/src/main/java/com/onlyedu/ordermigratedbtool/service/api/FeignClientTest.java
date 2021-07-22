package com.onlyedu.ordermigratedbtool.service.api;

import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Feign 集成了hystrix ，若调试最好在配置文件
 * feign:
 * hystrix:
 * enabled: false
 * <p>
 * 以便将原始的异常信息抛出
 *
 *
 *
 *
 */

//1、引入依赖
//注意springboot和springcloud的版本对应：https://spring.io/projects/spring-cloud
//<!--  FeignClient：注意版本号和其他版本一致-->
//<dependency>
//<groupId>org.springframework.cloud</groupId>
//<!--注意此处的依赖是SpringBoot2.0以后专用的，如果您使用的SpringBoot版本低于2.0请使用spring-cloud-starter-feign-->
//<artifactId>spring-cloud-starter-openfeign</artifactId>
//<version>2.1.0.RELEASE</version>
//</dependency>
//2、启动类@EnableFeignClients//启用feign。微服务之间调用,服务发现

@FeignClient(name = "feignClientTest", url = "http://localhost:8081/sbp")
public interface FeignClientTest {

    /**
     * 参数前要加 @RequestParam 或post @RequestBody
     *
     * @param name
     * @return
     */
    @GetMapping("/feignclient/getUserInfo")
    String getUserInfo(@RequestParam String name);

    /**
     * 参数前要加 @RequestParam 或post @RequestBody
     *
     * @param
     * @return
     */
    @PostMapping("/feignclient/addUser")
    String addUser(@RequestBody UserInfo userInfo);
}
