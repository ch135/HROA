package com.hroa.service.impl;

import com.hroa.dao.SalarymanageDao;
import com.hroa.model.ExcelBean;
import com.hroa.model.Salarymanage;
import com.hroa.service.SalaryService;
import com.hroa.util.ExcelUtil;
import com.hroa.util.SerialUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * 工资转账
 */
@Service("salaryService")
public class salaryServiceImpl implements SalaryService {
    @Resource
    private SalarymanageDao salarymanageDao;

    @Override
    public List<Salarymanage> selectSalary(Integer page) {
        //页数小于1页，则放回第一页的数据
        if(page>0){
            int allPage;
            int count = salarymanageDao.selectCount(); //总条数
            if(count%20 == 0){
                allPage = count/20;
            }else{
                allPage = count/20+1;
            }

            //若访问的页数大于总页数，返回第一页的数据
            if(page<=allPage){
                int start = page*20; //一页20条数据
                return salarymanageDao.selectInfoByPage(start);
            }else{
                return salarymanageDao.selectInfoByPage(0);
            }
        }else{
            return salarymanageDao.selectInfoByPage(0);
        }
    }

    @Override
    public int delete(Integer id) {
        return salarymanageDao.deleteByPrimaryKey(id);
    }

    @Override
    public Salarymanage selectInfo(Integer id) {
        return salarymanageDao.selectByPrimaryKey(id);
    }

    @Override
    public int selectAllpage() {
        int allPage;
        int count = salarymanageDao.selectCount(); //总条数
        if(count%20 == 0){
            allPage = count/20;
        }else{
            allPage = count/20+1;
        }
        return allPage;
    }

    @Override
    public String selectAdminName(Integer adminId) {
        return salarymanageDao.selectAdminNameById(adminId);
    }

    @Override
    public int updateInfo(Salarymanage salary) {
        return salarymanageDao.updateByPrimaryKeySelective(salary);
    }

    @Override
    public List<Salarymanage> selectSalaryDateInfo(String salaryDate) {
        return salarymanageDao.selectInfoBySalaryDate(salaryDate);
    }

    @Override
    public XSSFWorkbook exportExcelInfo(String salaryDate) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        List<Salarymanage> list = salarymanageDao.selectApartInfo(salaryDate);
        for(int i=0;i<list.size();i++){
            //查询财务名字
            int adminId = list.get(i).getAdminId();
            String adminName = salarymanageDao.selectAdminNameById(adminId);
            list.get(i).setAdminName(adminName);
            list.get(i).setId(i+1);
        }
        List<ExcelBean> excel=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook=null;
        excel.add(new ExcelBean("序号","id",0));
        excel.add(new ExcelBean("厂名","company",0));
        excel.add(new ExcelBean("工号","number",0));
        excel.add(new ExcelBean("姓名","name",0));
        excel.add(new ExcelBean("性别","sex",0));
        excel.add(new ExcelBean("开户名","cardName",0));
        excel.add(new ExcelBean("银行卡号","bankCard",0));
        excel.add(new ExcelBean("开户行","bank",0));
        excel.add(new ExcelBean("金额","money",0));
        excel.add(new ExcelBean("备注","remark",0));
        map.put(0, excel);
        String sheetName = salaryDate + "月份收入";
        xssfWorkbook = ExcelUtil.createExcelFile(Salarymanage.class, list, map, sheetName);
        return xssfWorkbook;
    }

    @Override
    public XSSFWorkbook exportExcelAllInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        List<Salarymanage> list = salarymanageDao.selecAllInfo();
        for(int i=0;i<list.size();i++){
            //查询财务名字
            int adminId = list.get(i).getAdminId();
            String adminName = salarymanageDao.selectAdminNameById(adminId);
            list.get(i).setAdminName(adminName);
        }
        List<ExcelBean> excel=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook=null;
        excel.add(new ExcelBean("序号","id",0));
        excel.add(new ExcelBean("厂名","company",1));
        excel.add(new ExcelBean("工号","number",0));
        excel.add(new ExcelBean("姓名","name",0));
        excel.add(new ExcelBean("性别","sex",0));
        excel.add(new ExcelBean("开户名","cardName",0));
        excel.add(new ExcelBean("银行卡号","bankCard",1));
        excel.add(new ExcelBean("开户行","bank",0));
        excel.add(new ExcelBean("金额","money",0));
        excel.add(new ExcelBean("备注","remark",0));
        map.put(0, excel);
        String sheetName = "工资管理";
        xssfWorkbook = ExcelUtil.createExcelFile(Salarymanage.class, list, map, sheetName);
        return xssfWorkbook;
    }

    @Override
    public void importExcelInfo(InputStream in, MultipartFile file, String salaryDate,Integer adminId) throws Exception{
        List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
        List<Salarymanage> salaryList = new ArrayList<Salarymanage>();
        //遍历listob数据，把数据放到List中
        for (int i = 0; i < listob.size(); i++) {
            List<Object> ob = listob.get(i);
            Salarymanage salarymanage = new Salarymanage();
            //设置编号
            salarymanage.setSerial(SerialUtil.salarySerial());
            //设置财务id
            salarymanage.setAdminId(adminId);
            salarymanage.setCompany(String.valueOf(ob.get(1)));
            salarymanage.setNumber(String.valueOf(ob.get(2)));
            salarymanage.setName(String.valueOf(ob.get(3)));
            salarymanage.setSex(String.valueOf(ob.get(4)));
            salarymanage.setCardName(String.valueOf(ob.get(5)));
            salarymanage.setBankCard(String.valueOf(ob.get(6)));
            salarymanage.setBank(String.valueOf(ob.get(7)));
            //object类型转Double类型
            salarymanage.setMoney(Double.parseDouble(ob.get(8).toString()));
            salarymanage.setRemark(String.valueOf(ob.get(9)));
            salarymanage.setSalaryDate(salaryDate);
            salaryList.add(salarymanage);
        }
        //批量插入
        salarymanageDao.insertInfoBatch(salaryList);
    }
}
