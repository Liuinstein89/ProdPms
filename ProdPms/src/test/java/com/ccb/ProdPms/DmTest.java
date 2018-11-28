package com.ccb.ProdPms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ccb.ProdPms.controller.DmdManageController;
import com.ccb.ProdPms.controller.UploadFileController;
import com.ccb.ProdPms.dto.DmdItemFuncDto;
import com.ccb.ProdPms.entity.DmdItemEntity;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.DmdQueryParamsEntity;
import com.ccb.ProdPms.entity.OnlinePlanEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;
import com.ccb.ProdPms.mapper.DmdManageMapper;
import com.ccb.ProdPms.mapper.FuncMapper;
import com.ccb.ProdPms.mapper.OnlinePlanMapper;
import com.ccb.ProdPms.service.DmdManageService;
import com.ccb.ProdPms.service.OnlinePlanService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DmTest {
	@Autowired
	private DmdManageMapper dmdManageMapper;
	@Autowired
	private DmdManageController dmdManageController;
	@Autowired
	private UploadFileController uploadFileController;
	@Autowired
	private DmdManageService dmdManageService;
	@Autowired
	FuncMapper funcMapper;
	@Autowired
	OnlinePlanService onlinePlanService;
	@Autowired
	OnlinePlanMapper onlinePlanMapper;

	@Test
	public void testQuery() throws Exception {
		// List<DmdItemEntity> dmd = dmdManageMapper.getAllReqItem();
		// System.out.println(dmdManageMapper.getUploadFileOfReq("PR1811251017"));
		// dmdManageMapper.deleteUpById(2);
		/*
		 * ArrayList<Long> list = new ArrayList<Long>(); list.add((long) 2);
		 * list.add((long) 3); list.add((long) 4); DmdItemFuncDto dmdItemFuncDto = new
		 * DmdItemFuncDto("3", "4", "4", "4", "4", "4", "2019-02-01 00:23:22", null, 0,
		 * list); dmdManageController.addReqItem(dmdItemFuncDto);
		 */
		
		// System.out.println(onlinePlanMapper.getByParams("a", null));
	}

	// @Test
	public void testQueryParams() {
		/*
		 * DmdQueryParamsEntity dmdQueryParamsEntity = new DmdQueryParamsEntity(null,
		 * "", "", "", "", "", "", "", "2018-11-05", "2099-12-31");
		 * 
		 * List<DmdManageEntity> dmd =
		 * dmdManageMapper.getByParams(dmdQueryParamsEntity);
		 * System.out.println("%%%%%%%%%%%%%%%%"+dmd.toString());
		 */
		// System.out.println("####################"+dmdManageMapper.getByParams(reqNo,
		// reqName, reqSource, dept, execType, leadTeam, nextUser, reqStatus, beginDate,
		// endDate).toString());
		// System.out.println("###" +
		// dmdManageMapper.getByParams(dmdQueryParamsEntity).toString());
		// dmdManageMapper.deleteById(1);
		// new
		// DmdQueryParamsEntity(555,"mingzi","laiyuan","dept","fangshi","nwipo","wip","design","dev","req","good",,2222-22-22,0);
		/*
		 * DmdManageEntity dmdManageEntity = new DmdManageEntity("5",
		 * "mingzi","laiyuan","dept","fangshi","nwipo","wip","design","dev","req","good"
		 * ,null, 0); dmdManageMapper.insert(dmdManageEntity);
		 */
		// uploadFileController.delFile("test.sql");
		// uploadFileController.downloadFile(HttpServletResponse response,
		// "idea快捷键.txt");
		// dmdManageMapper.insertUpload(new
		// UploadFileEntity("321text","E:/temp/","txt","xq", "123",0));
		String modiDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		DmdManageEntity dmdManageEntity = new DmdManageEntity("3", "ming", "lai", "dept", "fangshi", "nwipo", "wip",
				"dev", "good", "qqq", modiDate);
		dmdManageMapper.updateReq(dmdManageEntity);
		/*
		 * for (int i = 0; i < dmd.size(); i++) { System.out.println(dmd); }
		 */

	}

}
