package com.ccb.ProdPms;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ccb.ProdPms.controller.DmdManageController;
import com.ccb.ProdPms.dto.DmdItemFuncDto;
import com.ccb.ProdPms.mapper.DmdManageMapper;
import com.ccb.ProdPms.service.impl.DmdManageServiceImpl;

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
		ArrayList<Long> list = new ArrayList<>();
		list.add(0, (long) 1);
		list.add(1, (long) 2);
		DmdItemFuncDto dmdItemEntity = new DmdItemFuncDto("PR201823333", "描述", "YH", "需求项1", "开发任务1", "未上线",
				"2018-11-24 00:00:00", "", 0, 1, list);
		dmdManageController.addReqItem(dmdItemEntity);
		// DmdItemFuncEntity dmdItemFuncEntity = new
		// DmdItemFuncEntity((long)8,(long)1,"YH",null,0);
		// dmdManageMapper.insertDmdItemFunc(dmdItemFuncEntity);
		// String tableName = "req_item";
		// dmdManageMapper.alterTableAutoIncre(tableName);
	}
}
