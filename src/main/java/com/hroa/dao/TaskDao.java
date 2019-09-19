package com.hroa.dao;

import java.util.List;

import com.hroa.model.AdminModel;
import com.hroa.model.TaskModel;

public interface TaskDao {
	/*添加任务内容*/
	int addTask(TaskModel taskModel);
	/*查询任务数量*/
	int gtTaskAmount();
	/*分页获取任务*/
	List<TaskModel> gtTsByPages(int startPage,int pageSize);
	/*根据部门ID获取用户集合*/
	List<AdminModel> gtAdByDeptId(int dept_id);
	/*批量选取用户的任务*/
	List<AdminModel> getTaskIdList(String[]  users_id);
	/*批量更新用户任务ID*/
	int upTsId(List<AdminModel> adminList);
	/*根据任务ID更新users_id字段*/
	int upUsersId(TaskModel taskModel);
	/*根据任务ID获取users_id*/
	String gtUsersId(int taskId);
	/*根据用户ID获任务ID*/
	String getTaskId(int userId);
	/*根据taskId批量获取task 集合*/
	List<TaskModel> gtTaskListByTsId(String[] task_id);
	
}
