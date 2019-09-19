package com.hroa.model;

import java.util.Date;

/**
 * 工资管理
 */
public class Salarymanage {
    private Integer id; //工资管理的id
    private Integer adminId; //财务id
    private String adminName;  //财务名字
    private String serial; //编号
    private String company; //厂名
    private String number; //工号
    private String name; //名字
    private String sex; //性别
    private String cardName; //开户名
    private String bankCard; //银行卡
    private String bank; //开户行
    private Double money; //金额
    private String remark; //备注
    private String salaryDate; //工资所属的时间（格式：yyyy-MM）

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name == null ? null : name.trim();}

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(String salaryDate) {
        this.salaryDate = salaryDate;
    }
}