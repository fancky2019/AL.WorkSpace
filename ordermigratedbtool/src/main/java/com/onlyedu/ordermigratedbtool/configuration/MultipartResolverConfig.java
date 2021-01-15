package com.onlyedu.ordermigratedbtool.configuration;

import com.onlyedu.ordermigratedbtool.uploadFile.CustomMultipartResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;


/*
上传文件用
 */
@Configuration
public class MultipartResolverConfig {

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        return new CustomMultipartResolver();
    }

}
