package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class DmdItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String reqNo, reqitemDesc, opPerson, reqItemName, reqItemDev, reqItemStatus;
	private Date onlineDatetime, createDate, modiDate;
	private int isDeleted;

	public String getReqItemName() {
		return reqItemName;
	}

	public void setReqItemName(String reqItemName) {
		this.reqItemName = reqItemName;
	}

	public String getReqItemDev() {
		return reqItemDev;
	}

	public void setReqItemDev(String reqItemDev) {
		this.reqItemDev = reqItemDev;
	}

	public String getReqItemStatus() {
		return reqItemStatus;
	}

	public void setReqItemStatus(String reqItemStatus) {
		this.reqItemStatus = reqItemStatus;
	}

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

	public Date getOnlineDatetime() {
		return onlineDatetime;
	}

	public void setOnlineDatetime(Date onlineDatetime) {
		this.onlineDatetime = onlineDatetime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModiDate() {
		return modiDate;
	}

	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}



	public DmdItemEntity(String reqNo, String reqitemDesc, String opPerson, String reqItemName, String reqItemDev,
			String reqItemStatus, Date onlineDatetime, Date createDate, Date modiDate, int isDeleted) {
		this.reqNo = reqNo;
		this.reqitemDesc = reqitemDesc;
		this.opPerson = opPerson;
		this.reqItemName = reqItemName;
		this.reqItemDev = reqItemDev;
		this.reqItemStatus = reqItemStatus;
		this.onlineDatetime = onlineDatetime;
		this.createDate = createDate;
		this.modiDate = modiDate;
		this.isDeleted = isDeleted;
	}

	public DmdItemEntity() {
	}

}
