package com.ccb.ProdPms.controller;


import com.ccb.ProdPms.entity.ReqSourceEntity;
import com.ccb.ProdPms.service.ReqSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reqSource")
public class ReqSourceController {


    @Autowired
    private ReqSourceService reqSourceService;

    @GetMapping("/query/{id}")
    public ReqSourceEntity getReqSource(@PathVariable("id") Integer id){
        return reqSourceService.getReqSourceById(id);
    }

    @GetMapping("/queryAll")
    public List<ReqSourceEntity> getAllReqSource(){
        return reqSourceService.getReqSourceList();
    }

    @GetMapping("/add")
    public ReqSourceEntity insertReqSource(ReqSourceEntity reqSource){
        reqSourceService.addReqSource(reqSource);
        return reqSource;
    }

    @GetMapping("/modify")
    public ReqSourceEntity updateDept(ReqSourceEntity reqSource){
        reqSourceService.modifyReqSource(reqSource);
        return reqSource;
    }

    @GetMapping("/delete/{id}")
    public void deleteReqSource(@PathVariable("id") Integer id){
        reqSourceService.deleteReqSource(id);
    }


}