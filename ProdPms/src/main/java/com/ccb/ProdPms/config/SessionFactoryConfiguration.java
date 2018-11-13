package com.ccb.ProdPms.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import javax.sql.DataSource;
import java.io.IOException;

//SessionFactoryConfiguration用于支持事务的提交

//@Configuration注解用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
// 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。

@Configuration
public class SessionFactoryConfiguration {
	// mybatis-config.xml配置文件的路径
	private static String mybatisConfigFile;

	@Value("${mybatis_config_file}")
	public void setMybatisConfigFile(String mybatisConfigFile) {
		SessionFactoryConfiguration.mybatisConfigFile = mybatisConfigFile;
	}

	// mybatis mapper文件所在路径
	private static String mapperPath;

	@Value("${mybatis.mapper-locations}")
	public void setMapperPath(String mapperPath) {
		SessionFactoryConfiguration.mapperPath = mapperPath;
	}

	// 实体类所在的package
	@Value("${mybatis.type-aliases-package}")
	private String typeAliasPackage;

	@Autowired
	private DataSource dataSource;


	 //创建sqlSessionFactoryBean 实例 并且设置configtion 设置mapper 映射路径 设置datasource数据源
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 设置mybatis configuration 扫描路径
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFile));
		// 添加mapper 扫描路径
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		//String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
		sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(mapperPath));
		// 设置dataSource
		sqlSessionFactoryBean.setDataSource(dataSource);
		// 设置typeAlias 包扫描路径
		sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
		return sqlSessionFactoryBean;
	}

}
