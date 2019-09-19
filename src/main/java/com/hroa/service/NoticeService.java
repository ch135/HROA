package com.hroa.service;

import java.util.List;

import com.hroa.model.NoticeModel;

public interface NoticeService {
	/*添加公告*/
	public int addNotice(NoticeModel noticeModel);
	/*分页获取公告*/
	public List<NoticeModel> gtNtByPage(int startPage,int pageSize);
	/*获取公告的数量*/
	public int getNtAmount();
	/*根据公告ID获取公告信息*/
	public NoticeModel gtNtInfoById(int noticeId);
}
