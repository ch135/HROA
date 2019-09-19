package com.hroa.model;

public class AgentContract {
    private Integer id;

    private Integer agentId;

    private String name;

    private String province;

    private String city;

    private String county;

    private String details;

    private String school;

    private String phone;

    private String url;
    
    private String signDate;

    private String contractCode;
    
    private Integer state;

    

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

    public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
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
		this.signDate = signDate;
	}
    
	
    
}