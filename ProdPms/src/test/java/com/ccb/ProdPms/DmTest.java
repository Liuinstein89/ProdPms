package com.ccb.ProdPms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ccb.ProdPms.controller.UploadFileController;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.DmdQueryParamsEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;
import com.ccb.ProdPms.mapper.DmdManageMapper;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DmTest {
	@Autowired
	private DmdManageMapper dmdManageMapper;
	@Autowired
	private UploadFileController uploadFileController;

	/*@Test
	public void testQuery() throws Exception {
		List<DmdManageEntity> dmd = dmdManageMapper.getAll();
		System.out.println(dmd.toString());
	}*/

	// @Test
	public void testQueryParams() {     
		/* DmdQueryParamsEntity dmdQueryParamsEntity = new DmdQueryParamsEntity(null, "",
		 "", "", "", "", "", "", "2018-11-05",
		 "2099-12-31");
		 
		 List<DmdManageEntity> dmd = dmdManageMapper.getByParams(dmdQueryParamsEntity);
		 System.out.println("%%%%%%%%%%%%%%%%"+dmd.toString());*/
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
		DmdManageEntity dmdManageEntity = new DmdManageEntity("3",
				 "ming","lai","dept","fangshi","nwipo","wip","dev","good","qqq"
				 ,modiDate);
		dmdManageMapper.updateReq(dmdManageEntity);
		/*
		 * for (int i = 0; i < dmd.size(); i++) { System.out.println(dmd); }
		 */

	}

}
