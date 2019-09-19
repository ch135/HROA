package com.hroa.service;

import java.util.List;

import com.hroa.model.AdminModel;
import com.hroa.model.TaskModel;

public interface TaskService {
	/*添加任务内容*/
	public int addTaskTxt(TaskModel taskModel);
	/*查询任务数量*/
	public int gtTaskAmount();
	/*分页获取任务*/
	public List<TaskModel> gtTsByPages(int startPage,int pageSize);
	/*根据部门ID获取用户集合*/
	public List<AdminModel> gtAdByDeptId(int dept_id);
	/*批量选取用户的任务*/
	public List<AdminModel> getTaskIdList(String[]  users_id);
	/*批量更新用户任务ID*/
	public int upTsId(List<AdminModel> adminList);
	/*根据任务ID更新users_id字段*/
	public int upUsersId(TaskModel taskModel);
	/*根据任务ID获取users_id*/
	public String gtUsersId(int taskId);
	/*根据用户ID获任务ID*/
	public String getTaskId(int userId);
	/*根据taskId批量获取task 集合*/
	public List<TaskModel> gtTaskListByTsId(String[] task_id);
}
