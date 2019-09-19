package com.hroa.service.impl;

import com.hroa.dao.OfficemanageDao;
import com.hroa.model.Officemanage;
import com.hroa.service.OfficeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 办公用品管理
 */
@Service("officeService")
public class OfficeServiceImpl implements OfficeService{

    @Resource
    private OfficemanageDao officemanageDao;

    @Override
    public int addOffice(Officemanage office) {
        return officemanageDao.insert(office);
    }

    @Override
    public int delete(Integer id) {
        return officemanageDao.deleteByPrimaryKey(id);
    }

    @Override
    public Officemanage selectInfo(Integer id) {
        return officemanageDao.selectByPrimaryKey(id);
    }

    @Override
    public int selectAllpage() {
        int allPage;
        int count = officemanageDao.selectCount(); //总条数
        if(count%20 == 0){
            allPage = count/20;
        }else{
            allPage = count/20+1;
        }
        return allPage;

    }

    @Override
    public List<Officemanage> selectApartmentInfo(String apartment) {
        return officemanageDao.selectInfoByApartment(apartment);
    }

    @Override
    public String selectAdminName(Integer adminId) {
        return officemanageDao.selectAdminNameById(adminId);
    }

    @Override
    public int updateInfo(Officemanage office) {
        return officemanageDao.updateByPrimaryKeySelective(office);
    }

    @Override
    public List<Officemanage> selectOffice(Integer page) {
        //页数小于1页，则放回第一页的数据
        if(page>0){
            int allPage;
            int count = officemanageDao.selectCount(); //总条数
            if(count%20 == 0){
                allPage = count/20;
            }else{
                allPage = count/20+1;
            }

            //若访问的页数大于总页数，返回第一页的数据
            if(page<=allPage){
                int start = page*20; //一页20条数据
                return officemanageDao.selectInfoByPage(start);
            }else{
                return officemanageDao.selectInfoByPage(0);
            }
        }else{
            return officemanageDao.selectInfoByPage(0);
        }
    }
}
