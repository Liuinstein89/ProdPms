package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AuditResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String result, comment, auditPerson, nextUser, reqNo;
	private Date auditTime;
	private int isDeleted;

	public AuditResultEntity(String reqNo, String result, String comment, String nextUser,String auditPerson) {
		this.reqNo = reqNo;
		this.result = result;
		this.comment = comment;
		this.nextUser = nextUser;
		this.auditPerson = auditPerson;
	}

	public AuditResultEntity() {
	}
}
