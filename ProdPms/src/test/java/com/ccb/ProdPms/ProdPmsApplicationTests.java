package com.ccb.ProdPms;

import com.ccb.ProdPms.mapper.DmdManageMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@MapperScan("com.ccb.ProdPms.dao")
public class ProdPmsApplicationTests {

	@Autowired
	private DmdManageMapper dmdManageMapper;


}
