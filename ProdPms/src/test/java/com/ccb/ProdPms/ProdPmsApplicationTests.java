package com.ccb.ProdPms;

import com.ccb.ProdPms.controller.DmdManageController;
import com.ccb.ProdPms.entity.DmdItemEntity;
import com.ccb.ProdPms.mapper.DmdManageMapper;
import com.ccb.ProdPms.service.impl.DmdManageServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
	@Autowired
	DmdManageController dmdManageController;
	@Autowired
	DmdManageServiceImpl dmdManageServiceImpl;
	@Autowired
	DmdManageMapper dmdManageMapper;

	/*
	 * @Test public void contextLoads() throws SQLException {
	 * System.out.println("################" + dataSource.getClass()); // class
	 * com.alibaba.druid.pool.DruidDataSource Connection connection =
	 * dataSource.getConnection(); System.out.println("@@@@@@@@@@@@@@@@@" +
	 * connection); // com.mysql.jdbc.JDBC4Connection@36681447 connection.close(); }
	 */
	@Test
	public void HN() throws Exception {
		// dmdManageController.getReqNo();
		// int count = dmdManageMapper.getLastId();
		// System.out.println("@@@@@@@@@@@@@@@@@"+count);
		// System.out.println("@@@@@@@@@@@@@@@@@" + dmdManageController.getReqNo());
		 DmdItemEntity dmdItemEntity = new DmdItemEntity("PR20181", "描述", "YH",
		 "需求项1", "开发任务1","2018-11-24 00:00:00", "未上线");
		 dmdManageController.addReqItem(dmdItemEntity);
		 //dmdManageMapper.insertDmdItem(dmdItemEntity);
		 System.out.println("111"+dmdItemEntity.toString());
		//String tableName = "req_item";
		//dmdManageMapper.alterTableAutoIncre(tableName);
	}
	/*
	 * INSERT INTO req_item ( req_no, req_item_name, req_item_desc, online_datetime,
	 * req_item_dev, req_item_status, create_time, change_time, op_person,
	 * is_deleted )VALUES( "2323","name","desc","2018-10-31 14:36:32","dev","good",
	 * "2018-10-31 14:36:32","2018-10-31 14:36:32","yh",0 )
	 */

}
