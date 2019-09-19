package com.hroa.model;

import java.util.Date;

/**
 * 办公用品管理
 */
public class Officemanage {
    private Integer id; //办公用品id
    private Integer adminId; //财务id
    private String adminName; //财务名字
    private String serial; //办公用品编号
    private String name; //办公用品名字
    private String department; //办公用品部门
    private String manager; //管理人
    private Date buyTime; //采购时间(date类型)
    private String sBuyTime; //采购时间(String类型)
    private Double price; //采购价格

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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getsBuyTime() {
        return sBuyTime;
    }

    public void setsBuyTime(String sBuyTime) {
        this.sBuyTime = sBuyTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}