package com.hroa.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hroa.model.EnterCom;
import com.hroa.model.Message;
import com.hroa.model.ShUser;
import com.hroa.service.EnterComService;
import com.hroa.service.ShUserService;
import com.hroa.util.AddressUtil;
import com.hroa.util.Page;
import com.hroa.util.ServerTool;

@Controller
@RequestMapping("ShUser")
public class ShUserController {

	@Resource
	private ShUserService ShUserService;
	@Resource
	private EnterComService enterComService;

	@RequestMapping("addShUserUI")
	public String addUI(HttpServletRequest request, EnterCom enterCom) {
		String machine_num = request.getParameter("machine_num");
		request.setAttribute("machine_num", machine_num);
		return "/user/user_register";
	}
	
	@ResponseBody
	@RequestMapping("addShUser")
	public String addShUser(HttpServletRequest request, ShUser shUser, EnterCom enterCom) {
		ShUser user = ShUserService.findByTelephone(shUser.getTelephone());
		if (user == null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			shUser.setRegisterdate(format.format(new Date()));
			ShUserService.addShUser(shUser);
			user = ShUserService.findByTelephone(shUser.getTelephone());
		}
		enterCom.setIsWork(true);
		enterCom.setIsDelete(false);
		enterCom.setIsRead(false);
		enterCom.setDate(new Date());
		enterCom.setUserid(user.getId());
		enterComService.addEnterCom(enterCom);
		return "{result:'success'}";
	}

	@ResponseBody
	@RequestMapping("getShUser")
	public Object getShUser(HttpServletRequest request, String telephone) {
		ShUser user = ShUserService.findByTelephone(telephone);
		if (user == null)
			user = new ShUser();
		return user;
	}

	@ResponseBody
	@RequestMapping("readIdCard")
	public Object readIdCard(HttpServletRequest request) {
		Message message = null;
		String numStr = request.getParameter("num");
		int num = Integer.parseInt(numStr);
		message = ServerTool.getMessage(num);
		ShUser shUser = new ShUser();
		if (message != null) {
			shUser.setSex(message.getSex());
			shUser.setIdcard(message.getCode());
			shUser.setRealname(message.getName());
			shUser.setRegion(message.getAddress());
			String code = message.getCode();
			if(code!=null&&code.length()>10){
				String string = code.substring(0, 6);
				String[] address = AddressUtil.getProvince(string);
				shUser.setProvince(address[0]);
				shUser.setCity(address[1]);
				shUser.setRegion(address[2]);
			}
		}
		return shUser;
	}

	@RequestMapping("applyShUser")
	public String applyShUser(HttpServletRequest request, ShUser ShUser) throws IOException {
		ShUserService.addShUser(ShUser);
		return listUserUI(request, new Page<ShUser>(), new ShUser());
	}

	@RequestMapping("editShUserUI")
	public String editShUserUI(HttpServletRequest request, Integer userId) {
		ShUser User = ShUserService.findByUserId(userId);
		request.setAttribute("user", User);
		return "/user/user_edit";
	}

	@RequestMapping("showShUserUI")
	public String showShUserUI(HttpServletRequest request, Integer userId) {
		ShUser User = ShUserService.findByUserId(userId);
		request.setAttribute("user", User);
		return "/user/user_show";
	}

	@RequestMapping("saveShUser")
	public String editShUser(HttpServletRequest request, ShUser ShUser) {
		ShUserService.updateShUser(ShUser);
		return listUserUI(request, new Page<ShUser>(), new ShUser());
	}

	@RequestMapping("listUserUI")
	public String listUserUI(HttpServletRequest request, Page<ShUser> page, ShUser ShUser) {
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		if (searchType != null) {
			if ("telephone".equals(searchType)) {
				ShUser.setTelephone(searchValue);
			}
			if ("realname".equals(searchType)) {
				ShUser.setRealname(searchValue);
			}
			if ("idcard".equals(searchType)) {
				ShUser.setIdcard(searchValue);
			}
		}
		page.setParamEntity(ShUser);
		Page<ShUser> newpage = ShUserService.findByPage(page);
		newpage.setPage(page.getPage());
		request.setAttribute("page", newpage);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchValue", searchValue);
		return "/user/user_listUI";
	}
	
	/**
	 * 获取读卡器的编号
	 * @param request
	 * @param telephone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getCode")
	public Object getCode(HttpServletRequest request) {
		List<Integer> list = ServerTool.getNum();
		return list;
	}

	
}
