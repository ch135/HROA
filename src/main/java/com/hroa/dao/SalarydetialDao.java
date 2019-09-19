package com.hroa.dao;

import com.hroa.model.Salarydetial;

import java.util.List;

public interface SalarydetialDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Salarydetial record);

    int insertSelective(Salarydetial record);

    Salarydetial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salarydetial record);

    int updateByPrimaryKey(Salarydetial record);

    //分页查询工资转账记录
    List<Salarydetial> selectInfoByPage(Integer page);

    //查询数据总条数
    int selectCount();

    //查询财务的名字
    String selectAdminNameById(Integer adminId);

    //根据工号查询数据
    List<Salarydetial> selectInfoByNumber(String number);

    //数据批量插入
    public int insertInfoBatch(List<Salarydetial> salary);
}