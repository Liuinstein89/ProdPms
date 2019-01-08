package com.ccb.ProdPms.dto;

import com.ccb.ProdPms.entity.AuditResultEntity;

@SuppressWarnings("serial")
public class DmdAuditDto extends AuditResultEntity {

	private String userDept;

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public DmdAuditDto(String reqNo, String result, String comment, String nextUser, String auditPerson,
			String userDept) {
		super(reqNo, result, comment, nextUser, auditPerson);
		this.userDept = userDept;
	}

	public DmdAuditDto() {
	}

}
