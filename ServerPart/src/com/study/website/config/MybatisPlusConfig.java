package com.study.website.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FeiJi
 * @date 2021-03-31
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        //分页查询
        return new PaginationInterceptor();
    }

    //@Bean
    //public MultipartConfigElement multipartConfigElement(@Value("${multipart.maxFileSize}")String maxFileSize, @Value("${multipart.maxRequestSize}") String maxRequestSize) {
    //    MultipartConfigFactory factory = new MultipartConfigFactory();
    //    factory.setMaxFileSize(DataSize.parse(maxFileSize));
    //    factory.setMaxRequestSize(DataSize.parse(maxRequestSize));
    //    return factory.createMultipartConfig();
    //}
}
