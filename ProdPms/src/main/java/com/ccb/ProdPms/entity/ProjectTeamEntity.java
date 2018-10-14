package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class ProjectTeamEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id,teammateNum;
    private String teamName,belongDptCode,teamLeader,teammate,opPerson;
    private Date createTime, changeTime;
    private int isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeammateNum() {
        return teammateNum;
    }

    public void setTeammateNum(Long teammateNum) {
        this.teammateNum = teammateNum;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getBelongDptCode() {
        return belongDptCode;
    }

    public void setBelongDptCode(String belongDptCode) {
        this.belongDptCode = belongDptCode;
    }

    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getTeammate() {
        return teammate;
    }

    public void setTeammate(String teammate) {
        this.teammate = teammate;
    }

    public String getOpPerson() {
        return opPerson;
    }

    public void setOpPerson(String opPerson) {
        this.opPerson = opPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
