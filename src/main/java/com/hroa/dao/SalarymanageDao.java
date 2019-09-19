package com.hroa.dao;

import com.hroa.model.Salarymanage;

import java.util.List;

public interface SalarymanageDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Salarymanage record);

    int insertSelective(Salarymanage record);

    Salarymanage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salarymanage record);

    int updateByPrimaryKey(Salarymanage record);

    //分页查询工资转账记录
    List<Salarymanage> selectInfoByPage(Integer page);

    //查询数据总条数
    int selectCount();

    //查询财务的名字
    String selectAdminNameById(Integer adminId);

    //根据年-月查询数据
    List<Salarymanage> selectInfoBySalaryDate(String salaryDate);

    //根据时间查询对应的全部数据
    List<Salarymanage> selectApartInfo(String salaryDate);

    //查询全部数据
    List<Salarymanage> selecAllInfo();

    //数据批量插入
    public int insertInfoBatch(List<Salarymanage> salary);
}