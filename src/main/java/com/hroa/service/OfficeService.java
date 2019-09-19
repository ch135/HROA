package com.hroa.service;

import com.hroa.model.Officemanage;

import java.util.List;

/**
 * 办公用品
 */
public interface OfficeService {

    //添加办公用品
    public int addOffice(Officemanage office);

    //分页查询办公用品
    public List<Officemanage> selectOffice(Integer page);

    //删除数据
    public int delete(Integer id);

    //查询办公用品的详细数据
    public Officemanage selectInfo(Integer id);

    //查询总的页数
    public int selectAllpage();

    //根据部门检索数据
    public List<Officemanage> selectApartmentInfo(String content);

    //查询财务的名字
    public String selectAdminName(Integer adminId);

    //数据更新
    public int updateInfo(Officemanage office);

}
