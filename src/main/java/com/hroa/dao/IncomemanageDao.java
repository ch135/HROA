package com.hroa.dao;

import com.hroa.model.Incomemanage;

import java.util.List;

public interface IncomemanageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Incomemanage record);

    int insertSelective(Incomemanage record);

    Incomemanage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Incomemanage record);

    int updateByPrimaryKeyWithBLOBs(Incomemanage record);

    int updateByPrimaryKey(Incomemanage record);

    //分页查询收入管理数据
    List<Incomemanage> selectInfoByPage(Integer page);

    //查询数据总条数
    int selectCount();

    //根据时间查询对应的数据
    List<Incomemanage> selectInfoByDate(String content);

    //查询财务的名字
    String selectAdminNameById(Integer adminId);

    //根据时间查询对应的全部数据
    List<Incomemanage> selectApartInfo(String content);

    //查询全部数据
    List<Incomemanage> selecAllInfo();
}