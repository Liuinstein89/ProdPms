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
		// addviewcontroller是以templates为根路径，如果在根路径下的html，则直接在后面setviewname，如果还有文件夹，则在第一个括号中写上文件夹路径
		// registry.addViewController("/admin").setViewName("index.html");这句话表示在templates路径下的admin文件夹内的index文件为一个view，这样在controller中可以return
		registry.addViewController("/").setViewName("index.html");
		registry.addViewController("/").setViewName("admin");
		registry.addViewController("/").setViewName("demand-list");
		registry.addViewController("/").setViewName("demand-add");
		registry.addViewController("/").setViewName("demand-edit");
		// registry.addRedirectViewController("/hello", "/admin.html");
		super.addViewControllers(registry);
	}
}
