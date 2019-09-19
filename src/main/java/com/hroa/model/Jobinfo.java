package com.hroa.model;

import java.math.BigDecimal;

public class Jobinfo {
    private Integer id;

    private Integer cId;

    private String job;

    private String cover;

    private String label;

    private String required;

    private Integer number;

    private String date;

    private String salary;

    private BigDecimal moreSalary;

    private Integer unit;

    private String city;

    private String province;

    private String region;

    private String details;

    private String linkMan;

    private String linkPhone;

    private Integer type;

    private String classify;

    private Integer isFinish;

    private String describes;

    private ShCompany shCompany;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required == null ? null : required.trim();
    }

    public Integer getNumber() {
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

	/**
	 * @return the shCompany
	 */
	public ShCompany getShCompany() {
		return shCompany;
	}

	/**
	 * @param shCompany the shCompany to set
	 */
	public void setShCompany(ShCompany shCompany) {
		this.shCompany = shCompany;
	}
}