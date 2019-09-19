package com.hroa.model;

public class ComContract {
    private Integer id;

    private String cname;

    private String writer;
    
    private Integer writerId;

    private String phone;

    private String url;

    private Integer cId;

    private String contractCode;

    private Integer state;

    private String signDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer == null ? null : writer.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate == null ? null : signDate.trim();
    }

	public Integer getWriterId() {
		return writerId;
	}

	public void setWriterId(Integer writerId) {
		this.writerId = writerId;
	}
    
}