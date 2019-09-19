package com.hroa.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hroa.util.DateFormat;

public class UploadFile {
	/**
	 * 保存文件到本地upload文件夹下
	 * @param request
	 * @return
	 */
	public static int saveFile(HttpServletRequest request,String folderName,String fileName){
		
		int fileNum = 0;
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile>files = multipartHttpServletRequest.getFileMap();
		
/*		String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"upload/"+folderName+"/";
*/		
		String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"upload/"+folderName+"/";
		File dir = new File(uploadUrl);
		if(!dir.exists()){
			dir.mkdirs();
		}
		for (MultipartFile file : files.values()) {
			File targetFile = new File(uploadUrl+fileNum+fileName);
			if(!targetFile.exists()){
					try {
						targetFile.createNewFile();
					} catch (IOException e) {
						return 0;
					}
			}else{
					try {
						file.transferTo(targetFile);
					} catch (IllegalStateException e) {
						return 0;
					} catch (IOException e) {
						return 0;
					}
				}
			fileNum++;
			}
		return fileNum;
	}
	
/*	
	 * layui上传组建返回json格式的数据
	 
	public static HashMap<String,Object> uploadFile( HttpServletRequest request,MultipartFile items) throws IllegalStateException, IOException{
		String signDate=request.getParameter("aDate");
		DateFormat dateFormat = new DateFormat();
		String date = dateFormat.format(new Date());
		String path = "C:/HRM/upload/"+date;
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		HashMap<String,Object>  res = new HashMap<String,Object>();
		if(items!=null){
			//原始名称
			String name = items.getOriginalFilename();
			if(name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".gif")||name.endsWith(".JPG")
					||name.endsWith(".PNG")||name.endsWith(".GIF")||name.endsWith(".doc")||name.endsWith(".DOC")
					||name.endsWith(".docx")||name.endsWith(".DOCX")||name.endsWith(".pdf")||name.endsWith(".PDF")){
				//新的名称，由随机码和文件后缀拼接而成
				String newName = "DHT" + signDate+SerialUnit.serial()+name.substring(name.lastIndexOf("."));
				File file  = new File(path,newName);
				//文件上传
				items.transferTo(file);
				String url  = "/HRM/upload/"+date+"/"+newName;
				res.put("code", 0);
				res.put("msg", "");
				res.put("url", url);
			}else{
				res.put("code", 0);
				res.put("msg", "");
				res.put("url", "");
			}
		}else{
			res.put("code", 0);
			res.put("msg", "上传内容为空");
			res.put("url", "");
		}
		return res;
	}*/

	
/*	
	public static HashMap<String,Object> uploadFile( HttpServletRequest request,MultipartFile items) throws IllegalStateException, IOException{
		DateFormat dateFormat = new DateFormat();
		String date = dateFormat.format(new Date());
		String path = "C:/HRM/upload/"+date;
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		HashMap<String,Object>  res = new HashMap<String,Object>();
		if(items!=null){
			//原始名称
			String name = items.getOriginalFilename();
			if(name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".gif")||name.endsWith(".JPG")
					||name.endsWith(".PNG")||name.endsWith(".GIF")){
				//新的名称，由随机码和文件后缀拼接而成
				String newName =  UUID.randomUUID() + name.substring(name.lastIndexOf("."));
				File file  = new File(path,newName);
				//文件上传
				items.transferTo(file);
				String url  = "/HRM/upload/"+date+"/"+newName;
				res.put("code", 0);
				res.put("msg", "");
				res.put("url", url);
			}else{
				res.put("code", 0);
				res.put("msg", "");
				res.put("url", "");
			}
		}else{
			res.put("code", 0);
			res.put("msg", "上传内容为空");
			res.put("url", "");
		}
		return res;
	}*/
	/*文本编辑器上传图片*/
	public static String editUploadFile(HttpServletRequest request,MultipartFile items) throws IllegalStateException, IOException{
		DateFormat dateFormat = new DateFormat();
		String date = dateFormat.format(new Date());
		String path = "C:/HRM/upload/"+date;
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		String fileName = "";// 文件名称
		if(items!=null) {
			//原始名称
			String name = items.getOriginalFilename();
			if (name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".JPG")
					|| name.endsWith(".PNG") || name.endsWith(".GIF")) {
				//新的名称，由随机码和文件后缀拼接而成
				fileName = UUID.randomUUID() + name.substring(name.lastIndexOf("."));
				File file = new File(path, fileName);
				//文件上传
				items.transferTo(file);
			}
		}
		String url  = "/HRM/upload/"+date+"/"+fileName;
		return url;
	}

}
