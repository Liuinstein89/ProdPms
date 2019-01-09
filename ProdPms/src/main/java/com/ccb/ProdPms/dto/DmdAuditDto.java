package com.ccb.ProdPms.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DmdAuditDto {

	private String userDep,reqNo,result,comment,nextUser,auditPerson;
	private Date auditTime;
	public DmdAuditDto(String reqNo, String result, String comment, String nextUser, String auditPerson,
			String userDep,Date auditTime) {
		this.reqNo = reqNo;
		this.userDep = userDep;
		this.result = result;
		this.comment = comment;
		this.nextUser = nextUser;
		this.auditPerson =auditPerson;
		this.auditTime =auditTime;
	}

	public DmdAuditDto() {
	}

}
