package com.hroa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.hroa.dao.TaskDao;
import com.hroa.model.AdminModel;
import com.hroa.model.NoticeModel;
import com.hroa.model.TaskModel;
import com.hroa.service.TaskService;
@Service
public class TaskServiceImpl implements TaskService {
	@Resource
	TaskDao taskDao;
	/**
	 * author qwc
	 * 2017年6月27日下午10:14:13
	 * @param TaskTxt
	 * @return
	 * 添加任务内容
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.TaskService#addTaskTxt(java.lang.String)
	 */
	@Override
	public int addTaskTxt(TaskModel taskModel) {
		// TODO Auto-generated method stub
		int addStatus=0;
		addStatus=taskDao.addTask(taskModel);
		return addStatus;
	}
	
	/**
	 * author qwc
	 * 2017年6月29日下午2:49:04
	 * @return
	 * 查询任务数量
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.TaskService#gtTaskAmount()
	 */
	@Override
	public int gtTaskAmount() {
		// TODO Auto-generated method stub
		int amount=0;
		amount=taskDao.gtTaskAmount();
		return amount;
	}
    
	/**
	 * author qwc
	 * 2017年6月29日下午2:52:43
	 * @param startPage
	 * @param pageSize
	 * @return
	 * 分页获取任务
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.TaskService#gtTsByPages(int, int)
	 */
	@Override
	public List<TaskModel> gtTsByPages(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		List<TaskModel> taskList=new ArrayList<TaskModel>();
		taskList=taskDao.gtTsByPages(startPage, pageSize);
		return taskList;
	}
	
	/**
	 * author qwc
	 * 2017年6月30日下午4:36:55
	 * @param dept_id
	 * @return
	 * 根据部门ID获取用户集合
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.TaskService#gtAdByDeptId(int)
	 */
	@Override
	public List<AdminModel> gtAdByDeptId(int dept_id) {
		// TODO Auto-generated method stub
		List<AdminModel> adminList=new ArrayList<AdminModel>();
		System.out.println("TaskServiceImpl:"+dept_id);
		adminList=taskDao.gtAdByDeptId(dept_id);
		System.out.println("TaskServiceImpl-》adminList:"+JSONArray.fromObject(adminList));
		return adminList;
	}

	@Override
	public List<AdminModel> getTaskIdList(String[]  users_id) {
		// TODO Auto-generated method stub
		List<AdminModel> adminList=new ArrayList<AdminModel>();
		adminList=taskDao.getTaskIdList(users_id);
		return adminList;
	}

	@Override
	public int upTsId(List<AdminModel> adminList) {
		// TODO Auto-generated method stub
		int upStatus=0;
		upStatus=taskDao.upTsId(adminList);
		return upStatus;
	}
	
	/**
	 * author qwc
	 * 2017年7月1日下午6:50:28
	 * @param taskId
	 * @return
	 * 根据任务ID更新users_id
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.TaskService#upUsersId(int)
	 */
	@Override
	public int upUsersId(TaskModel taskModel) {
		// TODO Auto-generated method stub
		int status=taskDao.upUsersId(taskModel);
		return status;
	}
	
	/**
	 * author qwc
	 * 2017年7月1日下午7:06:38
	 * @param taskId
	 * @return
	 * 根据任务ID获取usersId
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.TaskService#gtUsersId(int)
	 */
	@Override
	public String gtUsersId(int taskId) {
		// TODO Auto-generated method stub
		String usersId=null;
		usersId=taskDao.gtUsersId(taskId);
		return usersId;
	}
	
	/**
	 * author qwc
	 * 2017年7月1日下午8:29:48
	 * @param userId
	 * @return
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.TaskService#gettaskId(int)
	 */
	@Override
	public String getTaskId(int userId) {
		// TODO Auto-generated method stub
		String taskId=null;
		taskId=taskDao.getTaskId(userId);
		return taskId;
	}
	
	/**
	 * author qwc
	 * 2017年7月1日下午8:46:00
	 * @param task_id
	 * @return
	 * 根据任务ID批量获取任务集合
	 */
	/* (non-Javadoc)
	 * @see com.hroa.service.TaskService#gtTaskListByTsId(java.lang.String[])
	 */
	@Override
	public List<TaskModel> gtTaskListByTsId(String[] task_id) {
		// TODO Auto-generated method stub
		List<TaskModel> tsList=new ArrayList<TaskModel>();
		tsList=taskDao.gtTaskListByTsId(task_id);
		return tsList;
	}

}
