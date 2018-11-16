package com.ccb.ProdPms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class UploadConfiguration {

/*	 @Bean(name = "multipartResolver")
     public MultipartResolver multipartResolver(){
      CommonsMultipartResolver resolver = new CommonsMultipartResolver();
      resolver.setDefaultEncoding("UTF-8");
      //resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
      resolver.setMaxInMemorySize(40960);
      resolver.setMaxUploadSize(50*1024*1024);//上传文件大小 50M 50*1024*1024
      return resolver;
  }*/
	//poi和poi-ooxml
	/*当我们只要使用xls格式时、只要导入poi-version-yyyymmdd.jar就可以了。
	当我们还要使用xlsx格式、还要导入poi-ooxml-version-yyyymmdd.jar。
	至于poi-ooxml-schemas-version-yyyymmdd.jar这个jar基本不太会用到的。
	当我们需要操作word、ppt、viso、outlook等时需要用到poi-scratchpad-version-yyyymmdd.jar。*/
}
