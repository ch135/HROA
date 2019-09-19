package com.hroa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hroa.dao.NoticeDao;
import com.hroa.model.AdminModel;
import com.hroa.model.NoticeModel;
import com.hroa.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Resource
	NoticeDao noticeDao;
	/**
	 * author qwc
	 * 2017年6月27日下午6:41:08
	 * @param noticeTxt
	 * @return
	 * 添加公告
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.NoticeService#addNotice(java.lang.String)
	 */
	@Override
	public int addNotice(NoticeModel noticeModel) {
		// TODO Auto-generated method stub
		int addStatus=0;
		addStatus=noticeDao.addNotice(noticeModel);
		return addStatus;
	}
	
	/**
	 * author qwc
	 * 2017年6月28日上午10:25:41
	 * @param startPage
	 * @param pageSize
	 * @return
	 * 分页获取公告
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.NoticeService#gtNtByPage(int, int)
	 */
	@Override
	public List<NoticeModel> gtNtByPage(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		List<NoticeModel> gtNtList = new ArrayList<NoticeModel>();
		gtNtList=noticeDao.gtNtByPage(startPage, pageSize);
		return gtNtList;
	}
    
	/**
	 * author qwc
	 * 2017年6月28日上午10:37:23
	 * @return
	 * 获取公告的数量
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.NoticeService#getNtAmount()
	 */
	@Override
	public int getNtAmount() {
		// TODO Auto-generated method stub
		int amount=0;
		amount=noticeDao.getNtAmount();
		return amount;
	}
    
	/**
	 * author qwc
	 * 2017年6月28日下午5:09:16
	 * @param noticeId
	 * @return
	 * 根据公告ID获取公告信息
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.NoticeService#gtNtInfoById(java.lang.String)
	 */
	@Override
	public NoticeModel gtNtInfoById(int noticeId) {
		// TODO Auto-generated method stub
		NoticeModel noticeInfo=new NoticeModel();
		noticeInfo=noticeDao.gtNtInfoById(noticeId);
		return noticeInfo;
	}

}
