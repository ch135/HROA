package com.hroa.model;

import java.math.BigDecimal;
import java.util.Date;

public class Moneyapply {
    private String id;//编号

    private String phone;//手机号

    private Date freetime;//报销日期

    private Date usetime;//消费日期

    private BigDecimal usemoney;//报销金额

    private String usetype;//消费类型

    private String username;//开支报销人

    private String vouchername;//制单人

    private String agreenname;//批准人

    private String usepeople;//消费对象

    private String department;//承担部门

    private String spendunit;//开支单位

    private String detail;//说明

    private String useplace;//消费地点

    private String applytype;//支付方式

    /**上级审核：0：待审核：1通过；2拒绝*/
    private Integer fristcheck;
    
    /**上上级审核：0：待审核；1通过；2拒绝*/
    private Integer secondcheck;
    
    /**财务审核：0；待处理；1以发款；2拒绝报销*/
    private Integer thirdcheck;
    
    /**是否删除：0：未删除；1：已删除*/
    private Integer result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getFreetime() {
        return freetime;
    }

    public void setFreetime(Date freetime) {
        this.freetime = freetime;
    }

    public Date getUsetime() {
        return usetime;
    }

    public void setUsetime(Date usetime) {
        this.usetime = usetime;
    }

    public BigDecimal getUsemoney() {
        return usemoney;
    }

    public void setUsemoney(BigDecimal usemoney) {
        this.usemoney = usemoney;
    }

    public String getUsetype() {
        return usetype;
    }

    public void setUsetype(String usetype) {
        this.usetype = usetype == null ? null : usetype.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getVouchername() {
        return vouchername;
    }

    public void setVouchername(String vouchername) {
        this.vouchername = vouchername == null ? null : vouchername.trim();
    }

    public String getAgreenname() {
        return agreenname;
    }

    public void setAgreenname(String agreenname) {
        this.agreenname = agreenname == null ? null : agreenname.trim();
    }

    public String getUsepeople() {
        return usepeople;
    }

    public void setUsepeople(String usepeople) {
        this.usepeople = usepeople == null ? null : usepeople.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getSpendunit() {
        return spendunit;
    }

    public void setSpendunit(String spendunit) {
        this.spendunit = spendunit == null ? null : spendunit.trim();
    }
    
    public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getUseplace() {
        return useplace;
    }

    public void setUseplace(String useplace) {
        this.useplace = useplace == null ? null : useplace.trim();
    }

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype == null ? null : applytype.trim();
    }

    public Integer getFristcheck() {
        return fristcheck;
    }

    public void setFristcheck(Integer fristcheck) {
        this.fristcheck = fristcheck;
    }

    public Integer getSecondcheck() {
        return secondcheck;
    }

    public void setSecondcheck(Integer secondcheck) {
        this.secondcheck = secondcheck;
    }

    public Integer getThirdcheck() {
        return thirdcheck;
    }

    public void setThirdcheck(Integer thirdcheck) {
        this.thirdcheck = thirdcheck;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}