package com.hroa.model;

import java.math.BigDecimal;

public class JobRecord {
    private Integer id;

    private String telephone;

    private String password;

    private String name;

    private String icno;

    private String label;

    private String linkMan;

    private String linkPhone;

    private String email;

    private String registerdate;

    private String url;

    private String scale;

    private String produce;

    private String job;

    private String cover;

    private String welfare;

    private String required;

    private Integer number=0;

    private String date;

    private String salary;

    private BigDecimal moreSalary;

    private Integer unit;

    private String city;

    private String province;

    private String region;

    private String details;

    private String factoryMan;

    private String factoryPhone;

    private Integer type;

    private String classify;

    private Integer isFinish;

    private String certificates;

    private Integer minage;

    private Integer maxage;

    private String developMan;

    private String developLink;

    private String workType="";

    private String live="";

    private String eatType="";

    private String eatStandard="";

    private String clothesType="";

    private String workTime="";

    private String eatStandardEx;

    private String describes;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcno() {
        return icno;
    }

    public void setIcno(String icno) {
        this.icno = icno == null ? null : icno.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate == null ? null : registerdate.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce == null ? null : produce.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare == null ? null : welfare.trim();
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required == null ? null : required.trim();
    }

    public Integer getNumber() {
    	if(number==null)number=0;
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public BigDecimal getMoreSalary() {
        return moreSalary;
    }

    public void setMoreSalary(BigDecimal moreSalary) {
        this.moreSalary = moreSalary;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getFactoryMan() {
        return factoryMan;
    }

    public void setFactoryMan(String factoryMan) {
        this.factoryMan = factoryMan == null ? null : factoryMan.trim();
    }

    public String getFactoryPhone() {
        return factoryPhone;
    }

    public void setFactoryPhone(String factoryPhone) {
        this.factoryPhone = factoryPhone == null ? null : factoryPhone.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates == null ? null : certificates.trim();
    }

    public Integer getMinage() {
        return minage;
    }

    public void setMinage(Integer minage) {
        this.minage = minage;
    }

    public Integer getMaxage() {
        return maxage;
    }

    public void setMaxage(Integer maxage) {
        this.maxage = maxage;
    }

    public String getDevelopMan() {
        return developMan;
    }

    public void setDevelopMan(String developMan) {
        this.developMan = developMan == null ? null : developMan.trim();
    }

    public String getDevelopLink() {
        return developLink;
    }

    public void setDevelopLink(String developLink) {
        this.developLink = developLink == null ? null : developLink.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live == null ? null : live.trim();
    }

    public String getEatType() {
        return eatType;
    }

    public void setEatType(String eatType) {
        this.eatType = eatType == null ? null : eatType.trim();
    }

    public String getEatStandard() {
        return eatStandard;
    }

    public void setEatStandard(String eatStandard) {
        this.eatStandard = eatStandard == null ? null : eatStandard.trim();
    }

    public String getClothesType() {
        return clothesType;
    }

    public void setClothesType(String clothesType) {
        this.clothesType = clothesType == null ? null : clothesType.trim();
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }

    public String getEatStandardEx() {
        return eatStandardEx;
    }

    public void setEatStandardEx(String eatStandardEx) {
        this.eatStandardEx = eatStandardEx == null ? null : eatStandardEx.trim();
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }
}