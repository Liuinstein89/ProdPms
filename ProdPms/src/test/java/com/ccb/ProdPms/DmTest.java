package com.ccb.ProdPms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ccb.ProdPms.mapper.DmdManageMapper;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DmTest {
	@Autowired
	private DmdManageMapper dmdManageMapper;

	/*
	 * @Test public void testQuery() throws Exception { List<DmdManageEntity> dmd =
	 * dmdManageMapper.getAll(); 
	 * System.out.println(dmd.toString());
	 * }
	 */
	@Test
	public void testQueryParams() {
		//DmdQueryParamsEntity dmdQueryParamsEntity = new DmdQueryParamsEntity("", "", "", "", "", "", "", "", null,
				//null);
		// List<DmdManageEntity> dmd =
		// dmdManageMapper.getByParams("","", "", "", "", "", "", "", null, null);
		// System.out.println("####################"+dmdManageMapper.getByParams(reqNo,
		// reqName, reqSource, dept, execType, leadTeam, nextUser, reqStatus, beginDate,
		// endDate).toString());
		//System.out.println("###" + dmdManageMapper.getByParams(dmdQueryParamsEntity).toString());
		//dmdManageMapper.deleteById(1);
		//new DmdQueryParamsEntity(555,"mingzi","laiyuan","dept","fangshi","nwipo","wip","design","dev","req","good",,2222-22-22,0);		
		//DmdManageEntity dmdManageEntity = new DmdManageEntity("33", "mingzi","laiyuan","dept","fangshi","nwipo","wip","design","dev","req","good",0);
		//dmdManageMapper.insert(dmdManageEntity);
		
		/*
		 * for (int i = 0; i < dmd.size(); i++) { System.out.println(dmd); }
		 */
	}

}
