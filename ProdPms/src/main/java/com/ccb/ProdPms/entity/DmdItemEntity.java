package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class DmdItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String reqNo, reqItemDesc, opPerson, reqItemName, reqItemDev, reqItemStatus;
	private String onlineDatetime, createDate, modiDate;
	private int isDeleted, hasFunc;

	public int getHasFunc() {
		return hasFunc;
	}

	public void setHasFunc(int hasFunc) {
		this.hasFunc = hasFunc;
	}

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

	public String getReqItemDesc() {
		return reqItemDesc;
	}

	public void setReqItemDesc(String reqItemDesc) {
		this.reqItemDesc = reqItemDesc;
	}

	public String getOpPerson() {
		return opPerson;
	}

	public void setOpPerson(String opPerson) {
		this.opPerson = opPerson;
	}

	public String getOnlineDatetime() {
		return onlineDatetime;
	}

	public void setOnlineDatetime(String onlineDatetime) {
		this.onlineDatetime = onlineDatetime;
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

	public DmdItemEntity(String reqNo, String reqItemDesc, String opPerson, String reqItemName, String reqItemDev,
			String reqItemStatus, String onlineDatetime, String createDate, String modiDate, int isDeleted,
			int hasFunc) {
		this.reqNo = reqNo;
		this.reqItemDesc = reqItemDesc;
		this.opPerson = opPerson;
		this.reqItemName = reqItemName;
		this.reqItemDev = reqItemDev;
		this.reqItemStatus = reqItemStatus;
		this.onlineDatetime = onlineDatetime;
		this.createDate = createDate;
		this.modiDate = modiDate;
		this.isDeleted = isDeleted;
		this.hasFunc = hasFunc;
	}

	public DmdItemEntity(String reqNo, String reqItemDesc, String opPerson, String reqItemName, String reqItemDev,
			String onlineDatetime, String reqItemStatus, int hasFunc) {
		this.reqNo = reqNo;
		this.reqItemDesc = reqItemDesc;
		this.opPerson = opPerson;
		this.reqItemName = reqItemName;
		this.reqItemDev = reqItemDev;
		this.onlineDatetime = onlineDatetime;
		this.reqItemStatus = reqItemStatus;
		this.hasFunc = hasFunc;
	}

	@Override
	public String toString() {
		return "DmdItemEntity [id=" + id + ", reqNo=" + reqNo + ", reqItemDesc=" + reqItemDesc + ", opPerson="
				+ opPerson + ", reqItemName=" + reqItemName + ", reqItemDev=" + reqItemDev + ", reqItemStatus="
				+ reqItemStatus + ", onlineDatetime=" + onlineDatetime + ", createDate=" + createDate + ", modiDate="
				+ modiDate + ", isDeleted=" + isDeleted + ", hasFunc=" + hasFunc + "]";
	}

	public DmdItemEntity() {
	}

}
