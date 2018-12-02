package com.ccb.ProdPms;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.ccb.ProdPms.mapper")
// 或者直接在Mapper类上面添加注解@Mapper,建议使用上面那种，不然每个mapper加个注解很麻烦的
public class ProdPmsApplication extends SpringBootServletInitializer {

	private static final Logger logger = Logger.getLogger(ProdPmsApplication.class);

	/**
	 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure
	 * 方法;我们需要类似于web.xml的配置方式来启动spring上下文了，在Application类的同级添加一个SpringBootStartApplication类
	 */
/*	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProdPmsApplication.class);
    }*/


	/*
	 * @Bean public MultipartConfigElement multipartConfigElement() {
	 * MultipartConfigFactory factory = new MultipartConfigFactory(); //// 设置文件大小限制
	 * ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了; factory.setMaxFileSize("128KB"); //KB,MB ///
	 * 设置总上传数据总大小 factory.setMaxRequestSize("256KB"); //Sets the directory location
	 * wherefiles will be stored. //factory.setLocation("路径地址"); return
	 * factory.createMultipartConfig(); }
	 */

	public static void main(String[] args) {
		SpringApplication.run(ProdPmsApplication.class, args);
		logger.info("========================启动完毕========================");
	}
}
