package com.ccb.ProdPms;

import javax.servlet.MultipartConfigElement;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.ccb.ProdPms.mapper")
// 或者直接在Mapper类上面添加注解@Mapper,建议使用上面那种，不然每个mapper加个注解很麻烦的
public class ProdPmsApplication {

/*	@Bean 
    public MultipartConfigElement multipartConfigElement() { 
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("128KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("256KB"); 
        //Sets the directory location wherefiles will be stored.
        //factory.setLocation("路径地址");
        return factory.createMultipartConfig(); 
    } */
	
	private static final Logger logger = Logger.getLogger(ProdPmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProdPmsApplication.class, args);
		logger.info("========================启动完毕========================");
	}
}
