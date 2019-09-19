package com.hroa.dao;

import java.util.List;

import com.hroa.model.NoticeModel;

public interface NoticeDao {
	/*添加公告*/
	int addNotice(NoticeModel noticeModel);
	/*分页获取公告数据*/
	List<NoticeModel> gtNtByPage(int startPage,int pageSize);
	/*获取公告的数量*/
	int getNtAmount();
	/*根据公告ID获取公告信息*/
	NoticeModel gtNtInfoById(int noticeId);
}
