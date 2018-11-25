package com.ccb.ProdPms.entity;

import java.io.Serializable;

public class ProjectTeamEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id,teammateNum;
    private String teamName,belongDptCode,teamLeader,teammate,opPerson;
    private String createTime, changeTime;
    private int isDeleted;

    public ProjectTeamEntity() {
    }

    public ProjectTeamEntity( Long teammateNum,String teamName, String belongDptCode, String teamLeader, String teammate,
                              String opPerson,String createTime) {

        this.teammateNum = teammateNum;
        this.teamName = teamName;
        this.belongDptCode = belongDptCode;
        this.teamLeader = teamLeader;
        this.teammate = teammate;
        this.teamLeader = teamLeader;
        this.teamLeader = teamLeader;
        this.opPerson = opPerson;
        this.createTime = createTime;
    }

    public ProjectTeamEntity( Long id,Long teammateNum,String teamName, String belongDptCode, String teamLeader, String teammate,String changeTime) {
        this.id = id;
        this.teammateNum = teammateNum;
        this.teamName = teamName;
        this.belongDptCode = belongDptCode;
        this.teamLeader = teamLeader;
        this.teammate = teammate;
        this.teamLeader = teamLeader;
        this.teamLeader = teamLeader;
//        this.opPerson = opPerson;
        this.changeTime = changeTime;
    }


    public ProjectTeamEntity(Long teammateNum,String teamName, String belongDptCode, String teamLeader, String teammate, String changeTime) {

        this.teammateNum = teammateNum;
        this.teamName = teamName;
        this.belongDptCode = belongDptCode;
        this.teamLeader = teamLeader;
        this.teammate = teammate;
        this.teamLeader = teamLeader;
        this.teamLeader = teamLeader;
        this.opPerson = opPerson;
        this.changeTime = changeTime;
    }


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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
