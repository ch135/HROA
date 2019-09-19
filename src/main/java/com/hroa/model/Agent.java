package com.hroa.model;

public class Agent {
    private Integer id;

    private Integer userId;

    private String identity;

    private String telephone;

    private String sex;

    private String name;

    private String idcardNum;

    private String idcardFront;

    private String idcardBack;

    private String applyProvince;

    private String applyCity;

    private String applyRegion;

    private String province;

    private String city;

    private String region;

    private String qrcode;

    private String failureInfo;

    private Integer applyStatus;

    private String manager;

    private String managerTel;

    private String agentType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcardNum() {
        return idcardNum;
    }

    public void setIdcardNum(String idcardNum) {
        this.idcardNum = idcardNum == null ? null : idcardNum.trim();
    }

    public String getIdcardFront() {
        return idcardFront;
    }

    public void setIdcardFront(String idcardFront) {
        this.idcardFront = idcardFront == null ? null : idcardFront.trim();
    }

    public String getIdcardBack() {
        return idcardBack;
    }

    public void setIdcardBack(String idcardBack) {
        this.idcardBack = idcardBack == null ? null : idcardBack.trim();
    }

    public String getApplyProvince() {
        return applyProvince;
    }

    public void setApplyProvince(String applyProvince) {
        this.applyProvince = applyProvince == null ? null : applyProvince.trim();
    }

    public String getApplyCity() {
        return applyCity;
    }

    public void setApplyCity(String applyCity) {
        this.applyCity = applyCity == null ? null : applyCity.trim();
    }

    public String getApplyRegion() {
        return applyRegion;
    }

    public void setApplyRegion(String applyRegion) {
        this.applyRegion = applyRegion == null ? null : applyRegion.trim();
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

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public String getFailureInfo() {
        return failureInfo;
    }

    public void setFailureInfo(String failureInfo) {
        this.failureInfo = failureInfo == null ? null : failureInfo.trim();
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel == null ? null : managerTel.trim();
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType == null ? null : agentType.trim();
    }

    
}