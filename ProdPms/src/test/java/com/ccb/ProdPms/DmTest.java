package com.ccb.ProdPms;

import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.DmdQueryParamsEntity;
import com.ccb.ProdPms.mapper.DmdManageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DmTest {
    @Autowired
    private DmdManageMapper dmdManageMapper;

   /* @Test
    public void testQuery() throws Exception {
        List<DmdManageEntity> dmd = dmdManageMapper.getAll();
        System.out.println(dmd.toString());
        System.out.println("111");
    }*/
    @Test
    public void testQueryParams() {
    	//DmdQueryParamsEntity dmdQueryParamsEntity = new DmdQueryParamsEntity(null, null, null, null, null, null, null, null, null, null);
    	//List<DmdManageEntity> dmd = 
    			//dmdManageMapper.getByParams("","", "", "", "", "", "", "", null, null);
    	//dmdManageMapper.getAll();
    	/*for (int i = 0; i < dmd.size(); i++) {
			System.out.println(dmd);
		}*/
	}
}
