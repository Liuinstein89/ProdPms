package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class UploadFileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String fileName, path, type, user,reqNo;
	private Date dateTime;
	private int isDeleted;

	@Override
	public String toString() {
		return "UploadFileEntity{" + "id=" + id + ", reqId=" + reqNo + ", fileName='" + fileName + '\'' + ", path='"
				+ path + '\'' + ", type='" + type + '\'' + ", user='" + user + '\'' + ", dateTime=" + dateTime
				+ ", isDeleted=" + isDeleted + '}';
	}



	public UploadFileEntity(String fileName, String path, String type, String user, String reqNo, int isDeleted) {
		this.fileName = fileName;
		this.path = path;
		this.type = type;
		this.user = user;
		this.reqNo = reqNo;
		this.isDeleted = isDeleted;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
}
