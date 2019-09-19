package com.hroa.model;

import java.math.BigDecimal;

public class ShUser {
    private Integer id;

    private String telephone;

    private String username;

    private String password;

    private String realname;

    private String sex;

    private String birthday;

    private String icno;

    private String idcard;

    private String school;

    private String major;

    private String province;

    private String city;

    private String region;

    private String linkPhone;

    private String requires;

    private Integer eager;

    private Integer jobType;

    private String entryTime;

    private BigDecimal balance;

    private String bankCard;

    private Integer point;

    private Integer sign;

    private Integer isSupplement;

    private String registerdate;

    private String logindate;

    private Integer agentId;

    private Integer agentApply;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getIcno() {
        return icno;
    }

    public void setIcno(String icno) {
        this.icno = icno == null ? null : icno.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public String getRequires() {
        return requires;
    }

    public void setRequires(String requires) {
        this.requires = requires == null ? null : requires.trim();
    }

    public Integer getEager() {
        return eager;
    }

    public void setEager(Integer eager) {
        this.eager = eager;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime == null ? null : entryTime.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Integer getIsSupplement() {
        return isSupplement;
    }

    public void setIsSupplement(Integer isSupplement) {
        this.isSupplement = isSupplement;
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate == null ? null : registerdate.trim();
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate == null ? null : logindate.trim();
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getAgentApply() {
        return agentApply;
    }

    public void setAgentApply(Integer agentApply) {
        this.agentApply = agentApply;
    }
}