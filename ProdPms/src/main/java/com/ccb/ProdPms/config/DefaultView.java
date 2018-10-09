package com.ccb.ProdPms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/*
* Springboot默认配置下访问的默认页面是 classpath路径下的四个目录中的index.html，这四个目录分别是
* /static         
* /public        
* /resources        
* /META-INFO/resources
* 而Springboot自动生成项目结构中有static和template，于是就想着把index.html页面直接放在static目录下。
* 放入之后发现thymeleaf的th标签属性不会被替换。而在template文件下新建的html页面可以正常使用th属性。于是将index.html页面放在
* 了template目录下，并添加viewController修改默认访问页面为template下的index.html
* */


@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        super.addViewControllers(registry);
    }
}
