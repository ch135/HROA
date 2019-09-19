package com.hroa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hroa.model.ShCompany;
import com.hroa.service.ShCompanyService;
import com.hroa.util.Page;


/**
 * 企业录入
 * @author qiuwenqiol
 */
@Controller
@RequestMapping("ShCompany")
public class ShCompanyController extends BaseController {

	@Resource
	private ShCompanyService shCompanyService;

	@RequestMapping("addShCompanyUI")
	public String addUI() {
		return "/company/company_register";
	}

	@RequestMapping("addShCompany")
	public String addShCompany(HttpServletRequest  request, ShCompany shCompany) throws IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		shCompany.setRegisterdate(date);
		shCompanyService.addShCompany(shCompany);
		return listCompanyUI(request, new Page<ShCompany>(), new ShCompany());
	}

	@RequestMapping("deleteShCompany")
	public String deleteShCompany(HttpServletRequest request, Page<ShCompany> page, ShCompany shCompany) {
		System.out.println(shCompany.getId());
		shCompanyService.deleteShCompany(shCompany.getId());
		return listCompanyUI(request, page, shCompany);
	}

	@RequestMapping("editShCompanyUI")
	public String editShCompanyUI(HttpServletRequest request, Integer companyId) {
		ShCompany company = shCompanyService.findByCompanyId(companyId);
		request.setAttribute("company", company);
		return "/company/company_edit";
	}
	
	@RequestMapping("showShCompanyUI")
	public String showShCompanyUI(HttpServletRequest request, Integer companyId) {
		ShCompany company = shCompanyService.findByCompanyId(companyId);
		request.setAttribute("company", company);
		return "/company/company_show";
	}

	@RequestMapping("saveShCompany")
	public String editShCompany(HttpServletRequest request, ShCompany shCompany) {
		shCompanyService.updateShCompany(shCompany);
		return listCompanyUI(request, new Page<ShCompany>(), new ShCompany());
	}

	@RequestMapping("listCompanyUI")
	public String listCompanyUI(HttpServletRequest request, Page<ShCompany> page, ShCompany shCompany) {
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchValue", searchValue);
		if (searchType != null) {
			if ("name".equals(searchType)) {
				shCompany.setName(searchValue);
			} else {
				shCompany.setLinkMan(searchValue);
			}
		}
		page.setParamEntity(shCompany);
		Page<ShCompany> newpage = shCompanyService.findByPage(page);
		List<ShCompany> list = page.getList();
		ShCompany company = list.get(0);
		newpage.setPage(page.getPage());
		request.setAttribute("page", newpage);
		return "/company/company_listUI";
	}

}
