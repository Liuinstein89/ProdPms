package com.ccb.ProdPms.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UploadFileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String fileName, path, type, user, reqNo, datetime;
	private int isDeleted;

	public UploadFileEntity(String fileName, String path, String type, String user, String reqNo, int isDeleted) {
		this.fileName = fileName;
		this.path = path;
		this.type = type;
		this.user = user;
		this.reqNo = reqNo;
		this.isDeleted = isDeleted;
	}
//这里无参构造是因为一直报错no 构造各种类型，加了无参后好了，原因未知   No constructor found in
	public UploadFileEntity() {
	}
}
