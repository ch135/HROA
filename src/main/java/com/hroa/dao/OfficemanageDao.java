package com.hroa.dao;

import com.hroa.model.Officemanage;

import java.util.List;

public interface OfficemanageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Officemanage record);

    int insertSelective(Officemanage record);

    Officemanage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Officemanage record);

    int updateByPrimaryKey(Officemanage record);

    //分页查询办公用品数据
    List<Officemanage> selectInfoByPage(Integer page);

    //查询数据总条数
    int selectCount();

    //根据部门查询对应的数据
    List<Officemanage> selectInfoByApartment(String department);

    //查询财务的名字
    String selectAdminNameById(Integer adminId);
}