package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class UploadFileEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id, reqId;
    private String fileName, add, type, user;
    private Date dateTime;
    private int isDeleted;

    @Override
    public String toString() {
        return "UploadFileEntity{" +
                "id=" + id +
                ", reqId=" + reqId +
                ", fileName='" + fileName + '\'' +
                ", add='" + add + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", dateTime=" + dateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
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
