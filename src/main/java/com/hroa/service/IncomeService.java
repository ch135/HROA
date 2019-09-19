package com.hroa.service;

import com.hroa.model.Incomemanage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

/**
 * 收入管理
 */
public interface IncomeService {

    //添加收入数据
    public int addIncome(Incomemanage income);

    //分页查询收入数据
    public List<Incomemanage> selectIncome(Integer page);

    //删除数据
    public int delete(Integer id);

    //查询收入的详细数据
    public Incomemanage selectInfo(Integer id);

    //查询总的页数
    public int selectAllpage();

    //根据时间检索数据
    public List<Incomemanage> selectDateInfo(String content);

    //查询财务的名字
    public String selectAdminName(Integer adminId);

    //数据更新
    public int updateInfo(Incomemanage income);

    //excel导出数据
    public XSSFWorkbook exportExcelInfo(String content) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;

    //excel导出全部数据
    public XSSFWorkbook exportExcelAllInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;

}
