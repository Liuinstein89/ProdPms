package com.ccb.ProdPms.controller.demandController;


import com.ccb.ProdPms.service.demandService.DmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.swing.BakedArrayList;

import java.util.List;

@Controller
@EnableAutoConfiguration
//@RequestMapping("/demandManage")
public class DmdManageController {
    @Autowired
    private DmdService dmdService;

    @RequestMapping(value = "/demand")
    public List<Demand> getAll(Demand demand) {
        List<Demand> demandList = new BakedArrayList();
        return demandList;
    }
}
