package com.hroa.controller;

import com.hroa.model.Incomemanage;
import com.hroa.service.IncomeService;
import com.hroa.util.SerialUtil;
import com.hroa.util.dateUtil;
import org.apache.http.protocol.HTTP;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.*;

/**
 * 收入管理
 */
@Controller
@RequestMapping("/income")
public class IncomeController extends TestController{

    @Resource
    private IncomeService incomeService;

    //查询总的页数和第一页的数据
    @RequestMapping("/index")
    public String allPage(HttpServletRequest request,Model model){
        int page = incomeService.selectAllpage();
        List<Incomemanage> list = new ArrayList<Incomemanage>();
        //获取当前页数
        String currentPage = request.getParameter("page");
        //若不传递参数，则放回第一页的数据,查第一页其实开始是0
        if(currentPage!=null){
            int start = Integer.parseInt(currentPage)-1;
            int temp = page-1;
            //判断页数大于0，否则返回第一页
            if(start >0 ){
                //删除最后一页最后一条数据时能够返回到前一页
                if(start<=temp){
                    list = incomeService.selectIncome(start);
                }else{
                    list = incomeService.selectIncome(temp);
                }
            }else{
                list = incomeService.selectIncome(0);
            }
        }else{
            currentPage = "1";
            list = incomeService.selectIncome(0);
        }
        model.addAttribute("allPage",page);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",currentPage);
        return "income/income_index";
    }

    @RequestMapping("/issue")
    public String issue(HttpServletRequest request, Model model, Incomemanage income){
        //获取操作的财务的id
        income.setAdminId(1);
        //将传入的string类型的参数转为date类型
        Date date = dateUtil.stringToDate(income.getsIncomeDate());
        income.setIncomeDate(date);
        //办公用品编号
        String serial = SerialUtil.incomeSerial();
        income.setSerial(serial);
        incomeService.addIncome(income);
        return "redirect:/income/index.html";
    }

    //分页查询数据
//    @RequestMapping("/info")
//    public @ResponseBody List<Incomemanage> info(HttpServletRequest request){
//        //获取页数
//        String page = request.getParameter("page");
//        //若不传递参数，则放回第一页的数据
//        if(page!=null){
//            int start = Integer.parseInt(page);
//            List<Incomemanage> list = incomeService.selectIncome(start);
//            return list;
//        }else{
//            List<Incomemanage> list = incomeService.selectIncome(0);
//            return list;
//        }
//    }

    //删除数据
    @RequestMapping("/delete")
    public @ResponseBody int delete(HttpServletRequest request){
        //获取id,删除成功放回1,失败放回0
        String id = request.getParameter("id");
        if(id!=null){
            int officeId = Integer.parseInt(id);
            //查询数据是否存在
            if(incomeService.selectInfo(officeId)!=null){
                return incomeService.delete(officeId);
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    //更新数据
    @RequestMapping("/update")
    public String updateBaseInfo(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        //查询参数是否为空
        if(id!=null) {
            int officeId = Integer.parseInt(id);
            Incomemanage income = incomeService.selectInfo(officeId);
            //修改时间格式
            String incomeDate = dateUtil.dateToString(income.getIncomeDate());
            income.setsIncomeDate(incomeDate);
            model.addAttribute("income",income);
            return "income/input_edit";
        }else{
            return "redirect:/income/index.html";
        }
    }

    //更新的数据提交
    @RequestMapping("/updateInfo")
    public String updateInfo(HttpServletRequest request,Model mode,Incomemanage income){
        //获取操作的财务的id
        income.setAdminId(2);
        //转时间格式
        Date incomeDate = dateUtil.stringToDate(income.getsIncomeDate());
        income.setIncomeDate(incomeDate);
        incomeService.updateInfo(income);
        return "redirect:/income/index.html";
    }

    //查询详细信息
    @RequestMapping("/detail")
    public @ResponseBody Incomemanage selectBaseInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        //查询参数是否为空
        if (id != null) {
            int incomeId = Integer.parseInt(id);
            Incomemanage income = incomeService.selectInfo(incomeId);
            //查询财务名字
            String adminName = incomeService.selectAdminName(income.getAdminId());
            income.setAdminName(adminName);
            //修改时间格式
            String incomeDate = dateUtil.dateToString(income.getIncomeDate());
            income.setsIncomeDate(incomeDate);
            return income;
        } else {
            return null;
        }
    }

    //根据时间搜索数据
    @RequestMapping("/search")
    public @ResponseBody List<Incomemanage> search(HttpServletRequest request, @RequestParam("content")String content){
        return incomeService.selectDateInfo(content);
    }

    //导出数据到excel
    @RequestMapping("/export")
    public @ResponseBody void export(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException {
        String content = request.getParameter("content");
        if(content!=""){
            response.reset(); //清除buffer缓存
            Map<String,Object> map=new HashMap<String,Object>();
            // 指定下载的文件名
            response.setHeader("Content-Disposition", "attachment;filename="+content+".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            XSSFWorkbook workbook=null;
            //导出Excel对象
            workbook = incomeService.exportExcelInfo(content);
            OutputStream output;
            try {
                output = response.getOutputStream();

                BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
                bufferedOutPut.flush();
                workbook.write(bufferedOutPut);
                bufferedOutPut.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //导出全部数据到excel
    @RequestMapping("/exportAll")
    public @ResponseBody void exportAll(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException {
        response.reset(); //清除buffer缓存
        Map<String,Object> map=new HashMap<String,Object>();
        // 指定下载的文件名
        response.setHeader("Content-Disposition", "attachment;filename=收入管理.xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook workbook=null;
        //导出Excel对象
        workbook = incomeService.exportExcelAllInfo();
        OutputStream output;
        try {
            output = response.getOutputStream();

            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
