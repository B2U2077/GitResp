package com.study.website.config;

/**
 * 使用WebMvcConfigurationSupport可以扩展springMVC的功能
 * 注解@EnableWebMvc 可以接管SpringMVC
 * @author FeiJi
 * @date 2021-03-19
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 上传图片的绝对路径
     */
    @Value("${file.location}")
    String fileLocationPath;

    /**
     * 虚拟路径
     */
    @Value("${file.path}")
    String vpath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        //加上swagger-ui的映射
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/META-INF/resources/templates/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:"+fileLocationPath);
        registry.addResourceHandler("/video/**")
                .addResourceLocations("file:F://Graduation_Project//uploadVideo//");
    }

    /**
     * 所有的WebMvcConfigurerAdapter组件都会一起起作用
     * 将组件注册在容器
     * @return
     */
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //registry.addViewController("/").setViewName("login");
                //registry.addViewController("/index.html").setViewName("login");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                //静态资源：springboot已经做好了静态资源的映射了
                //registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                //    .excludePathPatterns("/login.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
