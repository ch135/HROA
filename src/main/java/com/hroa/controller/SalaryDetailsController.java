package com.hroa.controller;

import com.hroa.model.Salarydetial;
import com.hroa.service.SalaryDeatilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 工资详情
 */
@Controller
@RequestMapping("/detail")
public class SalaryDetailsController extends BaseController {

    @Resource
    private SalaryDeatilService salaryDeatilService;

    //查询总的页数和第一页的数据
    @RequestMapping("/index")
    public String allPage(HttpServletRequest request,Model model){
        int page = salaryDeatilService.selectAllpage();
        List<Salarydetial> list = new ArrayList<Salarydetial>();
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
                    list = salaryDeatilService.selectSalaryDetail(start);
                }else{
                    list = salaryDeatilService.selectSalaryDetail(temp);
                }
            }else{
                list = salaryDeatilService.selectSalaryDetail(0);
            }
        }else{
            currentPage = "1";
            list = salaryDeatilService.selectSalaryDetail(0);
        }
        model.addAttribute("allPage",page);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",currentPage);
        return "salary/detail";
    }

    //数据导入


    //分页查询数据
//    @RequestMapping("/info")
//    public @ResponseBody List<Salarydetial> info(HttpServletRequest request){
//        //获取页数
//        String page = request.getParameter("page");
//        //若不传递参数，则放回第一页的数据
//        if(page!=null){
//            int start = Integer.parseInt(page);
//            List<Salarydetial> list = salaryDeatilService.selectSalaryDetail(start);
//            return list;
//        }else{
//            List<Salarydetial> list = salaryDeatilService.selectSalaryDetail(0);
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
            if(salaryDeatilService.selectInfo(officeId)!=null){
                return salaryDeatilService.delete(officeId);
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
            Salarydetial detail = salaryDeatilService.selectInfo(salaryId);
            model.addAttribute("detail",detail);
            return "salary/detail_edit";
        }else{
            return "redirect:/detail/index.html";
        }
    }

    //更新的数据提交
    @RequestMapping("/updateInfo")
    public String updateInfo(HttpServletRequest request,Model mode,Salarydetial salaryDetail){
        //获取操作的财务的id
        salaryDetail.setAdminId(2);
        salaryDeatilService.updateInfo(salaryDetail);
        return "redirect:/detail/index.html";
    }

    //查询详细信息
    @RequestMapping("/detail")
    public @ResponseBody Salarydetial selectBaseInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        //查询参数是否为空
        if (id != null) {
            int salaryId = Integer.parseInt(id);
            Salarydetial salaryDetail = salaryDeatilService.selectInfo(salaryId);
            //查询财务名字
            String adminName = salaryDeatilService.selectAdminName(salaryDetail.getAdminId());
            salaryDetail.setAdminName(adminName);
            return salaryDetail;
        } else {
            return null;
        }
    }

    //根据时间检索数据
    @RequestMapping("/search")
    public @ResponseBody List<Salarydetial> search(HttpServletRequest request, @RequestParam("number")String number){
        return salaryDeatilService.selectSalaryNumberInfo(number);
    }

    //excel表数据导入
    @RequestMapping("/import")
    public String impotr(HttpServletRequest request, Model model) throws Exception {
        int adminId = 1;
        //获取上传的文件
        MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        MultipartFile file = multipart.getFile("upfile");
        String month = request.getParameter("month");
        InputStream in = file.getInputStream();
        //数据导入
        salaryDeatilService.importExcelInfo(in,file,month,adminId);
        in.close();
        return "redirect:/detail/index.html";
    }
}
