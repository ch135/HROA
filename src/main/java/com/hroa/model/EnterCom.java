package com.hroa.model;

import java.util.Date;

public class EnterCom {
    private Integer enterComid;

    private Integer userid;

    private String sendUnit;

    private String sendTelephone;

    private String sendCompany;

    private String workerId;

    private String managerTel;

    private String leaveDate;

    private String leaveReason;
    
    private Date date;
    
    private Boolean isRead;
    
    private Boolean isWork;

    private Boolean isDelete;
    
    private ShUser shUser;
    public Integer getEnterComid() {
        return enterComid;
    }

    public void setEnterComid(Integer enterComid) {
        this.enterComid = enterComid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSendUnit() {
        return sendUnit;
    }

    public void setSendUnit(String sendUnit) {
        this.sendUnit = sendUnit == null ? null : sendUnit.trim();
    }

    public String getSendTelephone() {
        return sendTelephone;
    }

    public void setSendTelephone(String sendTelephone) {
        this.sendTelephone = sendTelephone == null ? null : sendTelephone.trim();
    }

    public String getSendCompany() {
        return sendCompany;
    }

    public void setSendCompany(String sendCompany) {
        this.sendCompany = sendCompany == null ? null : sendCompany.trim();
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel == null ? null : managerTel.trim();
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate == null ? null : leaveDate.trim();
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason == null ? null : leaveReason.trim();
    }

	/**
	 * @return the workerId
	 */
	public String getWorkerId() {
		return workerId;
	}

	/**
	 * @param workerId the workerId to set
	 */
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	/**
	 * @return the shUser
	 */
	public ShUser getShUser() {
		return shUser;
	}

	/**
	 * @param shUser the shUser to set
	 */
	public void setShUser(ShUser shUser) {
		this.shUser = shUser;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	public Boolean getIsWork() {
		return isWork;
	}

	public void setIsWork(Boolean isWork) {
		this.isWork = isWork;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}


}