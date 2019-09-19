package com.hroa.service;

import com.hroa.model.Salarymanage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

/**
 * 工资转账记录
 */
public interface SalaryService {

    //分页查询工资转账记录
    public List<Salarymanage> selectSalary(Integer page);

    //删除数据
    public int delete(Integer id);

    //查询工资转账的详细数据
    public Salarymanage selectInfo(Integer id);

    //查询总的页数
    public int selectAllpage();

    //查询财务的名字
    public String selectAdminName(Integer adminId);

    //数据更新
    public int updateInfo(Salarymanage salary);

    //根据时间检索
    public List<Salarymanage> selectSalaryDateInfo(String salaryDate);

    //excel导出数据
    public XSSFWorkbook exportExcelInfo(String salaryDate) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;

    //excel导出全部数据
    public XSSFWorkbook exportExcelAllInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;

    //excel导入数据
    public void importExcelInfo(InputStream in, MultipartFile file,String salaryDate,Integer adminId) throws Exception;
}
