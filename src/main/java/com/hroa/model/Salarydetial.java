package com.hroa.model;

/**
 * 工资详情
 */
public class Salarydetial {
    private Integer id; //工资详情id
    private Integer adminId; //财务id
    private String adminName; //财务名字
    private String telephone; //用户电话
    private String company; //企业
    private String serial; //序列号
    private String number; //工号
    private String name; //用户名字
    private String worktime; //总工时
    private String price; //工价
    private String deserved; //应得工资
    private String meals; //伙食补
    private String dinner; //夜餐补
    private String otherprofit; //其他补贴
    private String salary; //总工资
    private String tax; //所得税
    private String fine; //罚款
    private String sign; //签卡
    private String sdcost; //水电
    private String nontime; //迟到早退
    private String otherfine; //其他扣款
    private String beneficent; //爱心资金
    private String ownleave; //自离扣款
    private String insurance; //保险
    private String borrow; //借支
    private String boardcost; //伙食扣
    private String allcost; //总扣款
    private String realwages; //实发工资
    private String salaryDate; //工资详情所属的月份

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
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

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime == null ? null : worktime.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getDeserved() {
        return deserved;
    }

    public void setDeserved(String deserved) {
        this.deserved = deserved == null ? null : deserved.trim();
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals == null ? null : meals.trim();
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner == null ? null : dinner.trim();
    }

    public String getOtherprofit() {
        return otherprofit;
    }

    public void setOtherprofit(String otherprofit) {
        this.otherprofit = otherprofit == null ? null : otherprofit.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax == null ? null : tax.trim();
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine == null ? null : fine.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getSdcost() {
        return sdcost;
    }

    public void setSdcost(String sdcost) {
        this.sdcost = sdcost == null ? null : sdcost.trim();
    }

    public String getNontime() {
        return nontime;
    }

    public void setNontime(String nontime) {
        this.nontime = nontime == null ? null : nontime.trim();
    }

    public String getOtherfine() {
        return otherfine;
    }

    public void setOtherfine(String otherfine) {
        this.otherfine = otherfine == null ? null : otherfine.trim();
    }

    public String getBeneficent() {
        return beneficent;
    }

    public void setBeneficent(String beneficent) {
        this.beneficent = beneficent == null ? null : beneficent.trim();
    }

    public String getOwnleave() {
        return ownleave;
    }

    public void setOwnleave(String ownleave) {
        this.ownleave = ownleave == null ? null : ownleave.trim();
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance == null ? null : insurance.trim();
    }

    public String getBorrow() {
        return borrow;
    }

    public void setBorrow(String borrow) {
        this.borrow = borrow == null ? null : borrow.trim();
    }

    public String getBoardcost() {
        return boardcost;
    }

    public void setBoardcost(String boardcost) {
        this.boardcost = boardcost == null ? null : boardcost.trim();
    }

    public String getAllcost() {
        return allcost;
    }

    public void setAllcost(String allcost) {
        this.allcost = allcost;
    }

    public String getRealwages() {
        return realwages;
    }

    public void setRealwages(String realwages) {
        this.realwages = realwages == null ? null : realwages.trim();
    }

    public String getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(String salaryDate) {
        this.salaryDate = salaryDate == null ? null : salaryDate.trim();
    }
}