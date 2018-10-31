package com.ccb.ProdPms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FuncController {
	//@GetMapping("/getReqNo")
	public String get() {
		//String reqNo = dmdManageService.getReqNo();
		//reqNo ="PR" + sdf12.format(date) +reqNo;
		return "PR" ;//+ new SimpleDateFormat("yyyyMMdd").format(new Date()) +reqNo;
	}
}
