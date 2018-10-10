package com.ccb.ProdPms;


import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.ccb.ProdPms.dao")
//或者直接在Mapper类上面添加注解@Mapper,建议使用上面那种，不然每个mapper加个注解也挺麻烦的
public class ProdPmsApplication {

    private static final Logger logger = Logger.getLogger(ProdPmsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProdPmsApplication.class, args);
        logger.info("========================启动完毕========================");
    }
}

