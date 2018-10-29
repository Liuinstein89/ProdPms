package com.ccb.ProdPms.entity;

import java.io.Serializable;

public class DmdItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String reqNo, reqitemDesc, opPerson;
	private String createDate, modiDate;
	private int isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReqNo() {
		return reqNo;
	}

	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}

	public String getReqitemDesc() {
		return reqitemDesc;
	}

	public void setReqitemDesc(String reqitemDesc) {
		this.reqitemDesc = reqitemDesc;
	}

	public String getOpPerson() {
		return opPerson;
	}

	public void setOpPerson(String opPerson) {
		this.opPerson = opPerson;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModiDate() {
		return modiDate;
	}

	public void setModiDate(String modiDate) {
		this.modiDate = modiDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public DmdItemEntity(String reqNo, String reqitemDesc, String opPerson, String createDate, String modiDate,
			int isDeleted) {
		this.reqNo = reqNo;
		this.reqitemDesc = reqitemDesc;
		this.opPerson = opPerson;
		this.createDate = createDate;
		this.modiDate = modiDate;
		this.isDeleted = isDeleted;
	}

	public DmdItemEntity() {
	}

}
