package com.hroa.controller;

import com.hroa.model.Officemanage;
import com.hroa.service.OfficeService;
import com.hroa.util.SerialUtil;
import com.hroa.util.dateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 办公管理
 */
@Controller
@RequestMapping("/office")
public class OfficeController extends BaseController{

    @Resource
    private OfficeService officeService;

    //查询总的页数和第一页的数据
    @RequestMapping("/index")
    public String allPage(HttpServletRequest request,Model model){
        int page = officeService.selectAllpage();
        List<Officemanage> list = new ArrayList<Officemanage>();
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
                    list = officeService.selectOffice(start);
                }else{
                    list = officeService.selectOffice(temp);
                }
            }else{
                list = officeService.selectOffice(0);
            }
        }else{
            currentPage = "1";
            list = officeService.selectOffice(0);
        }
        model.addAttribute("allPage",page);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",currentPage);
        return "office/office_index";
    }

    //添加数据
    @RequestMapping("/issue")
    public String issue(HttpServletRequest request, Model model, Officemanage office){
        //获取操作的财务的id
        office.setAdminId(1);
        //将传入的string类型的参数转为date类型
        Date date = dateUtil.stringToDate(office.getsBuyTime());
        office.setBuyTime(date);
        //办公用品编号
        String serial = SerialUtil.officeSerial();
        office.setSerial(serial);
        officeService.addOffice(office);
        return "redirect:/office/index.html";
    }

    //分页查询数据
//    @RequestMapping("/info")
//    public @ResponseBody List<Officemanage> info(HttpServletRequest request){
//        //获取页数
//        String page = request.getParameter("page");
//        //若不传递参数，则放回第一页的数据
//        if(page!=null){
//            int start = Integer.parseInt(page);
//            List<Officemanage> list = officeService.selectOffice(start);
//            return list;
//        }else{
//            List<Officemanage> list = officeService.selectOffice(0);
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
            if(officeService.selectInfo(officeId)!=null){
                return officeService.delete(officeId);
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
            Officemanage office = officeService.selectInfo(officeId);
            //修改时间格式
            String buyTime = dateUtil.dateToString(office.getBuyTime());
            office.setsBuyTime(buyTime);
            model.addAttribute("office",office);
            return "office/input_edit";
        }else{
            return "redirect:/office/index.html";
        }
    }

    //更新的数据提交
    @RequestMapping("/updateInfo")
    public String updateInfo(HttpServletRequest request,Model mode,Officemanage office){
        //获取操作的财务的id
        office.setAdminId(2);
        //转时间格式
        Date buyTime = dateUtil.stringToDate(office.getsBuyTime());
        office.setBuyTime(buyTime);
        officeService.updateInfo(office);
        return "redirect:/office/index.html";
    }

    //查询详细信息
    @RequestMapping("/detail")
    public @ResponseBody Officemanage selectBaseInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        //查询参数是否为空
        if (id != null) {
            int officeId = Integer.parseInt(id);
            Officemanage office = officeService.selectInfo(officeId);
            //查询财务名字
            String adminName = officeService.selectAdminName(office.getAdminId());
            office.setAdminName(adminName);
            //修改时间格式
            String buyTime = dateUtil.dateToString(office.getBuyTime());
            office.setsBuyTime(buyTime);
            return office;
        } else {
            return null;
        }
    }

    //根据部门名称搜索数据
    @RequestMapping("/search")
    public @ResponseBody List<Officemanage> search(HttpServletRequest request, @RequestParam("content")String apartment){
        return officeService.selectApartmentInfo(apartment);
    }

}
