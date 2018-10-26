package com.ccb.ProdPms;

import com.ccb.ProdPms.mapper.DmdManageMapper;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdPmsApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	public void contextLoads() throws SQLException {
		System.out.println("################" + dataSource.getClass());
		// class com.alibaba.druid.pool.DruidDataSource
		Connection connection = dataSource.getConnection();
		System.out.println("@@@@@@@@@@@@@@@@@" + connection);
		// com.mysql.jdbc.JDBC4Connection@36681447
		connection.close();
	}

}
