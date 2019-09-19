package com.hroa.model;

import java.util.Date;

public class Leaveapply {
    private String id;

    private Date applytime;

    private String department;

    private String name;

    private String phone;

    private Date starttime;

    private Date endtime;

    private String reason;

    private String manager;

    /**0:待审核;1:通过;2拒绝;3删除*/
    private Integer fristcheck;
    
    /**0:待审核;1:通过;2拒绝;3删除*/
    private Integer secondcheck;

    /**0:未删除；1：已删除*/
    private Integer result;
    
    public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Integer getFristcheck() {
        return fristcheck;
    }

    public void setFristcheck(Integer frirstcheck) {
        this.fristcheck = frirstcheck;
    }

    public Integer getSecondcheck() {
        return secondcheck;
    }

    public void setSecondcheck(Integer secondcheck) {
        this.secondcheck = secondcheck;
    }
}