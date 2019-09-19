package com.hroa.controller;

import com.hroa.model.Salarymanage;
import com.hroa.service.SalaryService;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工资管理
 */
@Controller
@RequestMapping("/salary")
public class SalaryController extends BaseController{

    @Resource
    private SalaryService salaryService;

    //查询总的页数和第一页的数据
    @RequestMapping("/index")
    public String allPage(HttpServletRequest request,Model model){
        int page = salaryService.selectAllpage();
        List<Salarymanage> list = new ArrayList<Salarymanage>();
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
                    list = salaryService.selectSalary(start);
                }else{
                    list = salaryService.selectSalary(temp);
                }
            }else{
                list = salaryService.selectSalary(0);
            }
        }else{
            currentPage = "1";
            list = salaryService.selectSalary(0);
        }
        model.addAttribute("allPage",page);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",currentPage);
        return "salary/transfer";
    }

    //数据导入


    //分页查询数据
//    @RequestMapping("/info")
//    public @ResponseBody List<Salarymanage> info(HttpServletRequest request){
//        //获取页数
//        String page = request.getParameter("page");
//        //若不传递参数，则放回第一页的数据
//        if(page!=null){
//            int start = Integer.parseInt(page);
//            List<Salarymanage> list = salaryService.selectSalary(start);
//            return list;
//        }else{
//            List<Salarymanage> list = salaryService.selectSalary(0);
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
            if(salaryService.selectInfo(officeId)!=null){
                return salaryService.delete(officeId);
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
            int salaryId = Integer.parseInt(id);
            Salarymanage salary = salaryService.selectInfo(salaryId);
            model.addAttribute("salary",salary);
            return "salary/transfer_edit";
        }else{
            return "redirect:/salary/index.html";
        }
    }

    //更新的数据提交
    @RequestMapping("/updateInfo")
    public String updateInfo(HttpServletRequest request,Model mode,Salarymanage salary){
        //获取操作的财务的id
        salary.setAdminId(2);
        salaryService.updateInfo(salary);
        return "redirect:/salary/index.html";
    }

    //查询详细信息
    @RequestMapping("/detail")
    public @ResponseBody Salarymanage selectBaseInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        //查询参数是否为空
        if (id != null) {
            int salaryId = Integer.parseInt(id);
            Salarymanage salary = salaryService.selectInfo(salaryId);
            //查询财务名字
            String adminName = salaryService.selectAdminName(salary.getAdminId());
            salary.setAdminName(adminName);
            return salary;
        } else {
            return null;
        }
    }

    //根据时间检索数据
    @RequestMapping("/search")
    public @ResponseBody List<Salarymanage> search(HttpServletRequest request, @RequestParam("content")String salaryDate){
        return salaryService.selectSalaryDateInfo(salaryDate);
    }

    //导出数据到excel
    @RequestMapping("/export")
    public @ResponseBody void export(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException {
        String salaryDate = request.getParameter("salaryDate");
        if(salaryDate!=""){
            response.reset(); //清除buffer缓存
            Map<String,Object> map=new HashMap<String,Object>();
            // 指定下载的文件名
            response.setHeader("Content-Disposition", "attachment;filename="+salaryDate+".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            XSSFWorkbook workbook=null;
            //导出Excel对象
            workbook = salaryService.exportExcelInfo(salaryDate);
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
        workbook = salaryService.exportExcelAllInfo();
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

    //excel表数据导入
    @RequestMapping("/import")
    public String impotr(HttpServletRequest request,Model model) throws Exception {
        int adminId = 1;
        //获取上传的文件
        MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        MultipartFile file = multipart.getFile("upfile");
        String month = request.getParameter("month");
        InputStream in = file.getInputStream();
        //数据导入
        salaryService.importExcelInfo(in,file,month,adminId);
        in.close();
        return "redirect:/salary/index.html";
    }
}
