package com.hroa.model;

import java.util.Date;

public class Borrow {
    private String id;

    private String name;

    private String department;

    private String phone;

    private String reason;

    private String money;
    /*归还时间*/
    private Date backtime;
    /* 借资时间*/
    private Date applytime;

    private String manager;
    /**0:待审核;1:通过;2拒绝;3删除*/
    private Integer firstcheck;
    /**0:待审核;1:通过;2拒绝;3删除*/
    private Integer secondcheck;
    /**0:未删除；1：已删除*/
    private Integer result;
    /**0:未还钱；1：已还钱*/
    private Integer userrepay;
    /** 申请时的实际时间*/
    private Date realtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public Date getBacktime() {
        return backtime;
    }

    public void setBacktime(Date backtime) {
        this.backtime = backtime;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Integer getFirstcheck() {
        return firstcheck;
    }

    public void setFirstcheck(Integer firstcheck) {
        this.firstcheck = firstcheck;
    }

    public Integer getSecondcheck() {
        return secondcheck;
    }

    public void setSecondcheck(Integer secondcheck) {
        this.secondcheck = secondcheck;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getUserrepay() {
        return userrepay;
    }

    public void setUserrepay(Integer userrepay) {
        this.userrepay = userrepay;
    }

    public Date getRealtime() {
        return realtime;
    }

    public void setRealtime(Date realtime) {
        this.realtime = realtime;
    }

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", name=" + name + ", department="
				+ department + ", phone=" + phone + ", reason=" + reason
				+ ", money=" + money + ", backtime=" + backtime
				+ ", applytime=" + applytime + ", manager=" + manager
				+ ", firstcheck=" + firstcheck + ", secondcheck=" + secondcheck
				+ ", result=" + result + ", userrepay=" + userrepay
				+ ", realtime=" + realtime + "]";
	}

	public Borrow() {
		super();
	}
	
    
}