package com.hroa.service.impl;

import com.hroa.dao.IncomemanageDao;
import com.hroa.model.ExcelBean;
import com.hroa.model.Incomemanage;
import com.hroa.service.IncomeService;
import com.hroa.util.ExcelUtil;
import com.hroa.util.dateUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.*;

/**
 * 收入管理
 */
@Service("IncomeService")
public class IncomeServiceImpl implements IncomeService {

    @Resource
    private IncomemanageDao incomemanageDao;

    @Override
    public int addIncome(Incomemanage income) {
        return incomemanageDao.insertSelective(income);
    }

    @Override
    public List<Incomemanage> selectIncome(Integer page) {
        //页数小于1页，则返回第一页的数据
        if(page>0){
            int allPage;
            int count = incomemanageDao.selectCount(); //总条数
            if(count%20 == 0){
                allPage = count/20;
            }else{
                allPage = count/20+1;
            }
            //若访问的页数大于总页数，返回第一页的数据
            if(page<=allPage){
                int start = page*20; //一页20条数据
                List<Incomemanage> list = incomemanageDao.selectInfoByPage(start);
                //转换时间格式
                for(int i=0;i<list.size();i++){
                    Date date = list.get(i).getIncomeDate();
                    String sDate = dateUtil.dateToString(date);
                    list.get(i).setsIncomeDate(sDate);
                }
                return list;
            }else{
                List<Incomemanage> list = incomemanageDao.selectInfoByPage(0);
                //转换时间格式
                for(int i=0;i<list.size();i++){
                    Date date = list.get(i).getIncomeDate();
                    String sDate = dateUtil.dateToString(date);
                    list.get(i).setsIncomeDate(sDate);
                }
                return list;
            }
        }else{
            List<Incomemanage> list = incomemanageDao.selectInfoByPage(0);
            //转换时间格式
            for(int i=0;i<list.size();i++){
                Date date = list.get(i).getIncomeDate();
                String sDate = dateUtil.dateToString(date);
                list.get(i).setsIncomeDate(sDate);
            }
            return list;
        }
    }

    @Override
    public int delete(Integer id) {
        return incomemanageDao.deleteByPrimaryKey(id);
    }

    @Override
    public Incomemanage selectInfo(Integer id) {
        return incomemanageDao.selectByPrimaryKey(id);
    }

    @Override
    public int selectAllpage() {
        int allPage;
        int count = incomemanageDao.selectCount(); //总条数
        if(count%20 == 0){
            allPage = count/20;
        }else{
            allPage = count/20+1;
        }
        return allPage;
    }

    @Override
    public List<Incomemanage> selectDateInfo(String content) {
        List<Incomemanage> list = incomemanageDao.selectInfoByDate(content);
        for(int i=0;i<list.size();i++){
            Date date = list.get(i).getIncomeDate();
            String sDate = dateUtil.dateToString(date);
            list.get(i).setsIncomeDate(sDate);
        }
        return list;
    }

    @Override
    public String selectAdminName(Integer adminId) {
        return incomemanageDao.selectAdminNameById(adminId);
    }

    @Override
    public int updateInfo(Incomemanage income) {
        return incomemanageDao.updateByPrimaryKeySelective(income);
    }

    @Override
    public XSSFWorkbook exportExcelInfo(String content) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        List<Incomemanage> list = incomemanageDao.selectApartInfo(content);
        for(int i=0;i<list.size();i++){
            Date date = list.get(i).getIncomeDate();
            String sDate = dateUtil.dateToString(date);
            list.get(i).setsIncomeDate(sDate);
            //查询财务名字
            int adminId = list.get(i).getAdminId();
            String adminName = incomemanageDao.selectAdminNameById(adminId);
            list.get(i).setAdminName(adminName);
        }
        List<ExcelBean> excel=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook=null;
        excel.add(new ExcelBean("编号","serial",0));
        excel.add(new ExcelBean("部门","department",0));
        excel.add(new ExcelBean("联系人","linkMan",0));
        excel.add(new ExcelBean("收入金额","money",0));
        excel.add(new ExcelBean("收入时间","incomeDate",0));
        excel.add(new ExcelBean("说明","state",0));
        excel.add(new ExcelBean("操作人","adminName",0));
        map.put(0, excel);
        String sheetName = content + "月份收入";
        xssfWorkbook = ExcelUtil.createExcelFile(Incomemanage.class, list, map, sheetName);
        return xssfWorkbook;
    }

    @Override
    public XSSFWorkbook exportExcelAllInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        List<Incomemanage> list = incomemanageDao.selecAllInfo();
        for(int i=0;i<list.size();i++){
            Date date = list.get(i).getIncomeDate();
            String sDate = dateUtil.dateToString(date);
            list.get(i).setsIncomeDate(sDate);
            //查询财务名字
            int adminId = list.get(i).getAdminId();
            String adminName = incomemanageDao.selectAdminNameById(adminId);
            list.get(i).setAdminName(adminName);
        }
        List<ExcelBean> excel=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook=null;
        excel.add(new ExcelBean("编号","serial",0));
        excel.add(new ExcelBean("部门","department",0));
        excel.add(new ExcelBean("联系人","linkMan",0));
        excel.add(new ExcelBean("收入金额","money",0));
        excel.add(new ExcelBean("收入时间","incomeDate",0));
        excel.add(new ExcelBean("说明","state",0));
        excel.add(new ExcelBean("操作人","adminName",0));
        map.put(0, excel);
        String sheetName = "收入管理";
        xssfWorkbook = ExcelUtil.createExcelFile(Incomemanage.class, list, map, sheetName);
        return xssfWorkbook;
    }
}
