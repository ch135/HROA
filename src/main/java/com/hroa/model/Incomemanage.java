package com.hroa.model;

import java.util.Date;

/**
 * 收入管理
 */
public class Incomemanage {
    private Integer id; //收入管理id
    private Integer adminId; //财务id
    private String adminName;  //财务名字
    private String serial; //编号
    private String department; //部门
    private String linkMan; //联系人
    private String origin; //收入来源
    private Double money; //收入金额
    private Date incomeDate; //收入时间（Date类型）
    private String sIncomeDate; //收入时间（String类型）
    private String state; //说明

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getsIncomeDate() {
        return sIncomeDate;
    }

    public void setsIncomeDate(String sIncomeDate) {
        this.sIncomeDate = sIncomeDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {this.state = state == null ? null : state.trim();}
}