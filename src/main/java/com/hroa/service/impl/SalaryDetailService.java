package com.hroa.service.impl;

import com.hroa.dao.SalarydetialDao;
import com.hroa.model.Salarydetial;
import com.hroa.service.SalaryDeatilService;
import com.hroa.util.ExcelUtil;
import com.hroa.util.SerialUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 工资详情
 */
@Service("salaryDetail")
public class SalaryDetailService implements SalaryDeatilService{

    @Resource
    private SalarydetialDao salarydetialDao;

    @Override
    public List<Salarydetial> selectSalaryDetail(Integer page) {
        //页数小于1页，则放回第一页的数据
        if(page>0){
            int allPage;
            int count = salarydetialDao.selectCount(); //总条数
            if(count%20 == 0){
                allPage = count/20;
            }else{
                allPage = count/20+1;
            }

            //若访问的页数大于总页数，返回第一页的数据
            if(page<=allPage){
                int start = page*20; //一页20条数据
                return salarydetialDao.selectInfoByPage(start);
            }else{
                return salarydetialDao.selectInfoByPage(0);
            }
        }else{
            return salarydetialDao.selectInfoByPage(0);
        }
    }

    @Override
    public int delete(Integer id) {
        return salarydetialDao.deleteByPrimaryKey(id);
    }

    @Override
    public Salarydetial selectInfo(Integer id) {
        return salarydetialDao.selectByPrimaryKey(id);
    }

    @Override
    public int selectAllpage() {
        int allPage;
        int count = salarydetialDao.selectCount(); //总条数
        if(count%20 == 0){
            allPage = count/20;
        }else{
            allPage = count/20+1;
        }
        return allPage;
    }

    @Override
    public String selectAdminName(Integer adminId) {
        return salarydetialDao.selectAdminNameById(adminId);
    }

    @Override
    public int updateInfo(Salarydetial salary) {
        return salarydetialDao.updateByPrimaryKeySelective(salary);
    }

    @Override
    public List<Salarydetial> selectSalaryNumberInfo(String number) {
        return salarydetialDao.selectInfoByNumber(number);
    }

    @Override
    public void importExcelInfo(InputStream in, MultipartFile file, String salaryDate, Integer adminId) throws Exception {
        List<List<Object>> listob = ExcelUtil.getSalarydetailByExcel(in,file.getOriginalFilename());
        List<Salarydetial> salaryList = new ArrayList<Salarydetial>();
        //遍历listob数据，把数据放到List中
        for (int i = 0; i < listob.size(); i++) {
            List<Object> ob = listob.get(i);
            Salarydetial salarydetail = new Salarydetial();
            salarydetail.setAdminId(adminId); //设置财务id
            salarydetail.setSerial(SerialUtil.salaryDetailSerial()); //编号
            salarydetail.setCompany(String.valueOf(ob.get(0)));  //厂名
            salarydetail.setNumber(String.valueOf(ob.get(2))); //工号
            salarydetail.setTelephone(String.valueOf(ob.get(3))); //手机号
            salarydetail.setName(String.valueOf(ob.get(4)));  //姓名
            salarydetail.setWorktime(String.valueOf(ob.get(5))); //总工时
            salarydetail.setPrice(String.valueOf(ob.get(6))); //工价
            salarydetail.setDeserved(String.valueOf(ob.get(7))); //应得工资
            salarydetail.setMeals(String.valueOf(ob.get(8))); //伙食补
            salarydetail.setDinner(String.valueOf(ob.get(9))); //夜餐补
            salarydetail.setOtherprofit(String.valueOf(ob.get(10))); //其他补贴
            salarydetail.setSalary(String.valueOf(ob.get(11))); //总工资
            salarydetail.setTax(String.valueOf(ob.get(12))); //所得税
            salarydetail.setFine(String.valueOf(ob.get(13))); //旷工罚款
            salarydetail.setSign(String.valueOf(ob.get(14))); //签卡
            salarydetail.setSdcost(String.valueOf(ob.get(15))); //水电
            salarydetail.setNontime(String.valueOf(ob.get(16))); //迟到早退
            salarydetail.setOtherfine(String.valueOf(ob.get(17))); //其他扣款
            salarydetail.setBeneficent(String.valueOf(ob.get(18))); //爱心基金
            salarydetail.setOwnleave(String.valueOf(ob.get(19))); //自离扣款
            salarydetail.setInsurance(String.valueOf(ob.get(20))); //保险
            salarydetail.setBorrow(String.valueOf(ob.get(21))); //借支
            salarydetail.setBoardcost(String.valueOf(ob.get(22))); //伙食扣
            salarydetail.setAllcost(String.valueOf(ob.get(23))); //总扣款
            salarydetail.setRealwages(String.valueOf(ob.get(24))); //实发工资
            salarydetail.setSalaryDate(salaryDate);
            salaryList.add(salarydetail);
        }
        //批量插入
        salarydetialDao.insertInfoBatch(salaryList);
    }
}
