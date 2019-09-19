package com.hroa.service;

import com.hroa.model.Salarydetial;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * 工资详细
 */
public interface SalaryDeatilService {

    //分页查询工资转账记录
    public List<Salarydetial> selectSalaryDetail(Integer page);

    //删除数据
    public int delete(Integer id);

    //查询工资转账的详细数据
    public Salarydetial selectInfo(Integer id);

    //查询总的页数
    public int selectAllpage();

    //查询财务的名字
    public String selectAdminName(Integer adminId);

    //数据更新
    public int updateInfo(Salarydetial salary);

    //根据时间检索
    public List<Salarydetial> selectSalaryNumberInfo(String number);

    //excel导入数据
    public void importExcelInfo(InputStream in, MultipartFile file, String salaryDate, Integer adminId) throws Exception;

}
